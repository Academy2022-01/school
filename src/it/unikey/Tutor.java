package it.unikey;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.Locale;
import java.util.Scanner;

public class Tutor {
    private String name;
    private String surname;
    private LocalDate dateOfBirth;
    private static String path = "C:\\Users\\xynbu\\IdeaProjects\\School\\files\\elencotutor.txt";

    public Tutor(String name, String surname, int year, int month, int day){
        this.name = School.capitalizeFirstLetter(name);
        this.surname = School.capitalizeFirstLetter(surname);
        if(year < 1970 || year > 2022){
            year = 2000;
        }
        if(month < 1 || month > 12){
            month = 1;
        }
        if(day < 1 || day > 31){
            day = 1;
        }
        this.dateOfBirth = LocalDate.of(year, month, day);

        try {
            Files.write(Paths.get(path),this.toString().getBytes(), StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }

        School.tutorsList.add(this);
    }

    public Tutor(String name, String surname, LocalDate dateOfBirth){
        this.name = School.capitalizeFirstLetter(name);
        this.surname = School.capitalizeFirstLetter(surname);
        this.dateOfBirth = dateOfBirth;

        try {
            Files.write(Paths.get(path),this.toString().getBytes(), StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }

        School.tutorsList.add(this);
    }


    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public static Tutor createNewTutor(){
        System.out.println("Inserisci nome, cognome e data di nascita in questo ordine.");

        System.out.println("Inserisci nome");
        String name = new Scanner(System.in).nextLine();

        System.out.println("Inserisci cognome");
        String surname = new Scanner(System.in).nextLine();

        LocalDate dateOfBirth = School.inputDate();

        Tutor newTutor = new Tutor(name, surname, dateOfBirth);

        System.out.println(newTutor.toString());

        return newTutor;
    }

    @Override
    public String toString() {
        return "Tutor{" +
                "name = '" + name + '\'' +
                ", surname = '" + surname + '\'' +
                ", dateOfBirth = " + dateOfBirth +
                "} \n";
    }
}
