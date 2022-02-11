package it.unikey;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Comparator;
import java.util.Scanner;

public class Student {
    private String name;
    private String surname;
    private String code;
    private Tutor tutor;
    private static String path = "C:\\Users\\xynbu\\IdeaProjects\\School\\files\\elencostudenti.txt";

    public Student(String name, String surname){
        this.name = School.capitalizeFirstLetter(name);
        this.surname = School.capitalizeFirstLetter(surname);
        String codeBuilder = "";

        for (int i = 0; i < 6; i++){
            double j = Math.random() * 10;
            int k = (int) j;
            codeBuilder += Integer.toString(k);
        }

        this.code = codeBuilder;

        try {
            Files.write(Paths.get(path),this.toString().getBytes(), StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
        School.studentsList.add(this);
    }

    public Student(String name, String surname, Tutor tutor){
        this.name = School.capitalizeFirstLetter(name);
        this.surname = School.capitalizeFirstLetter(surname);
        String codeBuilder = "";

        for (int i = 0; i < 6; i++){
            double j = Math.random() * 10;
            int k = (int) j;
            codeBuilder += Integer.toString(k);
        }

        this.code = codeBuilder;

        this.tutor = tutor;

        try {
            Files.write(Paths.get(path),this.toString().getBytes(), StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
        School.studentsList.add(this);
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getCode() {
        return code;
    }

    public Tutor getTutor() {
        return tutor;
    }

    public void setTutor(Tutor tutor) {
        this.tutor = tutor;
    }

    public static Student createNewStudent(){
        System.out.println("Inserisci nome e cognome in questo ordine.");

        System.out.println("Inserisci nome");
        String name = new Scanner(System.in).nextLine();

        System.out.println("Inserisci cognome");
        String surname = new Scanner(System.in).nextLine();

        Student newStudent = new Student(name, surname);

        System.out.println(newStudent.toString());

        return newStudent;
    }

    @Override
    public String toString() {
        String tutorName = "";

        if(this.getTutor() != null){
            tutorName = this.getTutor().getName() + " " + this.getTutor().getSurname();
        }else{
            tutorName = "Nessun tutor assegnato";
        }

        return "Student{" +
                "name = '" + name + '\'' +
                ", surname = '" + surname + '\'' +
                ", code = '" + code + '\'' +
                ", tutor = '" + tutorName + '\'' +
                "} \n";
    }
}
