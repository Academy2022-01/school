package it.unikey;

import it.unikey.Menù.UserInterface;
import it.unikey.control.FileLog;
//come gia detto piu volte i commenti vanno levati , codice sempre pulito . sta cominciando ad essere noioso ripeterlo
//ma non richiami mai la funzione di scrivere su file lo studente e il tutor o sbaglio ?
//TODO codice strutturato bene , suddiviso correttamente con ogni metodo le sue funzionalitò  e anche la divisione dei package buona .
//TODO ottimo uso delle mappe
//TODO ho visto che nel users.txt ci sono 3 utense diverse , ma non è stato gestita questa possibilita. vieni loggato solo quando matchano l'user e pass del 1
//TODO manca l'ordinamento dei nomi in ordine alfabetico
public class Main {
    public static void main(String[] args) {



        /*Tutor francesco = new Tutor("francesco", "di rosa", "1993-12-11");
        Tutor sara = new Tutor("sara", "gaudiosi", "1994-10-20");
        Tutor mario = new Tutor("mario", "rossi", "1990-05-14");
        Student luca = new Student("luca", "verdi");
        Student gianni = new Student("Gianni", "Morandi");
        Student alessiog = new Student("alEssio", "GIAnnetti");
        Student fulvio = new Student("fulvIO", "berretta");
        Student marco = new Student("marco", "berretta");
        Student alessiop = new Student("alessio", "paolucci");
        Student gianniOmonimo = new Student("Gianni", "Morandi");

        School.addPerson(alessiog);
        School.addPerson(fulvio);
        School.addPerson(marco);
        School.addPerson(alessiop);
        School.addPerson(gianniOmonimo);
        School.addPerson(gianni);
        School.addPerson(luca);
        School.addPerson(francesco);
        School.addPerson(mario);
        School.addPerson(sara);


        System.out.println("--------------------");
        Arrays.stream(School.changeSetStudentToArr()).forEach(System.out::println);
        System.out.println("--------------------");
        Arrays.stream(School.changeSetTutorToArr()).forEach(System.out::println);

        FileGestion.writeListStudent();
        FileGestion.writeListTutor();

        sara.assignStudentToTutor(fulvio);
        mario.assignStudentToTutor(luca);
        francesco.assignStudentToTutor(luca);
        mario.assignStudentToTutor(gianni);
        mario.assignStudentToTutor(gianniOmonimo);
        Tutor.printStudentForTutor();*/

        UserInterface us = new UserInterface();
        UserInterface.login();


    }

}

