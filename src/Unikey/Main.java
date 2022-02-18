package Unikey;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.time.LocalDate;
import java.util.Arrays;
//ti sei scordata di richiamare il menu nel main
// il file utenze meglio metterlo nel progamma quando si consegna l elaborato per avere la possibilita di testarlo
//metttere un nexline dopo il menu perhce se no la scelta deve essere inserita accanto alla voce esci
//inserimento studenti e inserimento tutor  va in loop , ti continua a chiedere sempre nome e cognome , perche secondo te<?
//la data era da gestire meglio , o scrivere come dovrebbe essere scritta in che formato nel momento in cui la chiedi o gestire i diversi parse
//sarebbe stato un piu aggiungere le classi exception customizzate
//cercare sempre di dividere in packagew le classi
//sulla gestione della relazione tutor studente non era melgio usare le mappe o  mettere la lista degli studenti al tutor e non il contrario?
//non si salvano i nomi e cognomi inseriti nei file , logica da rivedere
//TODO la logica c 'è , si vede che c'e comprensione del linguaggio e della sua logica , lo switch era da gestire meglio , dividerlo per le diverse funzionalita . uno switch per la login  e lo start e un altro per la scelta dell utente
//TODO ottimo aver usato il compareTo, manca l 'uso delle mappe
public class Main {

    public static void main(String[] args) {
        Persona marzia = new Studente("marzia", "Bragaglia");
        Persona angela = new Studente("AnGela", "Morelli");
        Persona silvia = new Studente("Silvia", "inserrA");
        Persona edo = new Studente("Edoardo", "Inserra");
        Persona roby = new Tutor("Roberta", "Vaia", LocalDate.parse("1990-06-10"));
        MenuUtente.start();
        Scuola.aggiungiPersona(silvia);
        /*Scuola.aggiungiPersona(marzia);
        Scuola.aggiungiPersona(edo);*/
        Scuola.aggiungiPersona(roby);
        Scuola.aggiungiPersona(angela);

        System.out.println(Scuola.visualizzaElenco(Scuola.getElencoStudenti()));

    }
}
