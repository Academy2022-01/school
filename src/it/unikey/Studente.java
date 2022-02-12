package it.unikey;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Studente extends Persona{

    private int numeroMatricola;
    private String pathStudenti = "G:\\FileTxTperJava\\elencoStudenti.txt";

    Tutor tutor = new Tutor();


    public Studente() {
    }

    public Studente(String nome, String cognome) {
        super(nome, cognome);
        numeroMatricola = ThreadLocalRandom.current().nextInt(0, (int) Integer.MAX_VALUE);
    }

    public Studente(String nome, String cognome, Tutor tutor) {
        super(nome, cognome);
        this.tutor = tutor;
    }

    public int getNumeroMatricola() {
        return numeroMatricola;
    }

    public void inserisciStudenti(Scanner scanner) {

        if (!Files.exists(Paths.get(pathStudenti))) {

            try {
                Files.createFile(Paths.get(pathStudenti));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Inserisci nome");
        String nomeStudente = scanner.next();

        nomeStudente = nomeStudente.substring(0,1).toUpperCase() + nomeStudente.substring(1).toLowerCase();

        System.out.println("Inserisci cognome");
        String cognomeStudente = scanner.next();

        cognomeStudente = cognomeStudente.substring(0,1).toUpperCase() + cognomeStudente.substring(1).toLowerCase();

        Studente nuovoStudente = new Studente(nomeStudente, cognomeStudente);
        String nomeCognome = nuovoStudente.getCognome() + " " +
                nuovoStudente.getNome() + " " +
                nuovoStudente.getNumeroMatricola() + ",\n";

        try {
            Files.write(Paths.get(pathStudenti), nomeCognome.getBytes(), StandardOpenOption.APPEND);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void leggiStudente() {

        List<String> testoStudente = new ArrayList<>();

        try (FileReader fr = new FileReader(pathStudenti);
             BufferedReader br = new BufferedReader(fr);) {
            String letta;
            while ((letta = br.readLine()) != null) {

                testoStudente.add(letta);
            }
        } catch (IOException E) {
            System.out.println(E.getMessage());
        }

        List<String> ordinatore = Arrays.asList(
                testoStudente.stream().sorted((x, y) -> x.compareToIgnoreCase(y)
                ).toArray(String[]::new));

        for (String t : ordinatore) {
            System.out.println(t);
        }
    }

}
