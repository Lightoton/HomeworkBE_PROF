package de.telran.Homework3;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.Arrays;

@Getter
@Setter
@AllArgsConstructor
public class Account {
    private String accountNumber;
    private Country country;
    private Currency currency;
    private boolean isDebit;
    private BigDecimal balance;

    @Override
    public String toString() {
        return "Account{" +
                "accountNumber='" + accountNumber + '\'' +
                ", country=" + country +
                ", currency=" + currency +
                ", isDebit=" + isDebit +
                ", balance=" + balance +
                '}';
    }
}
@Getter
@Setter
@AllArgsConstructor
@ToString
class Bank {
    Branch[] branches;
}
@Setter
@Getter
@AllArgsConstructor
@ToString
class Branch {
    Empl[] employees;
}
@Setter
@Getter
@AllArgsConstructor
class Empl {
    private String name;
    private String surName;
    private Account[] account;
    private Citezenship citizenship;
    @Override
    public String toString() {
        return "Empl{" +
                "name='" + name + '\'' +
                ", surName='" + surName + '\'' +
                ", citizenship=" + citizenship +
                '}';
    }
}

enum Country {
    GERMANY,
    CANADA,
    ISRAEL
}


enum Currency {
    EURO,
    DOLLAR,
    SHEKEL
}

enum Citezenship {
    GERMANY,
    CANADA,
    ISRAEL
}
