package de.telran.Homework3;

import java.math.BigDecimal;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Account[] accounts = Generator.accountsGenerator(5);
        System.out.println(Arrays.toString(accounts));
        Empl[] empls = Generator.emplsGenerate(5, accounts);
        Branch[] branches = Generator.genArrBranch(empls, 4);
        Bank[] banks = Generator.genArrBank(branches, 5);
//       System.out.println(Arrays.toString(banks));

        System.out.println(Handler.sumBalances(Generator.accountsGenerator(5)));
        System.out.println(Arrays.toString(Handler.findAccountsByCurrency(Generator.accountsGenerator(5),
                Currency.EURO)));
        System.out.println(Handler.hasDebitAccounts(empls, 2));

        System.out.println(Arrays.toString(Handler.getEmployeesByCountry(empls, Country.GERMANY)));
        System.out.println(Arrays.toString(Handler.filterAccountsByBalance(accounts, BigDecimal.valueOf(55642596))));
        System.out.println(Arrays.toString(accounts));
        System.out.println(Arrays.toString(Handler.convertAccountBalances(accounts,Currency.EURO,
                BigDecimal.valueOf(1.9))));
        System.out.println(Arrays.toString(Handler.countAccountTypes(accounts)));


    }

}
