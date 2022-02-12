package it.unikey.utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashSet;
import java.util.Set;

import it.unikey.entities.Persona;
import it.unikey.entities.Scuola;
import it.unikey.entities.Studente;
import it.unikey.entities.Tutor;
import lombok.Getter;

@Getter
public abstract class PersoneUtil {

    @Getter
    public static final String pathStudenti = "./src/main/java/it/unikey/files/elencostudenti.txt";
    public static final String pathTutor = "./src/main/java/it/unikey/files/elencotutor.txt";

    public static Set<? extends Persona> getSetPersoneDaFile(String sottotipo) {
        String path;
        if (sottotipo.equalsIgnoreCase("Studente"))
            path = PersoneUtil.pathStudenti;
        else
            path = PersoneUtil.pathTutor;
        try (FileInputStream in = new FileInputStream(path)) {
            ObjectInputStream oIn = new ObjectInputStream(in);
            return (Set<? extends Persona>) oIn.readObject();
        } catch (Exception e) {
            return null;
        }
    }

    public static void inizializzaSetsPersone() {
        if (getSetPersoneDaFile("Studente") != null)
            Scuola.setStudenti = new HashSet<>((Set<Studente>) getSetPersoneDaFile("Studente"));
        else
            Scuola.setStudenti = new HashSet<>();
        if (getSetPersoneDaFile("Tutor") != null)
            Scuola.setTutor = new HashSet<>((Set<Tutor>) getSetPersoneDaFile("Tutor"));
        else
            Scuola.setTutor = new HashSet<>();
    }

    // REFACTOR
    public static void scriviSetSuFile(Set<? extends Persona> setPersone) {
        String nomeClasse = setPersone.iterator().next().getClass().getSimpleName();
        String pathCorretto = "";
        if (nomeClasse.equals("Studente"))
            pathCorretto = pathStudenti;
        else if (nomeClasse.equals("Tutor"))
            pathCorretto = pathTutor;
        try (FileOutputStream out = new FileOutputStream(pathCorretto)) {
            ObjectOutputStream oOut = new ObjectOutputStream(out);
            oOut.writeObject(setPersone);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Tutor cercaTutor(String nome, String cognome) {
        for (Tutor tutor : Scuola.setTutor) {
            if (tutor.getNome().equals(nome) && tutor.getCognome().equals(cognome))
                return tutor;
        }
        return null;
    }

}
