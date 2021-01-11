package be.pxl.ja.streamingservice.model;

import be.pxl.ja.streamingservice.exception.InvalidDateException;

import java.time.LocalDate;

public class PaymentInfo {
    private String cardNumber;
    private String firstName;
    private String lastName;
    private LocalDate expirationDate;

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastname(String lastname) {
        this.lastName = lastname;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        if (LocalDate.now().plusMonths(1).isAfter(expirationDate)) {
            throw new InvalidDateException(expirationDate, "expirationDate", "Must be valid for at least 1 month.");
        }
        this.expirationDate = expirationDate;
    }

    public void setFirstName(String firstname) {
        this.firstName = firstname;
    }
}
