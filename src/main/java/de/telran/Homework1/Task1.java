package de.telran.Homework1;

import java.util.Arrays;

public class Task1 {
    public static void main(String[] args) {
        int[] arr1 = {12, 3, 4, 5, 67, 89};
        System.out.println(Arrays.toString(Task1Utils.getMinElementEasy(arr1)));
        System.out.println(Arrays.toString(Task1Utils.getMinElement(arr1)));

    }


}
//найти второй и третий по минимальности элемент в массиве.