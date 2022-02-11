package it.unikey.entities;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class Student extends Person implements Serializable{

    private String matricola;

    public Student(String name, String surname) throws IOException {
        super(name, surname);
        this.matricola = generateMatricola();
    }

    public Student(String name, String surname, String matricola) {
        super(name, surname);
        this.matricola = matricola;
    }

    private static String generateMatricola() throws IOException {
        FileReader fr = new FileReader(".\\src\\it\\unikey\\serialeMatricola.txt");
        BufferedReader br = new BufferedReader(fr);
        int serial = Integer.parseInt(br.readLine());
        String matricola;
        if(serial < 10)
            matricola = "000" + serial;
        else if(serial < 100)
            matricola = "00" + serial;
        else if(serial < 1000)
            matricola = "0" + serial;
        else
            matricola = serial + "";
        serial++;
        Files.write(Paths.get(".\\src\\it\\unikey\\serialeMatricola.txt"), (serial+"").getBytes(), StandardOpenOption.WRITE);
        return matricola;
    }

    public String getMatricola() {
        return matricola;
    }

    @Override
    public String toString() {
        return "Studente: " + this.getName() + " " + this.getSurname() + " matricola: " + this.getMatricola();
    }
}
