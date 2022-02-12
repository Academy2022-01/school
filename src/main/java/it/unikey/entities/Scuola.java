package it.unikey.entities;

import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import it.unikey.utilities.ArraysUtil;
import lombok.Getter;

@Getter
public abstract class Scuola {

    @Getter
    public static Set<Studente> setStudenti;
    @Getter
    public static Set<Tutor> setTutor;
    @Getter
    private static TreeMap<Tutor, TreeSet<Studente>> mapStudentiTutor = new TreeMap<Tutor, TreeSet<Studente>>();

    public static void getSetStudentiTutor(Tutor tutor) {
        mapStudentiTutor.computeIfAbsent(tutor, k -> new TreeSet<Studente>());
    }

    public static void visualizzaPersone(Set<? extends Persona> setPersone) {
        if (setPersone.size() == 0)
            System.out.println("\nErrore: nessuna persona trovata nella lista!");
        else {
            String nomeClasse = setPersone.iterator().next().getClass().getSimpleName();
            if (nomeClasse.equals("Studente")) {
                Studente[] arrayStudenti = (Studente[]) ArraysUtil.sortArray(ArraysUtil.parseSetToArray(setPersone));
                for (Studente studente : arrayStudenti)
                    System.out.println("\n" + studente.toString());
            } else if (nomeClasse.equals("Tutor")) {
                Tutor[] arrayTutor = (Tutor[]) ArraysUtil.sortArray(ArraysUtil.parseSetToArray(setPersone));
                for (Tutor tutor : arrayTutor)
                    System.out.println("\n" + tutor.toString());
            }
        }
        Menu.checkNewIteration();
    }

}
