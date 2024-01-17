package de.telran.Homework8;

import com.github.javafaker.Faker;

import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        List<Map<Team, Double>> teamsWithResult =Handler.resulTeam(Generator.genTeams());
        Start.startCheck(teamsWithResult);
        System.out.println("--------------------------------------------------------------");
        Handler.printReport(Handler.getOneRandomTeam(teamsWithResult));
    }
}
