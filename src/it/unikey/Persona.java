package it.unikey;
public class Persona {  //meglio usare una classe astratta
    String nome;
    String cognome;

    public Persona(String nome, String cognome) {
        this.nome = nome;
        this.cognome = cognome;
    }

    public Persona() {

    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }
}
