package de.telran.homeworkTest;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class TestList {
    private static final Random RANDOM = new Random();
    public static void main(String[] args) {
        LinkedList<Integer> list =new LinkedList<>();
        for (int i = 0; i < 10_000_000; i++) {
            list.add(RANDOM.nextInt(5000));
        }

        long start = System.currentTimeMillis();
        for (int i = 0; i < 10_000_000; i++) {
            list.add(RANDOM.nextInt(500));
        }
        long end = System.currentTimeMillis();
        System.out.println(end-start);
    }
}
