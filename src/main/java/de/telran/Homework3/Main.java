package de.telran.Homework3;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Account[] accounts = Generator.accountsGenerator(5);

        System.out.println(Arrays.toString(Generator.emplsGenerate(2)));

    }

}
