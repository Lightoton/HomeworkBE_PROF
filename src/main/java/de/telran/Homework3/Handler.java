package de.telran.Homework3;



import java.math.BigDecimal;
import java.util.Arrays;


public class Handler {


    //     * Подсчёт суммы балансов
//     * Описание: Считает общую сумму балансов для массива счетов.
//     * Сигнатура: public BigDecimal sumBalances(Account[] accounts)
    public static BigDecimal sumBalances(Account[] accounts) {
        BigDecimal sum = BigDecimal.valueOf(0);
        for (Account account : accounts) {
            sum = sum.add(account.getBalance());
        }
        return sum;
    }

    //Поиск счетов по валюте
//     * Описание: Возвращает все счета, имеющие определённую валюту.
//     * Сигнатура: public Account[] findAccountsByCurrency(Account[] accounts, Currency currency)
    public static Account[] findAccountsByCurrency(Account[] accounts, Currency currency) {
        Account[] accounts1 = new Account[accounts.length];
        int count = 0;
        for (Account account : accounts) {
            if (account.getCurrency() == currency) {
                accounts1[count] = account;
                count += 1;
            }
        }
        return Arrays.copyOf(accounts1, count);
    }


    //     * Проверка наличия дебетовых счетов
//     * Описание: Определяет, есть ли у сотрудника дебетовые счета.
//     * Сигнатура: public boolean hasDebitAccounts(Empl employee)

    public static boolean hasDebitAccounts(Empl[] employee, int numEmp) {
        Account[] accounts = employee[numEmp - 1].getAccount();
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

    public static Empl[] getEmployeesByCountry(Empl[] employees, Country country) {
        Empl[] newEmployeesArr = new Empl[100];
        int indexNewAc = 0;

        for (Empl employee : employees) {
            if (employee.getCitizenship().name().equals(country.name())) {
                newEmployeesArr[indexNewAc] = employee;
                indexNewAc++;
            }
        }

        return Arrays.copyOf(newEmployeesArr, indexNewAc);
    }
//     * Фильтрация счетов по балансу
    //     * Описание: Возвращает счета, баланс которых выше определённой суммы.
//     * Сигнатура: public Account[] filterAccountsByBalance(Account[] accounts, BigDecimal minBalance)

    public static Account[] filterAccountsByBalance(Account[] accounts, BigDecimal minBalance) {
        int countFilter = 0;
        Account[] newAccounts = new Account[accounts.length];
        for (Account account : accounts) {
            if (account.getBalance().compareTo(minBalance) > 0) {
                for (int j = 0; j < newAccounts.length; j++) {
                    newAccounts[j] = account;
                    countFilter++;
                }
            }
        }
        return Arrays.copyOf(newAccounts, countFilter);
    }
    //     * Конвертация суммы счетов в другую валюту
    //     * Описание: Конвертирует баланс каждого счёта в массиве в заданную валюту по заданному курсу.
//     * Сигнатура: public BigDecimal[] convertAccountBalances(Account[] accounts, Currency toCurrency, BigDecimal rate)


    // public static BigDecimal[] convertAccountBalances почему возвращаем это, а не аккаунты???
    public static Account[] convertAccountBalances(Account[] accounts, Currency toCurrency, BigDecimal rate) {
//        Account[] newAccountsArr = new Account[accounts.length];
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
    public static int[] countAccountTypes(Account[] accounts) {
        int[] arrAccountTypes = {0, 0};
        for (Account account : accounts) {
            if (account.isDebit()) {
                arrAccountTypes[0] += 1;
            } else {
                arrAccountTypes[1] += 1;
            }
        }
        return arrAccountTypes;
    }

    //     * Сортировка сотрудников по общему балансу пока до конца не работает
//     *
//     * Описание: Сортирует массив сотрудников по общему балансу их счетов в порядке убывания.
//     * Сигнатура: public Empl[] sortEmployeesByTotalBalance(Empl[] employees)
    public static Empl[] sortEmployeesByTotalBalance(Empl[] employees) {
        Empl[] newEmployeesArr = Arrays.copyOf(employees, employees.length);
        for (int i = 0; i < employees.length; i++) {
            for (int j = 0; j < employees.length - i - 1; j++) {
                BigDecimal totalBalance1 = sumBalances(employees[j].getAccount());
                BigDecimal totalBalance2 = sumBalances(employees[j + 1].getAccount());

                if (totalBalance1.compareTo(totalBalance2) < 0) {
                    Empl temp = newEmployeesArr[j];
                    newEmployeesArr[j] = newEmployeesArr[j + 1];
                    newEmployeesArr[j + 1] = temp;
                }
            }
        }
        return newEmployeesArr;
    }

    //     * Определение наиболее распространенной валюты среди счетов
//     *
//     * Описание: Определяет валюту, которая встречается чаще всего среди всех счетов.
//     * Сигнатура: public Currency findMostCommonCurrency(Account[] accounts)
    public static Currency findMostCommonCurrency(Account[] accounts) {
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
    public static boolean transferBetweenAccounts(Account[] accounts, int fromIndex, int toIndex, BigDecimal amount) {
        boolean res = false;
        if (toIndex < accounts.length && fromIndex < accounts.length) {
            BigDecimal tempFrom = accounts[fromIndex - 1].getBalance();
            BigDecimal tempTo = accounts[toIndex - 1].getBalance();
            accounts[fromIndex - 1].setBalance(accounts[fromIndex - 1].getBalance().subtract(amount));
            accounts[toIndex - 1].setBalance(accounts[toIndex - 1].getBalance().add(amount));
            if (tempFrom.compareTo(accounts[fromIndex - 1].getBalance()) > 0 && tempTo.compareTo(accounts[toIndex - 1].getBalance()) < 0) {
                res = true;
            }
        }
        return res;
    }

    //     * Подсчет среднего баланса счетов по каждому отделению
//     *
//     * Описание: Рассчитывает средний баланс счетов для каждого отделения банка.
//     * Сигнатура: public BigDecimal[] averageBalancePerBranch(Branch[] branches)
    public static BigDecimal[] averageBalancePerBranch(Branch[] branches) {
        BigDecimal[] resBalancePerBranches = new BigDecimal[branches.length];
        for (int i = 0; i < branches.length; i++) {
            BigDecimal resBalancePerBranch = BigDecimal.ZERO;
            int countEmployees = 0;
            for (Empl empl : branches[i].getEmployees()) {
                BigDecimal sumBalance = BigDecimal.ZERO;
                for (Account account : empl.getAccount()) {
                    sumBalance = sumBalance.add(account.getBalance());
                }
                BigDecimal averageBalance = BigDecimal.ZERO;
                if (!BigDecimal.ZERO.equals(sumBalance)) {
                    BigDecimal countAccount = new BigDecimal(empl.getAccount().length);
                    averageBalance = sumBalance.divide(countAccount, 2, BigDecimal.ROUND_HALF_UP);
                    countEmployees++;
                }
                resBalancePerBranch = resBalancePerBranch.add(averageBalance);
            }
            if (countEmployees != 0) {
                resBalancePerBranch = resBalancePerBranch.divide(BigDecimal.valueOf(countEmployees), 2,
                        BigDecimal.ROUND_HALF_UP);
            }
            resBalancePerBranches[i] = resBalancePerBranch;
        }
        return resBalancePerBranches;
    }

    //     * Определение отделения с наибольшим количеством сотрудников-иностранцев
//     *
//     * Описание: Находит отделение с максимальным числом сотрудников не из страны, где расположен банк.
//     * Сигнатура: public Branch findBranchWithMostForeignEmployees(Branch[] branches, Country bankCountry)
    public static Branch findBranchWithMostForeignEmployees(Branch[] branches, Country bankCountry) {
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
    public static Account[] reportLowBalanceAccounts(Account[] accounts, BigDecimal threshold) {
        int countFilter = 0;
        Account[] newAccounts = new Account[accounts.length];
        for (Account account : accounts) {
            if (account.getBalance().compareTo(threshold) < 0) {
                newAccounts[countFilter] = account;
                countFilter++;
            }
        }
        return Arrays.copyOf(newAccounts, countFilter);
    }

    //     * Создание карты сотрудников по гражданству
//     *
//     * Описание: Считает суммарный баланс счетов по всем отделениям банка.
//     * Сигнатура: public BigDecimal calculateTotalBalanceForBank(Branch[] branches)
    public static BigDecimal calculateTotalBalanceForBank(Branch[] branches) {
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
    public static Empl findEmployeeWithMostAccounts(Empl[] employees) {
        Empl employeeWithMostAccounts = null;
        int maxAccount = 0;
        for (Empl empl : employees) {
            int countAccount = 0;
            for (Account account : empl.getAccount()) {
                countAccount++;
            }
            if (maxAccount<countAccount){
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
