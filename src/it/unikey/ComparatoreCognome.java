package it.unikey;

import java.util.Comparator;

public class ComparatoreCognome implements Comparator<Persona> {
    @Override
    public int compare(Persona o1, Persona o2) {
        return o1.getCognome().compareTo(o2.getCognome());
    }
}
