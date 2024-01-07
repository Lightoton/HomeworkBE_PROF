package de.telran.Homework7;

import java.util.List;

@FunctionalInterface
public interface GraphProcessor {
    List<Integer> process(int[][] graphMatrix, int start, int end);
}
