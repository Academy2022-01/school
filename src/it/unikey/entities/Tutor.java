package it.unikey.entities;

import java.io.Serializable;
import java.util.Date;

public class Tutor extends Person implements Serializable {

    private Date dob;

    public Tutor(String name, String surname, Date dob) {
        super(name, surname);
        this.dob = dob;
    }

    public Date getDob() {
        return dob;
    }

    @Override
    public String toString() {
        return "Tutor: " + this.getName() + " " + this.getSurname() + " nato il " + this.getDob().toGMTString();
    }
}
