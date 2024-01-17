package de.telran.Homework7;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println(getStringLength("dsa",String::length));
        System.out.println(getStringLength("ABCD", s -> s.length()));
        System.out.println(getStringLength("abc",s -> s.length()));
        System.out.println(getOperation(5, 0,'/', (arg1, arg2, operation) -> switch (operation) {
            case '+' -> arg1 + arg2;
            case '-' -> arg1 - arg2;
            case '*' -> arg1 * arg2;
            case '/' -> {
                if (arg2 != 0) {
                    yield arg1 / arg2;
                } else {
                    System.out.println("You can't divide by zero!");
                    yield 0;
                }
            }
            default -> 0;
        }));
        System.out.println(getSafeDivision(5,2,(a,b)-> {
            if (b==0){
                return Optional.empty();
            }else {
                return Optional.of((double) a/b);
            }
        }));
        System.out.println(upperCaseConverter("fsa", String::toUpperCase));
        System.out.println(upperCaseConverter("fsa", String::toUpperCase));
        printLog(" warning!!! ", String::strip);
        int[] arr = {5,6,7,45,1,48,69,75};
        System.out.println(Arrays.toString(arr));
        transformArr(arr, arr1 -> {
            for (int i = 0; i < arr1.length; i++) {
                arr1[i] = arr1[i] * arr1[i];
            }
        });
        System.out.println(Arrays.toString(arr));
        System.out.println(getAnalyze("Hi, my name is name Viktor abc hi",s -> {
            String[] arrStr = s.split("\\P{L}+");
            int countUniqueStr = arrStr.length;
            for (int i = 0; i < arrStr.length-1; i++) {
                for (int j = 0; j < arrStr.length; j++) {
                    if (arrStr[i].equalsIgnoreCase(arrStr[j]) && i!=j){
                        countUniqueStr-=1;
                    }
                }

            }
            return countUniqueStr;
        }));
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9},
                {10, 11, 12}
        };
        int[][] resMatrix = getTransposedMatrix(matrix, matrix1 -> {
            int rows = matrix1.length;
            int columns = matrix1[0].length;
            int[][] newMatrix = new int[columns][rows];
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    newMatrix[j][i] = matrix1[i][j];
                }
            }
            return newMatrix;
        });
        for (int[] ints : resMatrix) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
        for (int[] ints : resMatrix) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
        int[] arr2 = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] resArr = processNumber(arr2,arr1 -> {
            int[] processArr = new int[arr1.length];
            for (int i = 0; i < arr1.length; i++) {
                processArr[i] = arr1[i]*-1;
            }
            return processArr;
        });
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(resArr));
        int[] arr3 = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        cyclicalShift(arr3, 2, (arr1, shift) -> {
            int length = arr1.length;
            shift = shift % length;
            int[] temp = new int[length];
            for (int i = 0; i < length; i++) {
                temp[(i - shift + length) % length] = arr1[i];
            }
            System.arraycopy(temp, 0, arr1, 0, length);
        });
        System.out.println(Arrays.toString(arr));
//        int[][] adjacencyMatrix = {
//                {0, 2, 5, 1},
//                {2, 0, 4, 0},
//                {5, 4, 0, 3},
//                {1, 0, 3, 0}
//        };
//        printFloydWarshall(adjacencyMatrix, 0, 3, ((graphMatrix, start, end) -> {
//            int numVertices = graphMatrix.length;
//            int[][] dist = new int[numVertices][numVertices];
//            int[][] prev = new int[numVertices][numVertices];
//
//            for (int i = 0; i < numVertices; i++) {
//                Arrays.fill(dist[i], Integer.MAX_VALUE);
//                Arrays.fill(prev[i], -1);
//            }
//
//            for (int i = 0; i < numVertices; i++) {
//                for (int j = 0; j < numVertices; j++) {
//                    if (graphMatrix[i][j] != Integer.MAX_VALUE) {
//                        dist[i][j] = graphMatrix[i][j];
//                        prev[i][j] = i;
//                    }
//                }
//            }
//
//            for (int k = 0; k < numVertices; k++) {
//                for (int i = 0; i < numVertices; i++) {
//                    for (int j = 0; j < numVertices; j++) {
//                        if (dist[i][k] != Integer.MAX_VALUE && dist[k][j] != Integer.MAX_VALUE
//                                && dist[i][k] + dist[k][j] < dist[i][j]) {
//                            dist[i][j] = dist[i][k] + dist[k][j];
//                            prev[i][j] = k;  // Изменено на сохранение промежуточной вершины пути
//                        }
//                    }
//                }
//            }
//
//            List<Integer> path = new ArrayList<>();
//            int current = end;
//            while (current != start) {
//                path.add(current);
//                int startVertex = prev[start][current];
//                if (startVertex == current) {
//                    System.out.println("No path between peaks " + start + " and " + end);
//                    return Collections.emptyList();
//                }
//                current = startVertex;
//            }
//            path.add(start);
//            Collections.reverse(path);
//            return path;
//        }));
    }

    public static int getStringLength(String s, StringLength stringLength) {
        return stringLength.getLength(s);

    }

    public static int getOperation(int arg1, int arg2, char operation, NumberOperation numberOperation) {
        return numberOperation.operate(arg1, arg2, operation);
    }

    public static Optional<Double> getSafeDivision(int a, int b, SafeDivision division) {
        return division.divide(a, b);
    }

    public static String upperCaseConverter(String s, UpperCaseConverter upperCaseConverter) {
        return upperCaseConverter.convert(s);
    }

    public static void printLog(String s, Logger logger) {
        System.out.println(logger.log(s));
    }

    public static void transformArr(int[] arr, ArrayTransformer arrayTransformer) {
        arrayTransformer.transform(arr);
    }

    public static int getAnalyze(String s, TextAnalyzer analyzer) {
        return analyzer.analyze(s);
    }

    public static int[][] getTransposedMatrix(int[][] matrix, MatrixProcessor matrixProcessor) {
        return matrixProcessor.process(matrix);
    }

    public static int[] processNumber(int[] arr, NumberProcessor numberProcessor) {
        return numberProcessor.process(arr);
    }

    public static void cyclicalShift(int[] arr, int shift, ArrayRotator rotator) {
        rotator.rotate(arr, shift);
    }

//    public static void printFloydWarshall(int[][] graphMatrix, int start, int end, GraphProcessor processor) {
//        List<Integer> path = processor.process(graphMatrix, start, end);
//        System.out.println("Shortest path from " + start + " to " + end + ": " + path);
//    }
}

