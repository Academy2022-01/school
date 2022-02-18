package it.unikey;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Tutor extends Persona {

    private String dataNascita;
    private String pathTutor = "log/elencoTutor.txt";


    public Tutor() {
    }

    public Tutor(String nome, String cognome, String dataNascita) {
        super(nome, cognome);
        this.dataNascita = dataNascita;
    }

    public void inserisciTutor(Scanner scanner) {



        if (!Files.exists(Paths.get(pathTutor))) {

            try {
                Files.createFile(Paths.get(pathTutor));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        scanner.nextLine(); //Aggiunta del prof
        System.out.println("Inserisci nome");
        String newTutor = scanner.nextLine() + " "; //era next()
        newTutor = newTutor.substring(0,1).toUpperCase() + newTutor.substring(1).toLowerCase();

        System.out.println("Inserisci cognome");
        String cognomeTutor = scanner.nextLine() + " "; //era next()
        cognomeTutor = cognomeTutor.substring(0,1).toUpperCase() + cognomeTutor.substring(1).toLowerCase();

        //Commento del prof:
        //ho dovuto inserire questo nextline a vuoto inizialmente perché usando solo next() non mi considerava la seconda parte di un cognome con uno spazio
        //come ad esempio il mio :(
        System.out.println("Inserisci data di nascita gg/m/anno");
        String dataTutor = newTutor + cognomeTutor + scanner.nextLine() + ",\n"; //era next()
        try {
            Files.write(Paths.get(pathTutor), dataTutor.getBytes(), StandardOpenOption.APPEND);

        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void leggiTutor() {

        List<String> testoTutor = new ArrayList<>();

        try (FileReader fr = new FileReader(pathTutor);
             BufferedReader br = new BufferedReader(fr);) {
            String letta;
            while ((letta = br.readLine()) != null) {

                testoTutor.add(letta);
            }

        } catch (IOException E) {
            System.out.println(E.getMessage());
        }
        for (String t : testoTutor) {
            System.out.println(t);
        }
    }

}
