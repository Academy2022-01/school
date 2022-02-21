package it.unikey;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;
import java.util.UUID;

public class Studente extends Persona implements Comparable<Studente>{

    private UUID numeroMatricola;
    private Tutor tutor;
    private String pathStudente = "log\\nuoviStudenti.txt\\";


    public Studente() {
    }

    public Studente(String nome, String cognome) {
        super(nome, cognome);
        numeroMatricola = UUID.randomUUID();
    }

    public UUID getNumeroMatricola() {
        return numeroMatricola;
    }

    @Override
    public String toString() {
        return "Studente{" +
                getNome() + " " +
                getCognome() + " " +
                "numeroMatricola=" + numeroMatricola +
                ", tutor=" + tutor +
                '}';
    }

    //METODO AGGIUNGI STUDENTE
    public void aggiungiStudente(Scanner scanner){

        if(!Files.exists(Paths.get(pathStudente))){ // nel caso il file non esiste lo creo
            try {
                Files.createFile(Paths.get(pathStudente));
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        //Commento del prof:
        //Come ti ho spiegato a voce, ti ho cambiato tutti gli scanner.next() in scanner.nextLine() in modo tale da accettare
        //anche nomi e cognomi con uno spazio in mezzo (Come ad esempio il mio Di Rosa) e come ti ho spiegato sempre a voce
        //ho dovuto mettere un nextLine() a vuoto per intercettare il carattere di invio "\n" che inserisci quando vai a compiere
        //una scelta nel main (Perché premi da tastiera un numero e poi invio, il metodo che ti sei fatta nel main intercetta solo
        //il numero e l'invio verrebbe intercettato dal nextLine() che è presente nel nomeStudente qui sotto - riga 63)
        scanner.nextLine();
        System.out.println("Inserisci il nome: ");
        String nomeStudente= scanner.nextLine();
        System.out.println("Inserisci il cognome: ");
        String cognomeStudente = scanner.nextLine();

        try {
            Files.write(Paths.get(pathStudente), (cognomeStudente + " " + nomeStudente + "\n").getBytes(), StandardOpenOption.APPEND);
            // nel metodo write passo un oggetto di tipo Paths , la stringa da aggiungere come array di bytes e l'azione che voglio fare
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    //METODO VISUALIZZA STUDENTE
    public static void visualizzaStudente() {

        //Commento del prof
        //Come hai fatto anche nella classe tutor, ti sei definita una stringa ridondante, visto che è esattamente uguale alla
        //stringa pathStudente che è a riga 19 di questa classe
        String pathLettura ="log\\nuoviStudenti.txt\\";

        try (FileReader fr = new FileReader(pathLettura);
             BufferedReader br = new BufferedReader(fr)) {
            ArrayList<String> listaStudenti = new ArrayList<>();
            String read;
            // read = variabile di appoggio che serve per prendere tutto quello che che legge il buffered reader,
            // x memorizzare valore per alore gli elementi che andranno nell'arraylist

            //listaStudenti.stream().sorted(Comparator.comparing(Persona::getCognome)).forEach(System.out::println);

            while ((read = br.readLine()) != null) { //inizializzo read dentro il while
                listaStudenti.add(read); //

            }

            for (String d : listaStudenti) {
                System.out.println(d);
            }


        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }


    //comparazione tra cognome e nome
    @Override
    public int compareTo(Studente o) {
        return Comparator.comparing(Studente::getCognome).thenComparing(Studente::getNome).compare(this, o);
    }
}
