package de.telran.Homework3;

import com.github.javafaker.Faker;
import com.github.javafaker.Name;

import java.math.BigDecimal;
import java.util.Random;

public class Generator {
    private static final Random RANDOM = new Random();
//Account
    public static Account[] accountsGenerator(int countAccount) {
        Account[] accounts = new Account[countAccount];
        for (int i = 0; i < countAccount; i++) {
            accounts[i] = new Account(accountNumber(),randomCountryGen(),randomCurrencyGen(),isDebitRandomGen(),generateRandomBalance());
        }
        return accounts;
    }

    public static String accountNumber() {
        return String.valueOf(Faker.instance().random().nextLong(1000));
    }

    private static Country randomCountryGen() {
        Country[] countries = Country.values();
        int i = RANDOM.nextInt(3);
        return countries[i];

    }



    private static Currency randomCurrencyGen() {
        Currency[] currencies = Currency.values();
        int i = RANDOM.nextInt(3);
        return currencies[i];

    }

    private static boolean isDebitRandomGen() {
        boolean[] isDebit = {
                true, false
        };
        int i = RANDOM.nextInt(2);
        return isDebit[i];
    }

    private static BigDecimal generateRandomBalance() {
        long randomBalance = RANDOM.nextLong();
         return BigDecimal.valueOf(randomBalance);
    }

//EMP

    public static Empl[] emplsGenerate(int emplCount){
        Empl[] empls = new Empl[emplCount];
        for (int i = 0; i < emplCount; i++) {
            empls[i] = new Empl(getRandomName(),getRandomSurName(),accountsGenerator(emplCount),randomCitezenshipGen());
        }
        return empls;
    }

    private static String getRandomName(){
        Name name = Faker.instance().name();
        return name.firstName();
    }
    private static String getRandomSurName(){
        Name name = Faker.instance().name();
        return name.lastName();
    }

    private static Citezenship randomCitezenshipGen() {
        Citezenship[] citezenships = Citezenship.values();
        int i = RANDOM.nextInt(3);
        return citezenships[i];

    }

    //Branch
//    public static Branch[] genRandomBranch(Empl[] empls, int branchCount){
//        Branch[] branches = new Branch[branchCount];
//        for (int i = 0; i < branchCount; i++) {
//
//        }
//    }
}




