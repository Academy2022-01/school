package it.unikey.entities;

import java.io.Serializable;
import java.util.Comparator;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public abstract class Persona implements Serializable, Comparable<Persona>, Cloneable {
    private String nome;
    private String cognome;

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public int compareTo(Persona o) {
        return Comparator.comparing(Persona::getCognome).thenComparing(Persona::getNome).compare(this, o);
    }

    

}