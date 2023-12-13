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

        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getCitizenship().name().equals(country.name())) {
                newEmployeesArr[indexNewAc] = employees[i];
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
        for (int i = 0; i < accounts.length; i++) {
            if (accounts[i].getBalance().compareTo(minBalance) > 0) {
                for (int j = 0; j < newAccounts.length; j++) {
                    newAccounts[j] = accounts[i];
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
//     * Сортировка сотрудников по общему балансу
//     *
//     * Описание: Сортирует массив сотрудников по общему балансу их счетов в порядке убывания.
//     * Сигнатура: public Empl[] sortEmployeesByTotalBalance(Empl[] employees)

//     * Определение наиболее распространенной валюты среди счетов
//     *
//     * Описание: Определяет валюту, которая встречается чаще всего среди всех счетов.
//     * Сигнатура: public Currency findMostCommonCurrency(Account[] accounts)

//     *
//     * Перевод средств между счетами одного сотрудника
//     * Описание: Выполняет перевод средств между счетами в пределах списка счетов одного сотрудника.
//     * Сигнатура: public boolean transferBetweenAccounts(Account[] accounts, int fromIndex, int toIndex, BigDecimal
//     amount)

//     * Подсчет среднего баланса счетов по каждому отделению
//     *
//     * Описание: Рассчитывает средний баланс счетов для каждого отделения банка.
//     * Сигнатура: public BigDecimal[] averageBalancePerBranch(Branch[] branches)

//     * Определение отделения с наибольшим количеством сотрудников-иностранцев
//     *
//     * Описание: Находит отделение с максимальным числом сотрудников не из страны, где расположен банк.
//     * Сигнатура: public Branch findBranchWithMostForeignEmployees(Branch[] branches, Country bankCountry)

//     * Генерация отчета о счетах с низким балансом
//     *
//     * Описание: Создает список счетов, баланс которых ниже определенной суммы.
//     * Сигнатура: public Account[] reportLowBalanceAccounts(Account[] accounts, BigDecimal threshold)

//     * Создание карты сотрудников по гражданству
//     *
//     * Описание: Считает суммарный баланс счетов по всем отделениям банка.
//     * Сигнатура: public BigDecimal calculateTotalBalanceForBank(Branch[] branches)
//     * Определение сотрудника с наибольшим количеством счетов

//     *
//     * Описание: Находит сотрудника с наибольшим количеством открытых счетов.
//     * Сигнатура: public Empl findEmployeeWithMostAccounts(Empl[] employees)
//     * Анализ распределения типов валют среди всех счетов

//     *
//     * Описание: Распределяет сотрудников по отделениям так, чтобы загрузка по числу управляемых счетов была
//     оптимальной.
//     * Сигнатура: public void optimizeEmployeeDistribution(Branch[] branches)
//     * Моделирование финансовой сети банка
}
