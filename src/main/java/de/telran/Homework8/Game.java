package de.telran.Homework8;

import java.util.*;

public class Game {
    public static Map<Team, Team> gameHistory = new HashMap<>();

    public static void game(List<Team> team) {
        for (int i = 0; i < team.size(); i++) {
            for (int j = i + 1; j < team.size(); j++) {
                if (getRandomResult() == Result.WIN) {
                    team.get(i).setResultDefault(team.get(i).getResultDefault() + 1);
                    team.get(i).setCountWins(team.get(i).getCountWins() + 1);
                    team.get(j).setCountLoss(team.get(j).getCountLoss() + 1);
                    saveGameHistory(team.get(i), team.get(j));
                } else if (getRandomResult() == Result.DRAW) {
                    team.get(i).setResultDefault(team.get(i).getResultDefault() + 0.5);
                    team.get(j).setResultDefault(team.get(j).getResultDefault() + 0.5);
                    team.get(i).setCountDraw(team.get(i).getCountDraw() + 1);
                    team.get(j).setCountDraw(team.get(j).getCountDraw() + 1);
                } else {
                    team.get(j).setResultDefault(team.get(j).getResultDefault() + 1.0);//if (getRandomResult() ==
                    // Result.LOSS)
                    team.get(j).setCountWins(team.get(j).getCountWins() + 1);
                    team.get(i).setCountLoss(team.get(i).getCountLoss() + 1);
                    saveGameHistory(team.get(j), team.get(i));
                }
            }
        }
    }

    private static Result getRandomResult() {
        Random random = new Random();
        Result[] results = Result.values();
        int index = random.nextInt(3);
        return results[index];
    }

    public static void getUniqueResult(Map<Team, Double> teamResult) {
        List<Team> results = new ArrayList<>(teamResult.keySet());
        for (int i = 0; i < 5; i++) {
            for (int j = i + 1; j <= 5; j++) {
                if (results.get(i).getResultDefault() == (results.get(j).getResultDefault())) {
                    gameFinal(results.get(i), results.get(j));

                    teamResult.put(results.get(i), results.get(i).getResultDefault());
                    teamResult.put(results.get(j), results.get(j).getResultDefault());
                }

            }
        }
    }


    private static void gameFinal(Team team1, Team team2) {
        Result randomResult = getRandomResult();
        if (randomResult == Result.WIN) {
            team1.setResultDefault(team1.getResultDefault() + 1);
            team1.setCountWins(team1.getCountWins() + 1);
            team2.setCountLoss(team2.getCountLoss() + 1);
        } else if (randomResult == Result.DRAW) {
            team1.setResultDefault(team1.getResultDefault() + 0.5);
            team2.setResultDefault(team2.getResultDefault() + 0.5);
            gameFinal(team1, team2);
        } else {
            team2.setResultDefault(team2.getResultDefault() + 1);
            team2.setCountWins(team2.getCountWins() + 1);
            team1.setCountLoss(team1.getCountLoss() + 1);
        }
    }

    //    private static boolean isCollisionResolved(List<Team> results, int i, int j) {
//        return !(results.get(i).getResultDefault()==(results.get(j).getResultDefault()));
//    }
    private static void saveGameHistory(Team teamWin, Team teamLoss) {
        gameHistory.put(teamWin, teamLoss);
    }
}
