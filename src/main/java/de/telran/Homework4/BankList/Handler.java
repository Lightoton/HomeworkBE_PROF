package de.telran.Homework4.BankList;


import java.math.BigDecimal;
import java.util.*;


public class Handler {


    //     * Подсчёт суммы балансов
//     * Описание: Считает общую сумму балансов для массива счетов.
//     * Сигнатура: public BigDecimal sumBalances(Account[] accounts)
    public static BigDecimal sumBalances(List<Account> accounts) {
        BigDecimal sum = BigDecimal.ZERO;
        for (Account account : accounts) {
            sum = sum.add(account.getBalance());
        }
        return sum;
    }

    //Поиск счетов по валюте
//     * Описание: Возвращает все счета, имеющие определённую валюту.
//     * Сигнатура: public Account[] findAccountsByCurrency(Account[] accounts, Currency currency)
    public static List<Account> findAccountsByCurrency(List<Account> accounts, Currency currency) {
        List<Account> accounts1 =
                new ArrayList<>(accounts.size());

        for (Account account : accounts) {
            if (account.getCurrency() == currency) {
                accounts1.add(account);

            }
        }
        return accounts1;
    }


    //     * Проверка наличия дебетовых счетов
//     * Описание: Определяет, есть ли у сотрудника дебетовые счета.
//     * Сигнатура: public boolean hasDebitAccounts(Empl employee)

    public static boolean hasDebitAccounts(List<Empl> employee, int numEmp) {
        List<Account> accounts = employee.get(numEmp).getAccount();
        for (Account account : accounts) {
            if (account.isDebit()) {
                return true;
            }
        }
        return false;
    }

//     * Список сотрудников банка по стране
    //     * Описание: Возвращает список сотрудников, у которых гражданство соответствует заданной стране.
//     * Сигнатура: public Empl[] getEmployeesByCountry(Empl[] employees, Country country)

    public static List<Empl> getEmployeesByCountry(List<Empl> employees, Country country) {
        List<Empl> newEmployeesArr = new LinkedList<>();
        for (Empl employee : employees) {
            if (employee.getCitizenship().name().equals(country.name())) {
                newEmployeesArr.add(employee);
            }
        }

        return newEmployeesArr;
    }
//     * Фильтрация счетов по балансу
    //     * Описание: Возвращает счета, баланс которых выше определённой суммы.
//     * Сигнатура: public Account[] filterAccountsByBalance(Account[] accounts, BigDecimal minBalance)

    public static List<Account> filterAccountsByBalance(List<Account> accounts, BigDecimal minBalance) {
        List<Account> newAccounts = new LinkedList<>();
        for (Account account : accounts) {
            if (account.getBalance().compareTo(minBalance) > 0) {
                newAccounts.add(account);
            }
        }
        return newAccounts;
    }
    //     * Конвертация суммы счетов в другую валюту
    //     * Описание: Конвертирует баланс каждого счёта в массиве в заданную валюту по заданному курсу.
//     * Сигнатура: public BigDecimal[] convertAccountBalances(Account[] accounts, Currency toCurrency, BigDecimal rate)


    // public static BigDecimal[] convertAccountBalances почему возвращаем это, а не аккаунты???
    public static List<Account> convertAccountBalances(List<Account> accounts, Currency toCurrency, BigDecimal rate) {
        for (Account account : accounts) {
            if (account.getCurrency() != toCurrency) {
                account.setBalance(account.getBalance().multiply(rate));
            }
        }
        return accounts;
    }

    //     * Подсчёт количества счетов по типу
//     * Описание: Считает количество дебетовых и кредитных счетов в массиве счетов.
//     * Сигнатура: public int[] countAccountTypes(Account[] accounts)
    public static List<Integer> countAccountTypes(List<Account> accounts) {
        List<Integer> arrAccountTypes = new LinkedList<>();
        int isDebit = 0;
        int isCredit = 0;
        for (Account account : accounts) {
            if (account.isDebit()) {
                isDebit += 1;
            } else {
                isCredit += 1;
            }
        }
        arrAccountTypes.add(isDebit);
        arrAccountTypes.add(isCredit);
        return arrAccountTypes;
    }

    //     * Сортировка сотрудников по общему балансу
//     *
//     * Описание: Сортирует массив сотрудников по общему балансу их счетов в порядке убывания.
//     * Сигнатура: public Empl[] sortEmployeesByTotalBalance(Empl[] employees)
    public static List<Empl> sortEmployeesByTotalBalance(List<Empl> employees) {
        Collections.sort(employees,(emp1, emp2) -> {
            BigDecimal totalBalance1 = sumBalances(emp1.getAccount());
            BigDecimal totalBalance2 = sumBalances(emp2.getAccount());
            return totalBalance2.compareTo(totalBalance1);
        });
        return employees;
    }

    //     * Определение наиболее распространенной валюты среди счетов
//     *
//     * Описание: Определяет валюту, которая встречается чаще всего среди всех счетов.
//     * Сигнатура: public Currency findMostCommonCurrency(Account[] accounts)
    public static Currency findMostCommonCurrency(List<Account> accounts) {
        int countEURO = 0;
        int countSHEKEL = 0;
        int countDOLLAR = 0;
        Currency currency;
        for (Account account : accounts) {
            if (account.getCurrency().equals(Currency.EURO)) {
                countEURO += 1;
            } else if (account.getCurrency().equals(Currency.DOLLAR)) {
                countDOLLAR += 1;
            } else {
                countSHEKEL += 1;
            }
        }
        if (countEURO > countSHEKEL && countEURO > countDOLLAR) {
            currency = Currency.EURO;
        } else if (countDOLLAR > countEURO && countDOLLAR > countSHEKEL) {
            currency = Currency.DOLLAR;
        } else {
            currency = Currency.SHEKEL;
        }
        return currency;
    }

    //     *
//     * Перевод средств между счетами одного сотрудника
//     * Описание: Выполняет перевод средств между счетами в пределах списка счетов одного сотрудника.
//     * Сигнатура: public boolean transferBetweenAccounts(Account[] accounts, int fromIndex, int toIndex, BigDecimal
//     amount)
    public static boolean transferBetweenAccounts(List<Account> accounts, int fromIndex, int toIndex, BigDecimal amount) {
        boolean res = false;
        if (toIndex < accounts.size() && fromIndex < accounts.size()) {
            BigDecimal tempFrom = accounts.get(fromIndex - 1).getBalance();
            BigDecimal tempTo = accounts.get(toIndex - 1).getBalance();
            accounts.get(fromIndex - 1).setBalance(accounts.get(fromIndex - 1).getBalance().subtract(amount));
            accounts.get(toIndex - 1).setBalance(accounts.get(toIndex - 1).getBalance().add(amount));
            if (tempFrom.compareTo(accounts.get(toIndex - 1).getBalance()) > 0 && tempTo.compareTo(accounts.get(toIndex - 1).getBalance()) < 0) {
                res = true;
            }
        }
        return res;
    }

    //     * Подсчет среднего баланса счетов по каждому отделению
//     *
//     * Описание: Рассчитывает средний баланс счетов для каждого отделения банка.
//     * Сигнатура: public BigDecimal[] averageBalancePerBranch(Branch[] branches)
    public static List<BigDecimal> averageBalancePerBranch(List<Branch> branches) {
        List<BigDecimal> resBalancePerBranches = new LinkedList<>();
        for (int i = 0; i < branches.size(); i++) {
            BigDecimal resBalancePerBranch = BigDecimal.ZERO;
            int countEmployees = 0;
            for (Empl empl : branches.get(i).getEmployees()) {
                BigDecimal sumBalance = BigDecimal.ZERO;
                for (Account account : empl.getAccount()) {
                    sumBalance = sumBalance.add(account.getBalance());
                }
                BigDecimal averageBalance = BigDecimal.ZERO;
                if (!BigDecimal.ZERO.equals(sumBalance)) {
                    BigDecimal countAccount = new BigDecimal(empl.getAccount().size());
                    averageBalance = sumBalance.divide(countAccount, 2, BigDecimal.ROUND_HALF_UP);
                    countEmployees++;
                }
                resBalancePerBranch = resBalancePerBranch.add(averageBalance);
            }
            if (countEmployees != 0) {
                resBalancePerBranch = resBalancePerBranch.divide(BigDecimal.valueOf(countEmployees), 2,
                        BigDecimal.ROUND_HALF_UP);
            }
            resBalancePerBranches.add(resBalancePerBranch);
        }
        return resBalancePerBranches;
    }

    //     * Определение отделения с наибольшим количеством сотрудников-иностранцев
//     *
//     * Описание: Находит отделение с максимальным числом сотрудников не из страны, где расположен банк.
//     * Сигнатура: public Branch findBranchWithMostForeignEmployees(Branch[] branches, Country bankCountry)
    public static Branch findBranchWithMostForeignEmployees(List<Branch> branches, Country bankCountry) {
        Branch branchWithMostForeignEmployees = null;
        int maxForeignEmployees = 0;
        for (Branch branch : branches) {
            int foreignEmployeesCount = 0;
            for (Empl empl : branch.getEmployees()) {
                for (Account account : empl.getAccount()) {
                    if (account.getCountry() != bankCountry) {
                        foreignEmployeesCount++;
                    }
                }
            }
            if (foreignEmployeesCount > maxForeignEmployees) {
                maxForeignEmployees = foreignEmployeesCount;
                branchWithMostForeignEmployees = branch;
            }
        }
        return branchWithMostForeignEmployees;
    }

    //     * Генерация отчета о счетах с низким балансом
//     *
//     * Описание: Создает список счетов, баланс которых ниже определенной суммы.
//     * Сигнатура: public Account[] reportLowBalanceAccounts(Account[] accounts, BigDecimal threshold)
    public static List<Account> reportLowBalanceAccounts(List<Account> accounts, BigDecimal threshold) {
        List<Account> newAccounts = new LinkedList<>();
        for (Account account : accounts) {
            if (account.getBalance().compareTo(threshold) < 0) {
                newAccounts.add(account);
            }
        }
        return newAccounts;
    }

    //     * Создание карты сотрудников по гражданству
//     *
//     * Описание: Считает суммарный баланс счетов по всем отделениям банка.
//     * Сигнатура: public BigDecimal calculateTotalBalanceForBank(Branch[] branches)
    public static BigDecimal calculateTotalBalanceForBank(List<Branch> branches) {
        BigDecimal resBalance = BigDecimal.ZERO;
        for (Branch branch : branches) {
            for (Empl empl : branch.getEmployees()) {
                for (Account account : empl.getAccount()) {
                    resBalance = resBalance.add(account.getBalance());
                }
            }
        }
        return resBalance;
    }

//     * Определение сотрудника с наибольшим количеством счетов

    //     *
//     * Описание: Находит сотрудника с наибольшим количеством открытых счетов.
//     * Сигнатура: public Empl findEmployeeWithMostAccounts(Empl[] employees)
    public static Empl findEmployeeWithMostAccounts(List<Empl> employees) {
        Empl employeeWithMostAccounts = null;
        int maxAccount = 0;
        for (Empl empl : employees) {
            int countAccount = 0;
            for (Account account : empl.getAccount()) {
                countAccount++;
            }
            if (maxAccount < countAccount) {
                maxAccount = countAccount;
                employeeWithMostAccounts = empl;
            }
        }
        return employeeWithMostAccounts;
    }

//     * Анализ распределения типов валют среди всех счетов

//     *
//     * Описание: Распределяет сотрудников по отделениям так, чтобы загрузка по числу управляемых счетов была
//     оптимальной.
//     * Сигнатура: public void optimizeEmployeeDistribution(Branch[] branches)
//     * Моделирование финансовой сети банка
}
