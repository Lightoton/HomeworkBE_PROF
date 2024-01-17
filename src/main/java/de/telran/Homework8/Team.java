package de.telran.Homework8;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class Team {
    private String teamName;
    private TypeTeam typeTeam;
    public static final int numberOfPlayers = 4;
    public double resultDefault;
    private Player[] players;
    public int countWins;
    public int countLoss;
    public int countDraw;

}
