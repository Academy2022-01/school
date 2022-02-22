package it.unikey;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

//TODO
//come ripetutuo piu volte , cancellare i commenti quando si consegna un elaborato .
//quando inserisco un numero non valido e mi richiede la scelta non viene presa in considerazione ma ritorna l interfaccia di menu , questo perche hai usato la stessa variabile che infatti non viene ricunosciuta , bastava lasciare solo la stamba e poi tramite il do ti richiedeva l interfaccia .
//giusto l'uso del do while per il meni
//manca la parte di map , di gestione della data del tutor e anche l inserimento del tutor non è user friendly perche ti sei dimenticata di scrivere cosa devo inseire
//hai inpostato la parte user e password sul main , conveniva farla in un metodo o in una classe apparte
//ti mancava inserire la parte di richiesta user e pass e controllarla con quelle salvate sul file
//ti manca tutta il passaggio tra array list e array e la modifica dei dati come richiesto dal documento
// sono state svolte le funzionalità piu basi  e semolice . Sono state impostate bene e buon utilizzo dei cicli . Sarebbe stato buono inserire anche la parte delle exception customizzate che poteva arrichire .
// regola generale meglio usare il main solo per richiamare i metodi che ti servono . cercare sempre di mettere tutte le funzionalità dell applicativo in classi appropiate e dividere le suddette classi in package
//Esempio : "package Entities : Studente e Tutor . Persona poteva essere anche una classe astratta ( in quel caso inserire una sotto cartella abstract nel package ) , package control: login e main fuori dai package
public class Main {

    public static void main(String[] args) {

        Studente a = new Studente("Gigi", "Pippo");
        System.out.println(a);

        Tutor b = new Tutor("Carlo", "Cracco", LocalDate.parse("1990-10-10"));
        System.out.println(b);

        //username e password
        //Che devono essere controllate sul file utenze.txt e che
        //sarà di sola lettura
        String pathLettura= "Scuola\\esercizioScuola\\utenze.txt"; //C:\\Users\\Silvia\\Desktop\\esercizio scuola\\utenze.txt";
        //do {
        //    System.out.println("Inserisci nome utente: ");
        //}
        try(FileReader fr= new FileReader(pathLettura);
            BufferedReader br = new BufferedReader(fr)) {
            ArrayList<String> righeFile = new ArrayList<>();
            String read;
            // read = variabile di appoggio che serve per prendere tutto quello che che legge il buffered reader,
            // x memorizzare valore per alore gli elementi che andranno nell'arraylist

            while((read = br.readLine()) != null){ //inizializzo read dentro il while
                righeFile.add(read); //

            }

            for (String d:righeFile) {
                System.out.println(d);
            }


            }catch (IOException e){
            System.out.println(e.getMessage());
        }

        //menu
        boolean done = true;

        Studente studente = new Studente();
        Tutor tutor = new Tutor();

        do {

            System.out.println("1 - Inserisci Studente\n" +
                    "2 - Inserisci Tutor\n" +
                    "3 - Visualizza Studenti\n" +
                    "4 - Visualizza Tutor\n" +
                    "0 - Esci");
            Scanner scanner = new Scanner(System.in);
            String scelte = scanner.next();

            switch (scelte) {
                case "1":
                    System.out.println("Inserisci Studente");
                    studente.aggiungiStudente(scanner);
                    break;

                case "2":
                    System.out.println("Inserisci Tutor");
                    tutor.aggiungiTutor(scanner);
                    break;

                case "3":
                    System.out.println("Lista Studenti:");
                    studente.visualizzaStudente();
                    break;

                case "4":
                    System.out.println("Lista Tutor:");
                    tutor.visualizzaTutor();
                    break;

                case "0":
                    System.out.println("Esci");
                    done = false;
                    break;

                default:
                    System.out.println("Inserisci un numero valido");

                  //  scelte = scanner.next();
                    break;
            }

        }while (done == true);
    }
}
