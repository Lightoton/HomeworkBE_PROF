package de.telran.Homework9;

import java.io.*;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Taski {
    public static void main(String[] args) {
//        groupStream("f.txt","res.txt");
//        filter("f.txt","res.txt");
//        groupPerRank("f.txt","res.txt");
//        findWithMinRank("f.txt","res.txt");
//        stat("f.txt","res.txt");
//        newName("f.txt","res.txt");
//        lowRared("f.txt", "res.txt");
//        resume("f.txt", "res.txt");
        saveTitleInString("f.txt", "res.txt");
    }



    /**
     * Прочитайте файл и посчитайте средний рейтинг всех стримов.
     * Запишите результат в новый файл.
     * <p>
     * 4: [Стрим 4], 4.8
     */

    private void readAndWrite(String readFrom, String writeTo) {
        try (BufferedReader reader = new BufferedReader(new FileReader(readFrom));
             FileWriter writer = new FileWriter(writeTo)) {
            double average =
                    reader.lines()
                            .map(str -> str.split(", ")[1])
                            .mapToDouble(Double::parseDouble)
                            .average()
                            .orElse(0.0);
            writer.write(average + "");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void filter(String in, String out) {
        try (BufferedReader reader = new BufferedReader(new FileReader(in));
             FileWriter writer = new FileWriter(out)) {
            reader.lines()
                    .filter(s ->
                            Double.parseDouble(s.split(", ")[1]) > 4.5)
                    .forEach(s -> {
                        try {
                            writer.write(s);
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //Сгруппируйте стримы по названию и запишите количество
    // стримов в каждой группе в новый файл.
    private static void groupStream(String readFrom, String writeTo) {
        try (BufferedReader reader = new BufferedReader(new FileReader(readFrom));
             FileWriter writer = new FileWriter(writeTo)) {
            reader.lines()
                    .collect(Collectors.groupingBy(s -> s.split(": ")[1].split(", ")[0]))
                    .forEach((key, value) -> {
                        try {
                            writer.write(key + ": " + value.size() + "\n");
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    });

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void groupPerRank(String readFrom, String writeTo) {
        try (BufferedReader reader = new BufferedReader(new FileReader(readFrom));
             FileWriter writer = new FileWriter(writeTo)) {
            reader.lines()
                    .sorted(Comparator.comparing(s -> Double.parseDouble(s.split(", ")[1]), Comparator.reverseOrder()))
                    .forEach(s -> {
                        try {
                            writer.write(s + "\n");
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void findWithMinRank(String readFrom, String writeTo) {
        try (BufferedReader reader = new BufferedReader(new FileReader(readFrom));
             FileWriter writer = new FileWriter(writeTo)) {
            List<String> strings = reader.lines().toList();
            double minRank = strings.stream()
                    .mapToDouble(s -> Double.parseDouble(s.split(", ")[1]))
                    .min()
                    .orElseThrow();
            strings.stream()
                    .filter(s -> Double.parseDouble(s.split(", ")[1]) == minRank)
                    .forEach(s -> {
                        try {
                            writer.write(s + "\n");
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private static void stat(String readFrom, String writeTo) {
        try (BufferedReader reader = new BufferedReader(new FileReader(readFrom));
             FileWriter writer = new FileWriter(writeTo)) {
            List<String> strings = reader.lines().toList();
            double minRank = strings.stream()
                    .mapToDouble(s -> Double.parseDouble(s.split(", ")[1]))
                    .min()
                    .orElseThrow();
            double maxRank = strings.stream()
                    .mapToDouble(s -> Double.parseDouble(s.split(", ")[1]))
                    .max()
                    .orElseThrow();
            double avrRank = strings.stream()
                    .mapToDouble(s -> Double.parseDouble(s.split(", ")[1]))
                    .average()
                    .orElseThrow();
            String res = "Минимальный: " + minRank + "\n" + "Средний: " + avrRank + "\n" + "Максимальный: " + maxRank;
            writer.write(res);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void newName(String readFrom, String writeTo) {
        try (BufferedReader reader = new BufferedReader(new FileReader(readFrom));
             FileWriter writer = new FileWriter(writeTo)) {
            reader.lines()
                    .map(s -> s.replaceAll("Стрим", "Stream-"))
                    .forEach(s -> {
                        try {
                            writer.write(s + "\n");
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void lowRared(String readFrom, String writeTo) {
        try (BufferedReader reader = new BufferedReader(new FileReader(readFrom));
             FileWriter writer = new FileWriter(writeTo)) {
            reader.lines()
                    .filter(s -> Double.parseDouble(s.split(", ")[1]) < 4.7)
                    .forEach(s -> {
                        try {
                            writer.write(s.concat(" - Low Rated") + "\n");
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void resume(String readFrom, String writeTo) {
        try (BufferedReader reader = new BufferedReader(new FileReader(readFrom));
             FileWriter writer = new FileWriter(writeTo)) {
            reader.lines()
                    .forEach(s -> {
                        try {
                            writer.write(s.split(", ")[0].split(" ")[0] + " " + s.split("]")[0].split("\\[")[1] +" - "+ s.split(", ")[1] +
                                    "\n");
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private static void saveTitleInString(String readFrom, String writeTo){
        try (BufferedReader reader = new BufferedReader(new FileReader(readFrom));
             FileWriter writer = new FileWriter(writeTo)) {
            String resStr = reader.lines()
                    .map(s -> s.split("]")[0].split("\\[")[1])
                    .collect(Collectors.joining(", "));
            writer.write(resStr);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
