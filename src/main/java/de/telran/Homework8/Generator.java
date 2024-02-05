package de.telran.Homework8;

import com.github.javafaker.Faker;
import de.telran.Homework13.task2.CardGen;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Generator {
    private static final Faker FAKER = new Faker();
    private static final Random RANDOM = new Random();

    public static List<List<Team>> genTeams() {
        List<Team> teamPupil = new ArrayList<>(25);
        List<Team> teamAdult = new ArrayList<>(25);
        List<Team> teamTeen = new ArrayList<>(25);
        for (int i = 0; i < 75; i++) {
            if (i <= 25) {
                teamPupil.add(new Team(FAKER.team().name(), TypeTeam.PUPIL, 0, getPlayers(10, 18),0,0,0));
            } else if (i <= 50) {
                teamTeen.add(new Team(FAKER.team().name(), TypeTeam.TEENAGER, 0, getPlayers(18, 25),0,0,0));
            } else {
                teamAdult.add(new Team(FAKER.team().name(), TypeTeam.ADULT, 0, getPlayers(25, 45),0,0,0));
            }
        }
        List<List<Team>> teams = new ArrayList<>();
        teams.add(teamPupil);
        teams.add(teamTeen);
        teams.add(teamAdult);
        return teams;
    }

    private static Player[] getPlayers(int minAge, int maxAge) {
        Player[] players = new Player[Team.numberOfPlayers];
        for (int i = 0; i < players.length; i++) {
            players[i] = new Player(FAKER.name().name(), RANDOM.nextInt(maxAge - minAge) + minAge,
                    new BankCard(CardGen.genUniqueCardNum(),CardGen.getCardDate(),CardGen.getCVV()));
        }
        return players;
    }

}
