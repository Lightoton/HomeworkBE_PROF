package de.telran.Homework5;

import java.util.*;

public class Taski {
    public static void main(String[] args) {
//        Map<Integer, List<String>> exampleMap = new HashMap<>();
//
//        List<String> list1 = Arrays.asList("строка1", "строка2");
//        List<String> list2 = Arrays.asList("строка3", "строка4");
//
//        exampleMap.put(1, list1);
//        exampleMap.put(2, list2);
//
//        // Вызов метода для вывода данных
//        printStringForTheKey(exampleMap);

//        Map<Integer, Integer> exampleMap = new HashMap<>();
//
//        exampleMap.put(1, 10);
//        exampleMap.put(5, 30);
//        exampleMap.put(2, 20);
//        exampleMap.put(3, 50);
//        exampleMap.put(4, 40);
//
//        // Вызов метода для получения максимального значения по ключу
//        getMaxKeyValue(exampleMap);

//        Map<String, String> exampleMap = new HashMap<>();
//
//        exampleMap.put("level", "hello");
//        exampleMap.put("hello", "hello");
//        exampleMap.put("world", "dlrow");
//        exampleMap.put("java", "hello");
//
//        // Вызов метода для проверки, является ли ключ развернутой версией значения
//        boolean result = isReverse(exampleMap);
//        System.out.println(result);

//        Map<String, Integer> inputMap = new HashMap<>();
//
//        inputMap.put("one", 1);
//        inputMap.put("two", 2);
//        inputMap.put("three", 3);
//        inputMap.put("four", 4);
//
//        // Вызов метода для преобразования значений и создания новой Map
//        Map<String, String> result = getMapValueXTwo(inputMap);
//
//        // Вывод результата
//        System.out.println("Исходная Map: " + inputMap);
//        System.out.println("Преобразованная Map: " + result);

//        // Создаем карту с некоторыми данными
//        Map<Integer, List<String>> inputMap = new HashMap<>();
//        inputMap.put(1, Arrays.asList("abc", "def", "ghi"));
//        inputMap.put(2, Arrays.asList("jkl", "m", "pqr"));
//        inputMap.put(3, Arrays.asList("stu", "vwx", "yz"));
//
//        // Вызываем ваш метод для обработки входных данных
//        Map<Integer, Integer> result = getMapStringValueLength(inputMap);
//
//        // Выводим результаты
//        System.out.println("Исходная карта:");
//        System.out.println(inputMap);
//
//        System.out.println("\nРезультат после обработки методом getMapStringValueLength:");
//        System.out.println(result);

//        // Создаем карту с некоторыми данными
//        Map<Integer, Integer> inputMap = new HashMap<>();
//        inputMap.put(5, 2);  // Разница: 3 (простое)
//        inputMap.put(8, 3);  // Разница: 5 (простое)
//        inputMap.put(12, 4); // Разница: 8 (не простое)
//        inputMap.put(15, 7); // Разница: 8 (не простое)
//
//        // Вызываем ваш метод для обработки входных данных
//        Map<Integer, Integer> result = getSimpleMap(inputMap);
//
//        // Выводим результаты
//        System.out.println("Исходная карта:");
//        System.out.println(inputMap);
//
//        System.out.println("\nРезультат после обработки методом getSimpleMap:");
//        System.out.println(result);

//        Map<String, Integer> map1 = new HashMap<>();
//        map1.put("A", 1);
//        map1.put("B", 2);
//
//        Map<Integer, List<String>> map2 = new HashMap<>();
//        map2.put(1, Arrays.asList("One", "Uno", "A"));
//        map2.put(2, Arrays.asList("Two", "Dos", "C"));
//
//        printTwoMap(map1, map2);

    }

    private static int getCountMapPairs(Map<String, String> map) {
        int count = 0;
        for (Map.Entry<String, String> pairs : map.entrySet()) {
            if (pairs.getKey().length() == pairs.getValue().length()) {
                count += 1;
            }
        }
        return count;
    }

    //HashMap<String, Integer>: Подсчитайте сумму всех значений, соответствующих ключам, начинающимся на букву 'A'.
    private static int getSum(Map<String, Integer> map, char myChar) {
        int sum = 0;
        for (Map.Entry<String, Integer> pairs : map.entrySet()) {
            if (pairs.getKey().startsWith(String.valueOf(myChar))) {
                sum += pairs.getValue();
            }
        }
        return sum;
    }

    //HashMap<Integer, List<String>>: Для каждого ключа выведите все строки из соответствующего списка,
//которые начинаются с гласной буквы.
    private static void printStringForTheKey(Map<Integer, List<String>> listMap) {
        for (Map.Entry<Integer, List<String>> pairs : listMap.entrySet()) {
            System.out.println(pairs.getKey());
            for (String list : pairs.getValue()) {
                System.out.println(list);
            }
        }
    }

    //HashMap<Integer, Integer>: Найдите ключ с максимальным значением и выведите эту пару.
    private static void getMaxKeyValue(Map<Integer, Integer> map) {
        int maxKey = Integer.MIN_VALUE;
        for (Map.Entry<Integer, Integer> pairs : map.entrySet()) {
            if (pairs.getKey() > maxKey) {
                maxKey = pairs.getKey();
            }
        }
        System.out.println(maxKey + " " + map.get(maxKey));
    }

    //HashMap<String, String>: Определите, содержит ли HashMap такую пару ключ-значение, где ключ является обратной
    // строкой
//значения (например, ключ "abc", значение "cba").

    private static boolean isReverse(Map<String, String> map) {
        boolean res = false;
        for (Map.Entry<String, String> pairs : map.entrySet()) {
            StringBuilder reversedStringBuilder = new StringBuilder(pairs.getKey()).reverse();
            String reversedKey = reversedStringBuilder.toString();
            if (reversedKey.equals(pairs.getValue())) {
                res = true;
                break;
            }
        }
        return res;
    }

    //HashMap<String, Integer>: Переберите HashMap и преобразуйте его в HashMap<String, String>,
//где каждое значение - это строковое представление исходного числа, умноженного на 2.
    private static Map<String, String> getMapValueXTwo(Map<String, Integer> map) {
        Map<String, String> resMap = new HashMap<>();
        for (Map.Entry<String, Integer> pairs : map.entrySet()) {
            int resValue = pairs.getValue() * 2;
            String resValueStr = String.valueOf(resValue);
            resMap.put(pairs.getKey(), resValueStr);
        }
        return resMap;
    }

    //HashMap<Integer, List<String>>: Создайте второй HashMap<Integer, Integer>,
//где каждый ключ - это ключ из исходного HashMap, а значение - общее количество символов во всех строках списка
// этого ключа.
    private static Map<Integer, Integer> getMapStringValueLength(Map<Integer, List<String>> map) {
        Map<Integer, Integer> mapInt = new HashMap<>();
        for (Map.Entry<Integer, List<String>> pairs : map.entrySet()) {
            int sumLengthStr = 0;
            for (String s : pairs.getValue()) {
                sumLengthStr += s.length();
            }
            mapInt.put(pairs.getKey(), sumLengthStr);
        }
        return mapInt;
    }

    //HashMap<Integer, Integer>: Найдите все пары ключ-значение, где ключ минус значение является простым числом.
//
    private static Map<Integer, Integer> getSimpleMap(Map<Integer, Integer> map) {
        Map<Integer, Integer> resMap = new HashMap<>();
        for (Map.Entry<Integer, Integer> pairs : map.entrySet()) {
            if (isSimple(pairs.getKey() - pairs.getValue())) {
                resMap.put(pairs.getKey(), pairs.getValue());
            }
        }
        return resMap;
    }

    private static boolean isSimple(int number) {
        if (number <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    //HashMap<String, String>: Определите, можно ли преобразовать HashMap в List<String>,
//где каждый элемент - это конкатенация ключа и значения, так, чтобы все элементы списка были уникальными.

    private static boolean canConvertToUniqueList(Map<String, String> mapStr) {
        for (Map.Entry<String, String> pairs : mapStr.entrySet()) {
            for (Map.Entry<String, String> pairsCheck : mapStr.entrySet()) {
                if (pairs != pairsCheck && pairs.getKey().equals(pairsCheck.getKey())
                        && pairs.getValue().equals(pairsCheck.getValue())) {
                    return false;

                }
            }

        }
        return true;
    }

    //Попробовал также решить через Set, но с подсказки чата
    private static boolean canConvertToUniqueListTestHashSet(Map<String, String> mapStr) {
        Set<String> concatenatedSet = new HashSet<>();
        for (Map.Entry<String, String> pairs : mapStr.entrySet()) {
            String concatenated = pairs.getKey() + pairs.getValue();
            if (!concatenatedSet.add(concatenated)) {
                return false;
            }
        }
        return true;
    }


    //HashMap<String, Integer> и HashMap<Integer, List<String>>: Для каждого ключа в HashMap<String, Integer>
//найдите соответствующие строки в HashMap<Integer, List<String>>,
//где ключ во втором HashMap - это значение из первого, и выведите их.

    private static void printTwoMap(Map<String, Integer> map1, Map<Integer, List<String>> map2) {
        for (Map.Entry<String, Integer> pairs1 : map1.entrySet()) {
            for (Map.Entry<Integer, List<String>> pairs2 : map2.entrySet()) {
                boolean isNotUnique = false;
                for (String s : pairs2.getValue()) {
                    if (pairs2.getKey().equals(pairs1.getValue()) && pairs1.getKey().equals(s)) {
                        isNotUnique = true;
                        break;
                    }
                }
                if (isNotUnique) {
                    System.out.println("Map1: " + pairs1.getKey() + " " + pairs1.getValue()
                            + "\nMap2: " + pairs2.getKey() + " " + pairs2.getValue());
                }
            }
        }
    }

}


//

//

//

//

//

//


//
