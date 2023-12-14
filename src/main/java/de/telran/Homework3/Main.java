package de.telran.Homework3;

import java.math.BigDecimal;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Account[] accounts = Generator.accountsGenerator(4);
        System.out.println(Arrays.toString(accounts));
        Empl[] empls = Generator.emplsGenerate(5);


//       System.out.println(Arrays.toString(banks));

        System.out.println(Handler.sumBalances(Generator.accountsGenerator(5)));
//        System.out.println(Arrays.toString(Handler.findAccountsByCurrency(Generator.accountsGenerator(5),
//                Currency.EURO)));
//        System.out.println(Handler.hasDebitAccounts(empls, 2));
//
        System.out.println(Arrays.toString(Handler.getEmployeesByCountry(empls, Country.GERMANY)));
        System.out.println(Arrays.toString(Handler.filterAccountsByBalance(accounts, BigDecimal.valueOf(55642596))));
        System.out.println(Arrays.toString(accounts));
        System.out.println(Arrays.toString(Handler.convertAccountBalances(accounts,Currency.EURO,
                BigDecimal.valueOf(1.9))));
        System.out.println(Arrays.toString(Handler.countAccountTypes(accounts)));

        System.out.println((Handler.findMostCommonCurrency(accounts)));

        System.out.println(Arrays.toString(empls));
        System.out.println(Arrays.toString(Handler.sortEmployeesByTotalBalance(empls)));
        System.out.println(Handler.transferBetweenAccounts(accounts, 1, 5, BigDecimal.valueOf(500)));
        System.out.println(Arrays.toString(Handler.averageBalancePerBranch(Generator.genArrBranch(5))));

        System.out.println((Handler.findBranchWithMostForeignEmployees(Generator.genArrBranch(5),
                Country.GERMANY)));
        System.out.println(Arrays.toString(Handler.reportLowBalanceAccounts(Generator.accountsGenerator(5),
                BigDecimal.valueOf(1000))));
        System.out.println((Handler.calculateTotalBalanceForBank(Generator.genArrBranch(5))));
        System.out.println((Handler.findEmployeeWithMostAccounts(Generator.emplsGenerate(5))));
        System.out.println(Arrays.toString(Handler.findAccountsByCurrency(Generator.accountsGenerator(5), Currency.EURO)));
    }


}
