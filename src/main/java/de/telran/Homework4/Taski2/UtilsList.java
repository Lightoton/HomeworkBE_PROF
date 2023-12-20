package de.telran.Homework4.Taski2;

import java.util.*;

public class UtilsList {
    public static void printElStringList(List<String> list) {
        for (String string : list) {
            System.out.println(string);
        }
    }

    public static void printSquareOfTheNumber(List<Integer> list) {
        for (int myInt : list) {
            System.out.println(myInt * myInt);
        }
    }

    public static void printCodeChar(List<Character> list) {
        for (int myChar : list) {
            System.out.println(myChar);
        }
    }

    public static void printFirstElArr(List<String[]> list) {
        for (String[] strings : list) {
            System.out.println(strings[0]);
        }
    }

    public static void printListOfStrings(List<List<String>> list) {
        for (List<String> lists : list) {
            for (String s : lists) {
                System.out.println(s);
            }
        }
    }

    public static void printEvenNumbers(List<Integer> list) {
        for (int myInt : list) {
            if (myInt % 2 == 0) {
                System.out.println(myInt);
            }
        }
    }

    public static void printWord(List<String> list, char myChar) {
        for (String s : list) {
            if (s.charAt(0) == myChar) {
                System.out.println(s);
            }
        }
    }

    public static void printVowelsQuantity(List<Character> characters) {
        int count = 0;
        for (char c : characters) {
            if (isVowel(c)) {
                count += 1;
            }
        }
        System.out.println(count);
    }

    public static boolean isVowel(char c) {
        char[] vowels = new char[]{'a', 'e', 'u', 'o', 'i', 'y'};
        c = Character.toLowerCase(c);
        for (char d : vowels) {
            if (c == d)
                return true;
        }
        return false;
    }

    public static void printLengthArr(List<String[]> list) {
        for (String[] s : list) {
            System.out.println(s.length);
        }
    }

    public static void printSumListInt(List<List<Integer>> lists) {
        int sum = 0;
        for (List<Integer> list : lists) {
            for (int arg : list) {
                sum += arg;
            }
        }
        System.out.println(sum);
    }

    public static void printSumWithCondition(List<List<Integer>> lists) {
        for (List<Integer> list : lists) {
            int sum = 0;
            for (int arg : list) {
                sum += arg;
            }
            if (sum > 10) {
                System.out.println(list);
            }
        }
    }

    public static void printCountStringWithCondition(List<String> list, int length) {
        int count = 0;
        for (String s : list) {
            if (s.length() == length) {
                count += 1;
            }
        }
        System.out.println(count);
    }

    public static void printMaxElInArr(List<Integer[]> list) {
        for (Integer[] integers : list) {
            Arrays.sort(integers);
            System.out.println(integers[integers.length - 1]);
        }
    }

    public static void printString(List<List<String>> list) {
        for (List<String> list1 : list) {
            for (String stringsOne : list1) {
                for (List<String> stringsTwo : list) {
                    for (String string : stringsTwo) {
                        System.out.println(stringsOne + " " + string);
                    }
                }
            }
        }
    }

    public static void printNumSumTen(List<Integer> list) {
        for (int num : list) {
            for (int i = 1; i < list.size(); i++) {
                if (num + list.get(i) == 10) {
                    System.out.println(num + " " + list.get(i));
                }
            }
        }
    }

    public static List<String> printUniqueElements(List<String> list) {
        LinkedList<String> newList = new LinkedList<>();
        for (int i = 0; i < list.size(); i++) {
            boolean isUnique = true;
            for (int j = 0; j < list.size(); j++) {
                if (i != j && list.get(i).compareTo(list.get(j)) == 0) {
                    isUnique = false;
                    break;
                }
            }
            if (isUnique) {
                newList.add(list.get(i));
            }
        }
        return newList;
    }

    public static List<Character> getReverseOrderCharacters(List<Character> list) {
        LinkedList<Character> linkedList = new LinkedList<>();
        for (int i = list.size(); i > 0; i--) {
            linkedList.add(list.get(i - 1));
        }
        return linkedList;
    }

    public static void printRepeatingLists(List<List<Integer>> lists) {
        for (List<Integer> list : lists) {
            boolean isRepeat = false;
            for (int i = 0; i < list.size(); i++) {
                for (int j = i + 1; j < list.size(); j++) {
                    if (i != j && list.get(i).equals(list.get(j))) {
                        isRepeat = true;
                        break;
                    }
                }
            }
            if (isRepeat) {
                System.out.println(list);
            }
        }
    }
    //Перебор List<Integer> и нахождение всех подмножеств этого списка.
    //надо сделать


    public static void printCombinationsOfStrings(List<String> list) {
        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(i).compareTo(list.get(j)) != 0) {
                    System.out.println(list.get(i) + " " + list.get(j));
                }
            }
        }
    }

    public static List<Integer> getMaxSumList(List<List<Integer>> lists) {
        int maxSum = Integer.MIN_VALUE;
        List<Integer> maxSumList = null;
        for (List<Integer> list : lists) {
            int sum = 0;
            for (int num : list) {
                sum += num;
            }
            if (sum > maxSum) {
                maxSum = sum;
                maxSumList = new ArrayList<>(list);
            }
        }
        return maxSumList;
    }

    public static void printAllPossibleOfStrings(List<Character> list) {
        for (int i = 0; i < list.size(); i++) {
            for (Character character : list) {
                System.out.println(list.get(i) + "" + character);
            }
        }
    }

}
//
//Перебор List<String> и вывод каждого элемента.--
//Перебор List<Integer> и вывод квадратов каждого числа.--
//Перебор List<Character> и вывод ASCII-кода каждого символа.--
//Перебор List<String[]> и вывод первого элемента каждого подмассива.--
//Перебор List<List<String>> и вывод всех элементов вложенных списков.--
//
//Перебор List<Integer> и вывод только четных чисел.--
//Перебор List<String> и вывод слов, начинающихся на определенную букву.--
//Перебор List<Character> и подсчет количества гласных.--
//Перебор List<String[]>, вывод длины каждого подмассива.--
//Перебор List<List<Integer>>, подсчет суммы всех чисел.--
//
//Перебор List<List<Integer>> и вывод только тех списков, сумма элементов которых больше 10.--
//Перебор List<String> и подсчет количества слов определенной длины.--
//Перебор List<Integer[]> и нахождение максимального элемента в каждом массиве.--
//Перебор List<List<String>>, вывод всех комбинаций строк из разных вложенных списков.--
//Перебор List<List<String>>, вывод всех комбинаций строк из разных вложенных списков.--
//Перебор List<Integer> и нахождение всех пар чисел, сумма которых равна 10.--
//Перебор List<String> и создание нового списка, содержащего только уникальные элементы.--
//Перебор List<Character> и перестановка элементов в обратном порядке.--
//Перебор List<List<Integer>> и вывод тех вложенных списков, которые содержат повторяющиеся элементы.--
//
//Перебор List<Integer> и нахождение всех подмножеств этого списка.++
//Перебор List<String> и создание всех возможных комбинаций строк без повторений.--
//Перебор List<List<Integer>> и нахождение списка с максимальной суммой элементов.--
//Перебор List<Character> и построение всех возможных строк из данных символов.--