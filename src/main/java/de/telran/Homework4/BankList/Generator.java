package de.telran.Homework4.BankList;

import com.github.javafaker.Faker;
import com.github.javafaker.Name;
import com.github.javafaker.Number;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Generator {
    private static final Random RANDOM = new Random();

    //Account
    public static List<Account> accountsGenerator(int countAccount) {
        List<Account> accounts = new ArrayList<>(countAccount);
        for (int i = 0; i < countAccount; i++) {
            accounts.add(new Account(accountNumber(), randomCountryGen(), randomCurrencyGen(), isDebitRandomGen(),
                    generateRandomBalance()));
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
        Number fakeBalance = Faker.instance().number();
        return BigDecimal.valueOf(fakeBalance.randomNumber());
    }

//EMP

    public static List<Empl> emplsGenerate(int emplCount) {
        List<Empl> empls = new ArrayList<>(emplCount);
        for (int i = 0; i < emplCount; i++) {
            int numAccount = RANDOM.nextInt(5);
            empls.add(new Empl(getRandomName(), getRandomSurName(), accountsGenerator(numAccount),
                    randomCitezenshipGen()));
        }
        return empls;
    }

    private static String getRandomName() {
        Name name = Faker.instance().name();
        return name.firstName();
    }

    private static String getRandomSurName() {
        Name name = Faker.instance().name();
        return name.lastName();
    }

    private static Citezenship randomCitezenshipGen() {
        Citezenship[] citezenships = Citezenship.values();
        int i = RANDOM.nextInt(3);
        return citezenships[i];

    }

    //Branch
    public static List<Branch> genArrBranch(int branchCount) {
        List<Branch> branches = new ArrayList<>(branchCount);
        for (int i = 0; i < branchCount; i++) {
            int numEmpl = RANDOM.nextInt(5);
            branches.add(new Branch(emplsGenerate(numEmpl)));
        }
        return branches;
    }

    //Bank
    public static List<Bank> genArrBank(List<Branch> branches, int bankCount){
        List<Bank> banks = new LinkedList<>();
        for (int i = 0; i < bankCount; i++) {
            banks.add(new Bank(branches));
        }
        return banks;
    }

}




