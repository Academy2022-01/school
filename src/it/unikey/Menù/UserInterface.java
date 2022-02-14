
package it.unikey.Menù;

import it.unikey.control.FileLog;
import it.unikey.exception.PasswordNotFoundException;
import it.unikey.exception.UsernameNotFoundException;
import it.unikey.entities.School;
import it.unikey.entities.Student;
import it.unikey.entities.Tutor;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class UserInterface {

    static Scanner scanner = new Scanner(System.in);
    static boolean choise = true;

    public static void login() {

        System.out.println("Inserisci un username:");
        String username = scanner.nextLine();
        System.out.println("Inserisci la password:");
        String password = scanner.nextLine();
        try {
            FileLog.checkUser(username, password);
            choise = true;
            launchMenu();
        } catch (UsernameNotFoundException e) {
            System.out.println("L'username non è valido!");
            choise = false;
            login();
        }catch (PasswordNotFoundException e){
            System.out.println("La password è sbagliata!");
            choise = false;
            login();
        }
    }

    public static void launchMenu() {
        if(choise) {
            System.out.println("1 - Inserisci Studente\n" +
                    "2 - Inserisci Tutor\n" +
                    "3 - Visualizza Studenti\n" +
                    "4 - Visualizza Tutor\n" +
                    "5 - Esci dal Programma");
        }
        scanner = new Scanner(System.in);
        Integer number = returnChoise();
        while (choise) {
            switch (number){
                case 1:
                    scanner = new Scanner(System.in);
                    String name = askName();
                    scanner = new Scanner(System.in);
                    String surname = askSurname();
                    School.addPerson(new Student(name, surname));
                    launchMenu();
                    break;
                case 2:
                    scanner = new Scanner(System.in);
                    String nameTutor = askName();
                    scanner = new Scanner(System.in);
                    String surnameTutor = askSurname();
                    scanner = new Scanner(System.in);
                    LocalDate date = askDateTutor();
                    School.addPerson(new Tutor(nameTutor, surnameTutor, date + ""));
                    launchMenu();
                    break;
                case 3:
                    Arrays.stream(School.changeSetStudentToArr()).forEach(System.out::println);
                    launchMenu();
                    break;
                case 4:
                    Arrays.stream(School.changeSetTutorToArr()).forEach(System.out::println);
                    launchMenu();
                    break;
                case 5:
                    choise = false;
                    break;
                default:
                    System.out.println("Scelta non disponibile, scegliere una delle seguenti opzioni: ");
                    launchMenu();
                    break;
            }
        }
    }


    public static String askName(){
        try {
            System.out.println("Inserisci il nome: ");
            return getOnlyStringInput();
        } catch (Exception e) {
            System.out.println("L'input non può contenere numeri");
            return askName();
        }
        //TODO chiedere perchè non può tornare null
        //return null;
    }


    public static String askSurname(){
        try {
            System.out.println("Inserisci il cognome: ");
            return getOnlyStringInput();
        } catch (Exception e) {
            System.out.println("L'input non può contenere numeri");
            return askSurname();
        }
    }


    public static LocalDate askDateTutor(){

        try {
            System.out.println("Inserisci la data di nascita: ");
            LocalDate date = LocalDate.parse(scanner.nextLine());
            return date;
        } catch (Exception e) {
            System.out.println("Inserisci il formato di data corretto (aaa-mm-gg)");
            return askDateTutor();
        }
    }

    public static boolean isInteger (String strNum){
        if (strNum == null) {
            return false;
        }
        try {
            int d = Integer.parseInt(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    public static int returnChoise() {
        try {
            int scelta = getOnlyNumericInput();
            if (choiseIsAvailable(scelta)) {
                return scelta;
            } else {
                System.out.println("Seleziona un'opzione valida");
                launchMenu();
            }
        } catch (InputMismatchException e) {
            System.out.println("Inserisci un valore intero valido");
            launchMenu();
        }
        return -1;
    }


    public static boolean choiseIsAvailable(int scelta) {
        return  scelta == 1 ||
                scelta == 2 ||
                scelta == 3 ||
                scelta == 4 ||
                scelta == 5;
    }


    public static int getOnlyNumericInput() {
        String response = scanner.nextLine();
        if (!isInteger(response))
            throw new InputMismatchException("Devi inserire un valore intero");
        return Integer.parseInt(response);
    }

    public static String getOnlyStringInput() {
        scanner = new Scanner(System.in);
        String response = scanner.nextLine();
        for (int i = 0; i < response.length(); i++) {
            if (isInteger(response.charAt(i) + ""))
                throw new InputMismatchException("Non puoi inserire solo numeri");
        }
        return response;
    }

}