package it.unikey;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Locale;
import java.util.Scanner;

public class School {
    static ArrayList<Student> studentsList = new ArrayList<>();
    static ArrayList<Tutor> tutorsList = new ArrayList<>();

    public static void login() throws Exception {
        System.out.println("Inserire username");
        String username = new Scanner(System.in).nextLine();
        System.out.println("Inserire password");
        String password = inputPassword();

        int usernameCounter = 0;
        int passwordCounter = 0;

        for (String string : readFile()){
            if(string.equals(username)){
                usernameCounter++;
            }
        }

        if((usernameCounter == 0)){
            throw new Exception("Username inesistente");
        }else{
            for (String string : readFile()){
                if(string.equals(password)){
                    passwordCounter++;
                }
            }
        }

        if (passwordCounter == 0){
            throw new Exception("Password errata");
        }else{
            System.out.println("Login riuscito");
        }

        String path1 = "C:\\Users\\xynbu\\IdeaProjects\\School\\files\\elencostudenti.txt";
        String path2 = "C:\\Users\\xynbu\\IdeaProjects\\School\\files\\elencotutor.txt";
        String empty = "";

        try {
            Files.write(Paths.get(path1),empty.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            Files.write(Paths.get(path2),empty.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    private static ArrayList<String> readFile(){
        String path = "C:\\Users\\xynbu\\IdeaProjects\\School\\files\\utenze.txt";

        ArrayList<String> text = new ArrayList<>();

        try(FileReader fr = new FileReader(path);
            BufferedReader br = new BufferedReader(fr);
        ){
            String read;
            while((read = br.readLine()) != null){

                text.add(read);
            }
        }catch (IOException E){
            System.out.println(E.getMessage());
        }

        return text;
    }


    public static String capitalizeFirstLetter(String inputString){
        char[] chars = inputString.toLowerCase(Locale.ROOT).toCharArray();
        String outputString = "";
        chars[0] = Character.toUpperCase(chars[0]);

        for(char character : chars){
            outputString += character;
        }
        return outputString;
    }

    public static int inputIntFields() {
        Scanner inputInt = new Scanner(System.in);
        while (true) {
            try {
                return inputInt.nextInt();
            }
            catch (java.util.InputMismatchException e) {
                System.out.println("Inserisci un valore numerico!");
                inputInt.nextLine();
            }
        }
    }

    public static LocalDate inputDate(){

        System.out.println("Inserisci un anno compreso tra 1970 e 2021");
        int year = inputIntFields();
        while(year < 1970 || year > 2021) {
            System.out.println("Inserisci un anno adeguato");
            year = inputIntFields();
        }

        System.out.println("Inserisci un mese compreso tra 1 e 12");
        int month = inputIntFields();
        while(month < 1 || month > 12) {
            System.out.println("Inserisci un mese adeguato");
            month = inputIntFields();
        }

        if(month == 4 || month == 6 || month == 9 || month == 11){
            System.out.println("Inserisci un giorno compreso tra 1 e 30");
        }else if(month == 2){
            if (year % 4 == 0){
                System.out.println("Inserisci un giorno compreso tra 1 e 29");
            }else{
                System.out.println("Inserisci un giorno compreso tra 1 e 28");
            }
        }else{
            System.out.println("Inserisci un giorno compreso tra 1 e 31");
        }

        int day = inputIntFields();

        if(month == 4 || month == 6 || month == 9 || month == 11){
            while (day < 1 || day > 30) {
                System.out.println("Inserisci un giorno adeguato");
                day = inputIntFields();
            }
        }else if(month == 2){
            if (year % 4 == 0){
                while (day < 1 || day > 29) {
                    System.out.println("Inserisci un giorno adeguato");
                    day = inputIntFields();
                }
            }else{
                while (day < 1 || day > 28) {
                    System.out.println("Inserisci un giorno adeguato");
                    day = inputIntFields();
                }
            }
        }else{
            while (day < 1 || day > 31) {
                System.out.println("Inserisci un giorno adeguato");
                day = inputIntFields();
            }
        }

        LocalDate date = LocalDate.of(year, month, day);

        return date;
    }

    public static void showStudents(){
        studentsList.stream()
                .sorted(Comparator.comparing(Student::getSurname))
                .sorted(Comparator.comparing(Student::getName))
                .forEach(System.out::println);
    }

    public static void showTutors(){
        tutorsList.stream()
                .sorted(Comparator.comparing(Tutor::getSurname))
                .sorted(Comparator.comparing(Tutor::getName))
                .forEach(System.out::println);
    }

    public static void mainMenu(){
        System.out.println("---------------Benvenuto nel menu principale, cosa vuoi fare?---------------");

        System.out.println("1 - Inserisci Studente");
        System.out.println("2 - Inserisci Tutor");
        System.out.println("3 - Visualizza Studenti");
        System.out.println("4 - Visualizza Tutor");
        System.out.println("0 - Esci");

        System.out.println("----------------------------------------------------------------------------");

        int inputInt = inputIntFields();

        while (inputInt < 0 || inputInt > 4){
            System.out.println("Inserisci un numero adeguato");
            inputInt = inputIntFields();
        }

        switch (inputInt){
            case 1:
                Student.createNewStudent();
                System.out.println("Studente inserito con successo, arrivederci!");
                break;
            case 2:
                Tutor.createNewTutor();
                System.out.println("Tutor inserito con successo, arrivederci!");
                break;
            case 3:
                showStudents();
                System.out.println("Grazie e arrivederci!");
                break;
            case 4:
                showTutors();
                System.out.println("Grazie e arrivederci!");
                break;
            default:
                System.out.println("Grazie e arrivederci!");
        }

    }

    public static String inputPassword(){

        final JPasswordField jpf = new JPasswordField();

        JOptionPane jop = new JOptionPane(jpf, JOptionPane.PLAIN_MESSAGE,
                JOptionPane.OK_CANCEL_OPTION);

        JDialog dialog = jop.createDialog("Inserisci la tua password");

        dialog.setVisible(true);

        int result = (Integer) jop.getValue();

        dialog.dispose();

        char[] password = null;

        if (result == JOptionPane.OK_OPTION) {
            password = jpf.getPassword();
        }

        String passwordInput = "";

        if (password != null) {
            passwordInput = new String(password);
        }

        return passwordInput;
    }


}
