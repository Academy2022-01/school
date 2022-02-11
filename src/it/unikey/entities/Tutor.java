package it.unikey.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;

public class Tutor implements Serializable {
    private String name;
    private String surname;
    private Date dayOfBirth;

    public Tutor() {
    }

    public Tutor(String name, String surname) {
        this.name = name;
        this.surname = surname;
        this.dayOfBirth = new Date(ThreadLocalRandom.current().nextInt() * 1000L);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Date getDayOfBirth() {
        return dayOfBirth;
    }

    public void setDayOfBirth(Date dayOfBirth) {
        this.dayOfBirth = dayOfBirth;
    }

    @Override
    public String toString() {
        return getSurname() + " " + getName();
    }
}
