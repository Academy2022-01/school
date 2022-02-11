package Unikey;

import java.util.Comparator;
import java.util.Locale;

public class Persona implements Comparable<Persona>{
    private String nome;
    private String cognome;

    public Persona() {}

    public Persona(String nome, String cognome) {
        this.nome = nome;
        this.cognome = cognome;
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    @Override
    public int compareTo(Persona o) {
        return Comparator.comparing(Persona::getCognome).thenComparing(Persona::getNome).compare(this, o);
    }

    public String toString(){
        return capitalizza(cognome) + " " + capitalizza(nome) + "\n";
    }

    public String capitalizza(String nome) {
        return nome.substring(0,1).toUpperCase()+nome.substring(1).toLowerCase();
    }
}
