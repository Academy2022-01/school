package Unikey;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Scuola {
    /*Metodi: Filereader -->visualizzaStudente,
                         -->visualizzaTutor
     */
    private static List<String> elenco = new ArrayList<>();
    private static File elencoStudenti = new File(".\\src\\elencostudenti.txt");
    private static File elencoTutor = new File(".\\src\\elencotutor.txt");


    public static void aggiungiPersona(Persona nuovoInserito) {
        File currentFile = nuovoInserito instanceof Studente ? elencoStudenti : elencoTutor;
        if (!currentFile.exists()) {
            try {
                Files.createFile(currentFile.toPath());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            Files.write(currentFile.toPath(), nuovoInserito.toString().getBytes(), StandardOpenOption.APPEND);
        } catch(IOException e){
            e.printStackTrace();
        }
    }

    public static List<String> visualizzaElenco(File elencoPersone) {
        String currentLine = "";
        if (elencoPersone.exists()) {
            try (BufferedReader bReader = new BufferedReader(new FileReader(elencoPersone))) {
                while ((currentLine = bReader.readLine()) != null) {
                    elenco.add(currentLine);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else System.out.println("Impossibile visualizzare elenco");
        return elenco.stream().sorted().collect(Collectors.toList());
    }

    public static File getElencoStudenti() {
        return elencoStudenti;
    }

    public static File getElencoTutor() {
        return elencoTutor;
    }
}
