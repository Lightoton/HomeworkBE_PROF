package de.telran.Homework13.task1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Task1 {
    public static void main(String[] args) {
//        System.out.println(getMapCharStr());
//        System.out.println(getTheFirstLetterRecurring());
//        System.out.println(getPhoneNumbers());
//        System.out.println(getNames());
//        System.out.println(getUniqueSurnames());
//        System.out.println(getAlphabetReverseSort());
//        System.out.println(getNewFormatMap());
//        System.out.println(getAverageLengthName());
//        System.out.println(getNumberNameMap());
        findContactWithMaxAndMinLengthName();
    }

    private static Map<String, String> getMapMembers() {
        try (BufferedReader reader = new BufferedReader(new FileReader("1.txt"))) {
            return reader.lines()
                    .collect(Collectors.toMap(s -> s.split(" - ")[0], s -> s.split(" - ")[1]));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // - Метод для создания мапы, где ключ - первая буква имени, а значение - количество таких имен
    private static Map<Character, Long> getMapCharStr() {
        Map<String, String> stringMap = getMapMembers();
        return stringMap.values().stream()
                .collect(Collectors.toMap(el -> el.charAt(0),
                        s -> stringMap.values().stream().filter(el -> el.startsWith(String.valueOf(s.charAt(0))))
                                .count()
                        , (existing, replacement) -> existing));
    }

    // - Метод для нахождения самой часто встречающейся первой буквы в именах
    private static char getTheFirstLetterRecurring() {
        return getMapCharStr().entrySet().stream().max(Map.Entry.comparingByValue()).stream().map(Map.Entry::getKey).findFirst().orElseThrow();
    }

    // - Метод для создания списка номеров телефонов, где каждый номер преобразован в числовой формат
    private static List<Long> getPhoneNumbers() {
        return getMapMembers().keySet().stream()
                .map(s -> s.replaceAll("\\D", ""))
                .map(Long::valueOf)
                .toList();
    }

    // - Метод для группировки имен по длине имени
    private static List<String> getNames() {
        return getMapMembers().values().stream()
                .map(s -> s.replaceFirst("^(Mr\\.|Mrs\\.)\\s*", "").split(" ")[0])
                .collect(Collectors.groupingBy(String::length))
                .values().stream().flatMap(Collection::stream)
                .toList();
    }

    // - Метод для поиска уникальных фамилий
    private static List<String> getUniqueSurnames() {
        return getMapMembers().values().stream()
                .map(s -> s.replaceFirst("^(Mr\\.|Mrs\\.)\\s*", "").split(" ")[1])
                .collect(Collectors.toSet())
                .stream().toList();
    }


    // - Метод для создания списка имен, отсортированного в обратном алфавитном порядке
    private static List<String> getAlphabetReverseSort() {
        return getNames().stream()
                .sorted(Comparator.comparing(s -> s.charAt(0)))
                .toList().reversed();
    }


    // - Метод для преобразования данных в формат имя=номер
    private static Map<String, String> getNewFormatMap() {
        return getMapMembers().entrySet()
                .stream()
                .collect(Collectors.toMap(
                        s -> s.getValue().replaceFirst("^(Mr\\.|Mrs\\.)\\s*", "").split(" ")[0],
                        s -> s.getKey().replaceAll("\\D", ""),
                        (existing, replacement) -> existing));
    }

    // - Метод для расчета средней длины имени
    private static double getAverageLengthName() {
        return getNames().stream()
                .mapToInt(String::length)
                .average().orElse(0.0);
    }

    // - Метод для создания карты, где ключ - номер телефона, а значение - имя
    private static Map<String, String> getNumberNameMap() {
        return getMapMembers().entrySet().stream()
                .collect(Collectors.toMap(s -> s.getKey().replaceAll("\\D", ""), s -> s.getValue().replaceFirst("^(Mr" +
                        "\\" + ".|Mrs\\.)\\s*", "").split(" ")[0], (existing, replacement) -> existing));
    }

    // - Метод для поиска контактов с максимальной и минимальной длиной имени
    private static void findContactWithMaxAndMinLengthName(){
        List<String> names = getNames();
        System.out.println("Contact with minimum name length: " + names.get(0));
        System.out.println("Contact with maximum name length: " + names.get(names.size()-1));
    }
}
//getMapMembers().values().stream().filter(s -> s.startsWith(String.valueOf(s.charAt(0)))).collect(Collectors.joining
// ())))
//Написать и протестировать методы которые парсят файл 1.txt и...


