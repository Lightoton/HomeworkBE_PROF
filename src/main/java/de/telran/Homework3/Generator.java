package de.telran.Homework3;

import com.github.javafaker.Company;
import com.github.javafaker.Faker;
import com.github.javafaker.Name;
import com.github.javafaker.Number;

import java.math.BigDecimal;
import java.util.Random;

public class Generator {
    private static final Random RANDOM = new Random();

    //Account
    public static Account[] accountsGenerator(int countAccount) {
        Account[] accounts = new Account[countAccount];
        for (int i = 0; i < countAccount; i++) {
            accounts[i] = new Account(accountNumber(), randomCountryGen(), randomCurrencyGen(), isDebitRandomGen(),
                    generateRandomBalance());
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

    public static Empl[] emplsGenerate(int emplCount, Account[] accounts) {
        Empl[] empls = new Empl[emplCount];
        for (int i = 0; i < emplCount; i++) {
            empls[i] = new Empl(getRandomName(), getRandomSurName(), accounts,
                    randomCitezenshipGen());
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
    public static Branch[] genArrBranch(Empl[] empls, int branchCount) {
        Branch[] branches = new Branch[branchCount];
        for (int i = 0; i < branchCount; i++) {
            branches[i] = new Branch(empls);
        }
        return branches;
    }

    //Bank
    public static Bank[] genArrBank(Branch[] branches,int bankCount){
        Bank[] banks = new Bank[bankCount];
        for (int i = 0; i < bankCount; i++) {
            banks[i] = new Bank(branches);
        }
        return banks;
    }

}




