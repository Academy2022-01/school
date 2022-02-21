package it.unikey;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Tutor extends  Persona {

    LocalDate dataNascita;
    private String pathTutor = "log\\nuoviTutor.txt\\";


    public Tutor(String nome, String cognome, LocalDate dataNascita) {
        super(nome, cognome);
        this.dataNascita = dataNascita;
    }

    public Tutor() {
    }

    public LocalDate getDataNascita() {
        return dataNascita;
    }

    @Override
    public String toString() {
        return "Tutor{" +
                getNome() + " " +
                getCognome() + " " +
                "dataNascita=" + dataNascita +
                '}';
    }

    //METODO AGGIUNGI TUTOR
    public void aggiungiTutor(Scanner scanner) {

        if (!Files.exists(Paths.get(pathTutor))) { // nel caso il file non esiste lo creo
            try {
                Files.createFile(Paths.get(pathTutor));
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        //Commento del prof
        //Capisco la fretta di consegnare ma ricordati che in questo metodo non hai messo nessuna indicazione su cosa l'utente
        //sta per inserire da tastiera, cosa che invece hai correttamente fatto nella classe studente. Bastava inserire una stampa
        //che ci indicasse di "inserire un nome" o di "inserire un cognome"
        String nomeTutor = scanner.next();
        String cognomeTutor = scanner.next();

        try {
            Files.write(Paths.get(pathTutor), (nomeTutor + " " + cognomeTutor + "\n").getBytes(), StandardOpenOption.APPEND);
            // nel metodo write passo un oggetto di tipo Paths , la stringa da aggiungere come array di bytes e l'azione che voglio fare
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    //METODO VISUALIZZA TUTOR
    public static void visualizzaTutor() {

        //Commento del prof
        //Ti sei definita una stringa pathLettura che di fatto è ridondante visto che è esattamente uguale al pathTutor che
        //fa parte di questa stessa classe (riga - 18)
        String pathLettura = "log\\nuoviTutor.txt";

        try (FileReader fr = new FileReader(pathLettura);
             BufferedReader br = new BufferedReader(fr)) {
            ArrayList<String> listaTutor = new ArrayList<>();
            String read;
            // read = variabile di appoggio che serve per prendere tutto quello che che legge il buffered reader,
            // x memorizzare valore per alore gli elementi che andranno nell'arraylist

            while ((read = br.readLine()) != null) { //inizializzo read dentro il while
                listaTutor.add(read); //

            }

            for (String d : listaTutor) {
                System.out.println(d);
            }


        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
