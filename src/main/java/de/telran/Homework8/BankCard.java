package de.telran.Homework8;

import lombok.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


@Setter
@ToString
@AllArgsConstructor
public class BankCard {
    @Getter
    String cardNum;
    String CardDate;
    @Getter
    String CVV;

    public String getCardDate() {
        return getFormattedCardDate(CardDate);
    }

    public String getFormattedCardDate(String cardDate) {
        if (cardDate == null) {
            return null;
        }
        LocalDate date = LocalDate.parse(cardDate, DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSSSSSSS"));
        return date.format(DateTimeFormatter.ofPattern("MM/yy"));
    }
}
