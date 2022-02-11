package it.unikey.controller;

import it.unikey.entities.Student;
import it.unikey.entities.Tutor;

import java.io.Console;
import java.io.IOException;
import java.util.Date;

public class Main {

    public static void main(String[] args) throws IOException {
        LogIn.askCredential();
        UserInterface.start();

    }
}
