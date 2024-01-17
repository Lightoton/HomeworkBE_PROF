package de.telran.HomeworkStreams;

import java.util.*;
import java.util.stream.Collectors;

public class Methods {
    public static List<String> filterByLength(List<String> input, int length) {
        return input.stream()
                .filter(s -> s.length() == length)
                .toList();
    }

    public static List<String> toUpperCase(List<String> input) {
        return input.stream()
                .peek(s -> s.toUpperCase())
                .toList();
    }

    public static Optional<String> findFirstStartingWith(List<String> input, char letter) {
        return input.stream()
                .filter(s -> s.charAt(0) == letter)
                .findFirst();
    }

    public static String joinByComma(List<String> input) {
        return String.join(", ", input);
    }

    public static long countContainingChar(List<String> input, char ch) {
        return input.stream()
                .filter(s -> s.chars().anyMatch(resChar -> resChar == ch))
                .count();
    }

    public static int sumOfList(List<Integer> input) {
        return input.stream()
                .mapToInt(Integer::intValue)
                .sum();
    }

    public static List<Integer> getSquares(List<Integer> input) {
        return input.stream()
                .map(num -> num * num)
                .toList();
    }

    public static List<Integer> filterGreaterThan(List<Integer> input, int minValue) {
        return input.stream()
                .filter(integer -> integer > minValue)
                .toList();
    }

    public static boolean containsNumber(List<Integer> input, int number) {
        return input.stream()
                .anyMatch(num -> num == number);
    }

    public static Optional<Integer> findMax(List<Integer> input) {
        return input.stream()
                .max(Comparator.comparing(Integer::intValue));
    }

    public static List<String> convertToStringList(List<Character> input) {
        return input.stream()
                .map(Object::toString)
                .toList();
    }

    public static List<Character> filterByAsciiValue(List<Character> input, int ascii) {
        return input.stream()
                .filter(character -> (int) character == ascii)
                .toList();
    }

    public static boolean areAllUpperCase(List<Character> input) {
        return input.stream()
                .allMatch(Character::isUpperCase);
    }

    public static Optional<Character> findFirstDuplicate(List<Character> input) {
        Set<Character> characters = new HashSet<>();
        return input.stream()
                .filter(character -> !characters.add(character))
                .findFirst();
    }

    public static List<Character> reverseList(List<Character> input) {
//        Collections.reverse(input);
//        return input;
        return input.stream()
                .sorted(Comparator.reverseOrder())
                .toList();
    }

    public static Optional<Float> findMin(List<Float> input) {
        return input.stream()
                .min(Comparator.comparing(Float::floatValue));
    }

    public static List<Float> multiplyBy(List<Float> input, float multiplier) {
        return input.stream()
                .map(arg -> arg * multiplier)
                .toList();
    }
    public static List<Float> filterLessThan(List<Float> input, float value){
        return input.stream()
                .filter(aFloat -> aFloat<value)
                .toList();
    }
    public static boolean containsNegative(List<Float> input){
        return input.stream()
                .anyMatch(aFloat -> aFloat<0);
    }
    public static List<Integer> roundNumbers(List<Float> input){
        return input.stream()
                .map(Math::round)
                .toList();
    }
    public static <T> long countUnique(List<T> input){
        Set<T> set = new HashSet<>();
        return input.stream()
                .filter(set::add)
                .count();
    }
    public static <T extends Comparable<T>> boolean isSorted(List<T> input){
        return input.stream()
                .sorted()
                .toList()
                .equals(input);
    }
    public static <T> Optional<T> getLastElement(List<T> input){
        return input.stream()
                .reduce((t, t2) -> t2);
    }
    public static <T> List<T> shuffleList(List<T> input){
        return input.stream()
                .collect(Collectors.collectingAndThen(Collectors.toList(),
                        list -> {
                    Collections.shuffle(list);
                    return list;
                        }));
    }
    public static <T> Map<T, Long> countFrequency(List<T> input){
        return input.stream()
                .collect(Collectors.groupingBy(t -> t, Collectors.counting()));
    }
}
// // Convert elements to strings and concatenate them, separated by commas  String joined = things.stream()    .map
// (Object::toString)    .collect(Collectors.joining(", "));