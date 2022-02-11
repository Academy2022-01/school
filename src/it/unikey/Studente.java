package it.unikey;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Studente {
    private static int cont = 0;
    private static int matricola = cont++;
    private static int codice =matricola;
    private static String name;
    private static String surname;
    private static String fileName = "src\\registro\\elencoStudenti.txt";
    private static File file = new File(fileName);
    private static List<String> listaStudenti = new ArrayList<>();
    public static Scanner scanner = new Scanner(System.in);

    public static void insertStudent() throws IOException {
        boolean test = false;
        while (!test) {
            scanner = new Scanner(System.in);
            System.out.println("Inserisci nome studente:");
            String name = scanner.nextLine() + " ";
            System.out.println("Inserisci cognome studente:");
            String surname = scanner.nextLine() + " ";
            String studente = "Matricola: " + codice++ + " Nome: " + name + " Cognome: " + surname + "\n";
            Path path = Paths.get(fileName);
            try {
                Files.write(path, studente.getBytes(), StandardOpenOption.APPEND);
                listaStudenti.add(studente);
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("Vuoi Terminare? S o N");
            String risposta = scanner.nextLine();
            if (risposta.equalsIgnoreCase("S")) {
                break;
            }
        }
    }

    public static List<String> visStudenti(String fileName) throws IOException {
        List<String> fileContent;
        Path filePath = Paths.get(fileName);
        if (Files.exists(filePath)) {
            System.out.println("Il file esiste!");
        } else {
            System.out.println("Il file esiste!");
        }
        try (FileReader fr = new FileReader(file);
             BufferedReader br = new BufferedReader(fr);) { //try catch con risorse
            String letta;
            while ((letta = br.readLine()) != null) { //fin quando trovo una riga piena continuo a leggere
                listaStudenti.add(letta);
            }
        } catch (IOException E) {
            System.out.println(E.getMessage());
        }
        for (String u : listaStudenti) {
            System.out.println(u);
        }
        try (Stream<String> stream = Files.lines(filePath)) {
            fileContent = stream.collect(Collectors.toList());
            return fileContent;
        }
    }
}