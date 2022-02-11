package it.unikey.entities;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import it.unikey.utilities.ArraysUtil;
import lombok.Data;
import lombok.Getter;

@Data
public abstract class Scuola {

    @Getter
    private static HashSet<Studente> setStudenti = new HashSet<Studente>();
    @Getter
    private static HashSet<Tutor> setTutor = new HashSet<Tutor>();
    
    private static TreeMap<Tutor, TreeSet<Studente>> mapStudentiTutor = new TreeMap<Tutor, TreeSet<Studente>>();

    public static void getSetStudentiTutor(Tutor tutor) {
        if(mapStudentiTutor.get(tutor) == null)
            mapStudentiTutor.put(tutor, new TreeSet<Studente>());
    }

    public static Set<Studente> setStudentiDaFile() {

        return null;
    }

    public static void visualizzaStudenti(Set<Studente> setStudenti) {
        if(setStudenti.size() == 0)
            System.out.println("\nErrore: nessuno studente presente nella lista!");
        else {
            Studente[] array = ArraysUtil.sortArray(ArraysUtil.parseSetToArray(setStudenti));
            for(Studente studente : array) {
                System.out.println("\n" + studente.toString());
             }
        }
        Menu.launchAgain();
    }

    public static void visualizzaTutor(Set<Tutor> setTutor) {
        if(setTutor.size() == 0)
            System.out.println("\nErrore: nessun tutor presente nella lista!");
        else {
            Tutor[] array = ArraysUtil.sortArray(ArraysUtil.parseSetToArray(setTutor));
            for(Tutor tutor : array) {
            System.out.println("\n" + tutor.toString());
            }
        }
        Menu.launchAgain();
    }

    public static Tutor cercaTutor(String nome, String cognome) {
        for(Tutor tutor : setTutor) {
            if(tutor.getNome().equals(nome) && tutor.getCognome().equals(cognome))
                return tutor;
        }
        return null;
    }

}
