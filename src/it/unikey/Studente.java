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
    private String pathStudente = "C:\\Users\\Silvia\\Desktop\\esercizio scuola\\nuoviStudenti.txt\\";


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

        System.out.println("Inserisci il nome: ");
        String nomeStudente= scanner.next();
        System.out.println("Inserisci il cognome: ");
        String cognomeStudente = scanner.next();

        try {
            Files.write(Paths.get(pathStudente), (cognomeStudente + " " + nomeStudente + "\n").getBytes(), StandardOpenOption.APPEND);
            // nel metodo write passo un oggetto di tipo Paths , la stringa da aggiungere come array di bytes e l'azione che voglio fare
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    //METODO VISUALIZZA STUDENTE
    public static void visualizzaStudente() {

        String pathLettura ="C:\\Users\\Silvia\\Desktop\\esercizio scuola\\nuoviStudenti.txt\\";

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
