package it.unikey.utilities;

import java.util.Set;

import it.unikey.entities.Persona;
import it.unikey.entities.Studente;
import it.unikey.entities.Tutor;

public class ArraysUtil {

    public static <T extends Persona> T[] parseSetToArray(Set<T> set) {
        if (set == null)
            return null;
        else {
            if (set.iterator().next().getClass().getSimpleName().equals("Studente"))
                return (T[]) set.toArray(new Studente[0]);
            else if (set.iterator().next().getClass().getSimpleName().equals("Tutor"))
                return (T[]) set.toArray(new Tutor[0]);
        }
        return null;
    }

    public static <T extends Persona> T[] sortArray(T[] array) {
        T tempPersona;
        if (array == null)
            return null;
        else {
            for (int i = 0; i < array.length; i++) {
                for (int j = i + 1; j < array.length; j++) {
                    if (array[i].compareTo(array[j]) > 0) {
                        try {
                            tempPersona = (T) array[i].clone();
                            array[i] = (T) array[j].clone();
                            array[j] = (T) tempPersona.clone();
                        } catch (CloneNotSupportedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
            return array;
        }
    }

}
