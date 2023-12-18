package de.telran.Homework4.BankList;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Account> accounts = Generator.accountsGenerator(4);
        System.out.println(accounts);
        List<Empl> empls = Generator.emplsGenerate(5);


//       System.out.println(Arrays.toString(banks));

        System.out.println(Handler.sumBalances(Generator.accountsGenerator(5)));
//        System.out.println(Arrays.toString(Handler.findAccountsByCurrency(Generator.accountsGenerator(5),
//                Currency.EURO)));
//        System.out.println(Handler.hasDebitAccounts(empls, 2));
//
//        System.out.println(Handler.getEmployeesByCountry(empls, Country.GERMANY));
//        System.out.println(Handler.filterAccountsByBalance(accounts, BigDecimal.valueOf(55642596)));
//        System.out.println(accounts);
//        System.out.println(Handler.convertAccountBalances(accounts, Currency.EURO,
//                BigDecimal.valueOf(1.9)));
//        System.out.println(Handler.countAccountTypes(accounts));
//
//        System.out.println((Handler.findMostCommonCurrency(accounts)));

//        System.out.println(empls);
        System.out.println(Handler.sortEmployeesByTotalBalance(empls));
//        System.out.println(Handler.transferBetweenAccounts(accounts, 1, 5, BigDecimal.valueOf(500)));
//        System.out.println(Handler.averageBalancePerBranch(Generator.genArrBranch(5)));
//
//        System.out.println((Handler.findBranchWithMostForeignEmployees(Generator.genArrBranch(5),
//                Country.GERMANY)));
//        System.out.println(Handler.reportLowBalanceAccounts(Generator.accountsGenerator(5),
//                BigDecimal.valueOf(1000)));
//        System.out.println((Handler.calculateTotalBalanceForBank(Generator.genArrBranch(5))));
//        System.out.println((Handler.findEmployeeWithMostAccounts(Generator.emplsGenerate(5))));
//        System.out.println(Handler.findAccountsByCurrency(Generator.accountsGenerator(5), Currency.EURO));
    }


}
