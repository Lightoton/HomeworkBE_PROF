package de.telran.Homework13.task2;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Random;

public class CardGen {
    private static final Random RANDOM = new Random();
    private static int resSum;

    public static String genUniqueCardNum() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 16; i++) {
            stringBuilder.append(RANDOM.nextInt(10));
        }
        String resNumCard = stringBuilder.toString();
        if (!isTrue(resNumCard)) {
            resNumCard = fixCardNum(stringBuilder.toString());
        }
        return resNumCard;
    }

    private static boolean isTrue(String cardNum) {
        String[] strings = cardNum.split("");
        int sum1 = 0;
        int sum2 = 0;
        int arg1;
        for (int i = 0; i < strings.length; i++) {
            if (i % 2 == 0) {
                arg1 = Integer.parseInt(strings[i]) * 2;
                if (arg1 > 9) {
                    String[] res = String.valueOf(arg1).split("");
                    int num = Integer.parseInt(res[0]) + Integer.parseInt(res[1]);
                    sum1 += num;
                } else {
                    sum1 += arg1;
                }
            } else {
                sum2 += Integer.parseInt(strings[i]);
            }
        }
        resSum = sum1 + sum2;
        return resSum % 10 == 0;
    }

    private static String fixCardNum(String card) {
        String[] cardNum = card.split("");
        int delta = resSum % 10;
        int secondDigit = Integer.parseInt(cardNum[1]);
        do {
            if (delta > 5) {
                secondDigit = (secondDigit - delta + 10) % 10;
            } else {
                secondDigit = (secondDigit + delta) % 10;
            }
            cardNum[1] = String.valueOf(secondDigit);
        } while (!isTrue(String.join("", cardNum)));
        return String.join("", cardNum);
    }
    public static String getCardDate() {
        LocalDateTime dateTime = LocalDateTime.now().plusYears(RANDOM.nextLong(5 - 1) + 1);
        return dateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSSSSSSS"));
    }
    public static String getCVV(){
        return String.valueOf(RANDOM.nextInt(999-100)+100);
    }
}
