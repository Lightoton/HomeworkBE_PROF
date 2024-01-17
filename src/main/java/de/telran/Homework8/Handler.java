package de.telran.Homework8;

import java.util.*;
import java.util.stream.Collectors;

public class Handler {
    private static final Random random = new Random();

    public static List<Map<Team, Double>> resulTeam(List<List<Team>> teams) {
        Map<Team, Double> resultsPupil = new LinkedHashMap<>();
        Map<Team, Double> resultsTeenAger = new LinkedHashMap<>();
        Map<Team, Double> resultsAdult = new LinkedHashMap<>();
        for (List<Team> teamList : teams) {
            Game.game(teamList);
            for (Team team : teamList) {
                if (team.getTypeTeam() == TypeTeam.PUPIL)
                    resultsPupil.put(team, team.getResultDefault());
                else if (team.getTypeTeam() == TypeTeam.TEENAGER) {
                    resultsTeenAger.put(team, team.getResultDefault());
                } else if (team.getTypeTeam() == TypeTeam.ADULT) {
                    resultsAdult.put(team, team.getResultDefault());
                }
            }
        }
        sortResult(resultsPupil);
        sortResult(resultsTeenAger);
        sortResult(resultsAdult);
//        Game.getUniqueResult(resultsPupil);
//        Game.getUniqueResult(resultsTeenAger);
//        Game.getUniqueResult(resultsAdult);
//        sortResult(resultsPupil);
//        sortResult(resultsTeenAger);
//        sortResult(resultsAdult);
        while (isNotUniqueResult(resultsPupil)) {
            Game.getUniqueResult(resultsPupil);
            sortResult(resultsPupil);
        }
        while (isNotUniqueResult(resultsTeenAger)) {
            Game.getUniqueResult(resultsTeenAger);
            sortResult(resultsTeenAger);
        }
        while (isNotUniqueResult(resultsAdult)) {
            Game.getUniqueResult(resultsAdult);
            sortResult(resultsAdult);
        }
        List<Map<Team, Double>> teamsMap = new LinkedList<>();
        teamsMap.add(resultsPupil);
        teamsMap.add(resultsTeenAger);
        teamsMap.add(resultsAdult);
        return teamsMap;
    }

    public static void sortResult(Map<Team, Double> results) {
        Map<Team, Double> resultSorted = results.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (el1, el2) -> el1,
                        LinkedHashMap::new
                ));
        results.clear();
        results.putAll(resultSorted);
    }

    private static boolean isNotUniqueResult(Map<Team, Double> team) {
        List<Team> list = team.keySet().stream().toList();
        boolean isUniq = true;
        for (int i = 0; i < 5; i++) {
            for (int j = i + 1; j <= 5; j++) {
                if (list.get(i).getResultDefault() == list.get(j).getResultDefault()) {
                    isUniq = false;
                    break;
                }
            }
        }
        return !isUniq;
    }

    public static Team getTeamWithMaxResult(List<Map<Team, Double>> mapTeams) {
        //        Team teamMaxResult = mapTeams.get(0).keySet().iterator().next();
//        for (Map<Team,Double> teamsResult : mapTeams) {
//            if (teamsResult.keySet().iterator().next().getResultDefault() > teamMaxResult.getResultDefault()){
//                teamMaxResult = teamsResult.keySet().iterator().next();
//            }
//        }
        return mapTeams.stream()
                .filter(teamResult -> !teamResult.isEmpty())
                .map(teamResult -> teamResult.keySet().iterator().next())
                .reduce((team, team2) ->
                        team.getResultDefault() > team2.getResultDefault() ? team : team2)
                .orElse(null);
    }

    public static double getResultsTeams(List<Map<Team, Double>> mapTeams) {
        return mapTeams.stream()
                .filter(teamDoubleMap -> !teamDoubleMap.isEmpty())
                .flatMapToDouble(mapTeamsRes -> mapTeamsRes.values().stream()
                        .mapToDouble(Double::doubleValue))
                .sum();
    }

    public static List<Team> getLossTeams(List<Map<Team, Double>> mapTeams) {
        return mapTeams.stream()
                .filter(teamDoubleMap -> !teamDoubleMap.isEmpty())
                .map(teamResult -> teamResult.keySet().iterator().next())
                .filter(team -> team.getResultDefault() == 0)
                .toList();
    }

    public static double getAverageAgeOfPlayers(List<Map<Team, Double>> mapTeams) {
        double agesTeams = mapTeams.stream()
                .filter(teamDoubleMap -> !teamDoubleMap.isEmpty())
                .mapToDouble(teamAge -> Arrays.stream(teamAge.keySet().iterator().next().getPlayers()).iterator()
                        .next().getAge())
                .sum();
        double countTeams =
                Arrays.stream(mapTeams.stream().map(Map::keySet).iterator().next().stream().iterator().next().getPlayers()).count();
//        System.out.println(agesTeams);
//        System.out.println(countTeams);
        return agesTeams / countTeams;
    }

    public static void printTeamsWithScoresAboveAverage(List<Map<Team, Double>> mapTeams) {
        double averageMark = getTeamWithMaxResult(mapTeams).getResultDefault() / 2;
        System.out.println(averageMark);
        mapTeams.stream()
                .filter(teamDoubleMap -> !teamDoubleMap.isEmpty())
                .map(Map::keySet)
                .filter(teams -> teams.iterator().next().getResultDefault() > averageMark)
                .forEach(System.out::println);
    }

    public static void printTeamsWithASpecificCategory(List<Map<Team, Double>> mapTeams, TypeTeam type) {
        mapTeams.stream()
                .filter(teamDoubleMap -> !teamDoubleMap.isEmpty())
                .filter(teamDoubleMap -> teamDoubleMap.keySet().iterator().next().getTypeTeam().equals(type))
                .forEach(System.out::println);
    }

    public static void printYoungestParticipant(List<Map<Team, Double>> mapTeams) {
        Optional<Player> youngestPlayer = mapTeams.stream()
                .filter(teamDoubleMap -> !teamDoubleMap.isEmpty())
                .flatMap(teamDoubleMap -> teamDoubleMap.keySet().stream())
                .flatMap(team -> Arrays.stream(team.getPlayers()))
                .min(Comparator.comparingInt(Player::getAge));
        youngestPlayer.ifPresent(System.out::println);
    }

    public static List<Team> getWinsTeems(Team teem) {
        List<Team> winsTeems = new ArrayList<>();
        for (Team team : Game.gameHistory.values()) {
            if (team.getTeamName().equals(team.getTeamName())) {
                winsTeems.add(team);
            }
        }
        return winsTeems;
    }

    public static Team getTheMostExperiencedTeam(List<Map<Team, Double>> mapTeams) {
        Team mostExperiencedTeam = null;
        int maxTotalAge = 0;
        for (Map<Team, Double> teamDoubleMap : mapTeams) {
            if (!teamDoubleMap.isEmpty()) {
                Team team = teamDoubleMap.keySet().iterator().next();
                int totalAge = 0;
                for (Player player : team.getPlayers()) {
                    totalAge += player.getAge();
                }
                if (totalAge > maxTotalAge) {
                    maxTotalAge = totalAge;
                    mostExperiencedTeam = team;
                }
            }
        }
        return mostExperiencedTeam;
    }

    public static void printTeamsWithParticipantsInASpecificAgeRange(List<Map<Team, Double>> mapTeams, int minAge,
                                                                     int maxAge) {
        mapTeams.stream()
                .filter(teamDoubleMap -> !teamDoubleMap.isEmpty())
                .filter(teamDoubleMap -> {
                    Team team = teamDoubleMap.keySet().iterator().next();
                    return Arrays.stream(team.getPlayers())
                            .allMatch(player -> player.getAge() > minAge && player.getAge() < maxAge);
                })
                .forEach(teamDoubleMap -> {
                    Team team = teamDoubleMap.keySet().iterator().next();
                    System.out.println(team);
                });
    }

    public static void printParticipantsName(List<Map<Team, Double>> mapTeams) {
        List<Player> players = new ArrayList<>();
        for (Map<Team, Double> teams : mapTeams) {
            List<Team> teamsList = teams.keySet().stream().toList();
            for (Team team : teamsList) {
                players.add(Arrays.stream(team.getPlayers()).toList().stream().iterator().next());
            }
        }
        List<Player> resPlayers = players.stream().sorted(Comparator.comparing(Player::getAge).reversed()).toList();
        System.out.println(resPlayers);
    }

    public static Map<Team, Integer> getPairsOfTeamsWhoseMembersHaveTheSameTotalAge(List<Map<Team, Double>> mapTeams) {
        List<Team> teams = new ArrayList<>();
        Map<Team, Integer> resTeams = new LinkedHashMap<>();
        for (Map<Team, Double> team : mapTeams) {
            teams.addAll(team.keySet());
        }
        for (int i = 0; i < teams.size(); i++) {
            for (int j = i + 1; j < teams.size(); j++) {
                int sumTeam1 = Arrays.stream(teams.get(i).getPlayers()).mapToInt(Player::getAge).sum();
                int sumTeam2 = Arrays.stream(teams.get(j).getPlayers()).mapToInt(Player::getAge).sum();
                if (sumTeam1 == sumTeam2) {
                    resTeams.put(teams.get(i), sumTeam1);
                    resTeams.put(teams.get(j), sumTeam2);
                }
            }
        }
        return resTeams;
    }

    public static void getAverageScoreForTeamsInEachCategoryOfParticipants(List<Map<Team, Double>> mapTeams) {
        Map<TypeTeam, Double> averageScore = new LinkedHashMap<>();
        for (Map<Team, Double> teamsMap : mapTeams) {
            averageScore.put(teamsMap.keySet().iterator().next().getTypeTeam(),
                    teamsMap.keySet().stream().mapToDouble(Team::getResultDefault).sum() / 25);
        }
        System.out.println(averageScore);
    }

    public static List<Team> getTeamsThatHaveNoLosses(List<Map<Team, Double>> mapTeams) {
        return mapTeams.stream()
                .flatMap(teamDoubleMap -> teamDoubleMap.keySet().stream())
                .filter(team -> team.getResultDefault() > 0)
                .toList();

    }

    public static void compareTwoTeamsByAge(Team team1, Team team2) {
        double averageAgeOfPlayersOfTheTeam1 =
                Arrays.stream(team1.getPlayers()).mapToDouble(Player::getAge).average().orElse(0);
        double averageAgeOfPlayersOfTheTeam2 =
                Arrays.stream(team2.getPlayers()).mapToDouble(Player::getAge).average().orElse(0);
        if (averageAgeOfPlayersOfTheTeam1 > averageAgeOfPlayersOfTheTeam2 && team1.getResultDefault() > team2.getResultDefault()) {
            System.out.println("Средний возраст и кол-во баллов: " + team1.getTeamName() + " больше чем у команды " + team2.getTeamName());
        } else if (averageAgeOfPlayersOfTheTeam1 > averageAgeOfPlayersOfTheTeam2 && team1.getResultDefault() < team2.getResultDefault()) {
            System.out.println("Средний возраст: " + team1.getTeamName() + " больше чем у команды " + team2.getTeamName() + ", но баллов меньше");
        } else if (averageAgeOfPlayersOfTheTeam1 < averageAgeOfPlayersOfTheTeam2 && team1.getResultDefault() < team2.getResultDefault()) {
            System.out.println("Средний возраст и кол-во баллов: " + team2.getTeamName() + " больше чем у команды " + team1.getTeamName());
        } else {
            System.out.println("Средний возраст: " + team2.getTeamName() + " больше чем у команды " + team1.getTeamName() + ", но баллов меньше");
        }
    }

    public static Team getOneRandomTeam(List<Map<Team, Double>> mapTeams) {
        return mapTeams.get(random.nextInt(3)).keySet().stream().toList().get(random.nextInt(25));
    }

    public static List<Team> getTeamWithUniquePlayerNames(List<Map<Team, Double>> mapTeams) {
        return mapTeams.stream()
                .filter(teamDoubleMap -> teamDoubleMap.keySet().stream()
                        .allMatch(team -> Arrays.stream(team.getPlayers())
                                .map(Player::getName)
                                .distinct()
                                .count() == team.getPlayers().length))
                .flatMap(teamDoubleMap -> teamDoubleMap.keySet().stream())
                .collect(Collectors.toList());
    }

    public static List<Team> getTeamWithMaxCountWins(List<Map<Team, Double>> mapTeams) {
        int maxCountWinsRes = mapTeams.stream()
                .flatMapToInt(teamDoubleMap -> teamDoubleMap.keySet().stream()
                        .mapToInt(Team::getCountWins))
                .max()
                .orElse(0);

        return mapTeams.stream()
                .flatMap(teamDoubleMap -> teamDoubleMap.keySet().stream()
                        .filter(team -> team.getCountWins() == maxCountWinsRes))
                .toList();

    }

    public static List<Team> getTeamsWithMaxCountDraw(List<Map<Team, Double>> mapTeams) {
        int maxCountDrawRes = mapTeams.stream()
                .flatMapToInt(teamDoubleMap -> teamDoubleMap.keySet().stream()
                        .mapToInt(Team::getCountDraw))
                .max()
                .orElse(0);
        return mapTeams.stream()
                .flatMap(teamDoubleMap -> teamDoubleMap.keySet().stream()
                        .filter(team -> team.getCountDraw() == maxCountDrawRes))
                .toList();
    }

    public static void printReport(Team team) {
        System.out.println("Средний возраст в команде " + team.getTeamName() + ": " + Arrays.stream(team.getPlayers()).mapToDouble(Player::getAge).average().orElse(0));
        System.out.println("Общее количество баллов: " + team.getResultDefault());
        System.out.println("Победная серия: " + team.getCountWins());
    }
}


//