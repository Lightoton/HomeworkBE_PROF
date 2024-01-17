package de.telran.Homework8;

import java.util.List;
import java.util.Map;

public class Start {
    public static void startCheck(List<Map<Team, Double>> teamsWithResult){
        System.out.println("Найти команду с максимальными баллами:");
        System.out.println(Handler.getTeamWithMaxResult(teamsWithResult));
        System.out.println("Подсчет общего количества баллов:");
        System.out.println(Handler.getResultsTeams(teamsWithResult));
        System.out.println("Список команд без баллов:");
        System.out.println(Handler.getLossTeams(teamsWithResult));
        System.out.println("Средний возраст участников в каждой команде:");
        System.out.println(Handler.getAverageAgeOfPlayers(teamsWithResult));
        System.out.println("Команды с баллами выше среднего:");
        Handler.printTeamsWithScoresAboveAverage(teamsWithResult);
        System.out.println("Сортировка команд по баллам: находится в Handler");
        System.out.println("Команды с определенной категорией участников: Вывести команды, где все участники принадлежат к одной категории (например, только Adult).");
        Handler.printTeamsWithASpecificCategory(teamsWithResult, TypeTeam.ADULT);
        System.out.println("Самый молодой участник среди всех команд:");
        Handler.printYoungestParticipant(teamsWithResult);
        System.out.println("Команды с победами над определенной командой: Определить команды, которые выиграли у заданной команды.");
        System.out.println(Handler.getWinsTeems(Handler.getOneRandomTeam(teamsWithResult)));
        System.out.println("Самая опытная команда: Определить команду с наибольшим суммарным возрастом участников.");
        System.out.println(Handler.getTheMostExperiencedTeam(teamsWithResult));
        System.out.println("Команды с участниками в определенном возрастном диапазоне:");
        Handler.printTeamsWithParticipantsInASpecificAgeRange(teamsWithResult,9,17);
        System.out.println("Имена участников по убыванию возраста:");
        Handler.printParticipantsName(teamsWithResult);
        System.out.println("Найти все пары команд, чьи участники имеют одинаковый суммарный возраст.");
        System.out.println(Handler.getPairsOfTeamsWhoseMembersHaveTheSameTotalAge(teamsWithResult));
        System.out.println("Вычислить средний балл для команд в каждой категории участников (Adult, Teenager, Pupil).");
        Handler.getAverageScoreForTeamsInEachCategoryOfParticipants(teamsWithResult);
        System.out.println("Выявить команды, которые не имеют проигрышей.");
        System.out.println(Handler.getTeamsThatHaveNoLosses(teamsWithResult));
        System.out.println("Сравнить две команды по средним баллам и среднему возрасту участников.");
        Handler.compareTwoTeamsByAge(Handler.getOneRandomTeam(teamsWithResult),Handler.getOneRandomTeam(teamsWithResult));
        System.out.println("Найти команды, в которых все участники имеют уникальные имена.");
        System.out.println((long) Handler.getTeamWithUniquePlayerNames(teamsWithResult).size());
        System.out.println("Определить команды с самой длинной последовательностью побед.");
        System.out.println(Handler.getTeamWithMaxCountWins(teamsWithResult));
        System.out.println("Найти команды с наибольшим количеством ничьих результатов.");
        System.out.println(Handler.getTeamsWithMaxCountDraw(teamsWithResult));
    }
}
