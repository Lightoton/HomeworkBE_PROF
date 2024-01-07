package de.telran.homeworkTest;

import java.util.Arrays;

@FunctionalInterface
interface GraphProcessor {
    Result process(int[][] adjacencyMatrix, int startVertex, int endVertex);

    class Result {
        int[][] distances;
        int[][] predecessors;

        public Result(int[][] distances, int[][] predecessors) {
            this.distances = distances;
            this.predecessors = predecessors;
        }
    }
}

public class FloydWarshallAlgorithm {

    public static void main(String[] args) {
        // Пример использования
        int[][] adjacencyMatrix = {
                {0, 3, Integer.MAX_VALUE, 7},
                {8, 0, 2, Integer.MAX_VALUE},
                {5, Integer.MAX_VALUE, 0, 1},
                {2, Integer.MAX_VALUE, Integer.MAX_VALUE, 0}
        };

        int startVertex = 0;
        int endVertex = 2;

        GraphProcessor graphProcessor = FloydWarshallAlgorithm::findShortestPath;

        GraphProcessor.Result result = graphProcessor.process(adjacencyMatrix, startVertex, endVertex);

        // Вывод результата
        System.out.println("Shortest distance from " + startVertex + " to " + endVertex + ": " + result.distances[startVertex][endVertex]);
        System.out.println("Shortest path: " + getPath(result.predecessors, startVertex, endVertex));
    }

    private static GraphProcessor.Result findShortestPath(int[][] adjacencyMatrix, int startVertex, int endVertex) {
        int n = adjacencyMatrix.length;
        int[][] distance = new int[n][n];
        int[][] predecessors = new int[n][n];

        // Инициализация матрицы расстояний и предшествующих вершин
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                distance[i][j] = adjacencyMatrix[i][j];
                if (i != j && adjacencyMatrix[i][j] != Integer.MAX_VALUE) {
                    predecessors[i][j] = i;
                } else {
                    predecessors[i][j] = -1; // -1 означает отсутствие предшествующей вершины
                }
            }
        }

        // Алгоритм Флойда-Уоршелла
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (distance[i][k] != Integer.MAX_VALUE && distance[k][j] != Integer.MAX_VALUE
                            && distance[i][k] + distance[k][j] < distance[i][j]) {
                        distance[i][j] = distance[i][k] + distance[k][j];
                        predecessors[i][j] = predecessors[k][j];
                    }
                }
            }
        }

        return new GraphProcessor.Result(distance, predecessors);
    }

    private static String getPath(int[][] predecessors, int startVertex, int endVertex) {
        StringBuilder path = new StringBuilder();
        int currentVertex = endVertex;

        while (currentVertex != startVertex) {
            int predecessor = predecessors[startVertex][currentVertex];
            if (predecessor == -1) {
                return "No path found";
            }

            path.insert(0, " -> " + currentVertex);
            currentVertex = predecessor;
        }

        path.insert(0, startVertex);
        return path.toString();
    }
}
