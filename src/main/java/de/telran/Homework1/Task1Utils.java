package de.telran.Homework1;

import java.util.Arrays;

public class Task1Utils {
    //     первый самый лёгкий, но не универсальный метод как по мне.
    public static int[] getMinElementEasy(int[] arr){
        int[] resArr = new int[2];
        Arrays.sort(arr);
        resArr[0] = arr[1];
        resArr[1] = arr[2];
        return resArr;
    }

    //а вот тут чуть сам не запутался, хотел решить без поиска первого минимума, но не понял как это сделать.
    public static int[] getMinElement(int[] arr) {
        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;
        int min3 = Integer.MAX_VALUE;
        for (int j : arr) {
            if (j < min1) {
                min3 = min2;
                min2 = min1;
                min1 = j;
            } else if (j < min2 && j != min1) {
                min3 = min2;
                min2 = j;

            } else if (j < min3 && j != min1 && j != min2) {
                min3 = j;
            }
        }

        return new int[]{min2, min3};

    }
}
