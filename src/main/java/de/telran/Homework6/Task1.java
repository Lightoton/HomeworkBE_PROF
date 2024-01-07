package de.telran.Homework6;

import java.util.*;

public class Task1 {
    public static void main(String[] args) {
//        Map<String, Integer> originalMap = new HashMap<>();
//        originalMap.put("Alice", 25);
//        originalMap.put("Bob", 30);
//        originalMap.put("Charlie", 35);
//
//        getNewMapPlusAge(originalMap);
//        System.out.println(originalMap);

//        Map<Integer, String> originalMap = new HashMap<>();
//        originalMap.put(105, "Alice");
//        originalMap.put(90, "Bob");
//        originalMap.put(120, "Charlie");
//        originalMap.put(80, "David");
//        originalMap.put(110, "Eve");
//        originalMap.put(130, "Frank");
//        System.out.println(sortMap(originalMap));
        User user = new User("Alice",45);
        User user1 = new User("Bob",30);
        User user2 = new User("Charlie", 35);
        TreeMap<User, String> originalMap = new TreeMap<>();
        originalMap.put(user, null);
        originalMap.put(user1, null);
        originalMap.put(user2,null);
//        Collections.sort(originalMap,new UserComparator());
//        for (Map.Entry<User,String> pairs: originalMap.entrySet()) {
//            System.out.println(pairs.getKey());
//        }

//        UserNew user = new UserNew("Charlie", 45);
//        UserNew user1 = new UserNew("Bob", 30);
//        UserNew user2 = new UserNew("Alice", 35);
//        TreeMap<UserNew, String> originalMap = new TreeMap<>();
//        originalMap.put(user, null);
//        originalMap.put(user1, null);
//        originalMap.put(user2, null);
//        for (Map.Entry<UserNew, String> pairs : originalMap.entrySet()) {
//            System.out.println(pairs.getKey());
//        }
//
    }

    private static void getNewMapPlusAge(Map<String, Integer> map) {
        for (Map.Entry<String, Integer> pairs : map.entrySet()) {
            pairs.setValue(pairs.getValue() * 2);
        }
    }

    private static TreeMap<Integer, String> sortMap(Map<Integer, String> map) {
        TreeMap<Integer, String> treeMap = new TreeMap<>();
        for (Map.Entry<Integer, String> pairs : map.entrySet()) {
            if (pairs.getKey() > 100) {
                treeMap.put(pairs.getKey(), pairs.getValue());
            }
        }
        return treeMap;
    }
}
class UserComparator implements Comparator<User>{
    @Override
    public int compare(User o1, User o2) {
        return o1.getAge()-o2.getAge();
    }
}
