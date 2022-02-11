package it.unikey.entities;


import it.unikey.controller.ControlMethods;

import java.io.Serializable;

public class Student implements Serializable {
    private String name;
    private String surname;
    private String matricola;

    public Student() {
    }

    public Student(String name, String surname) {
        this.name = name;
        this.surname = surname;
        this.matricola = ControlMethods.regexGenerator();
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

    public String getMatricola() {
        return matricola;
    }

    public void setMatricola(String matricola) {
        this.matricola = matricola;
    }

    @Override
    public String toString() {
        return getSurname() + " " + getName() + " " + getMatricola().toString();
    }
}
