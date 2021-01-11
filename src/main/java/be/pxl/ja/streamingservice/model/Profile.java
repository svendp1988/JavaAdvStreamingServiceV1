package be.pxl.ja.streamingservice.model;

import be.pxl.ja.streamingservice.exception.InvalidDateException;

import java.time.LocalDate;

public class Profile {
    private String name;
    private LocalDate dateOfBirth;

    private String avatar;

    public Profile(String name) {
        this.name = name;
        this.dateOfBirth = LocalDate.of(2000, 1, 1);
    }

    public Profile(String name, LocalDate dateOfBirth) {
        this.name = name;
        setDateOfBirth(dateOfBirth);
    }

    public boolean allowedToWatch(Content content) {
        return LocalDate.now().getYear() - dateOfBirth.getYear() > content.getMaturityRating().getMinimumAge();
    }

    public String getName() {
        return name;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        if (dateOfBirth.isAfter(LocalDate.now())) {
            throw new InvalidDateException(dateOfBirth, "dateOfBirth", "Date of birth must be in the past");
        }
        this.dateOfBirth = dateOfBirth;
    }
}
