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
    private String pathTutor = "C:\\Users\\Silvia\\Desktop\\esercizio scuola\\nuoviTutor.txt\\";


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

        String pathLettura = "C:\\Users\\Silvia\\Desktop\\esercizio scuola\\nuoviTutor.txt";

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
