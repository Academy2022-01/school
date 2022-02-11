package Unikey;

import java.util.Comparator;
import java.util.UUID;

public class Studente extends Persona {
    private UUID matricola;
    private Tutor tutorAssociato;

    public Studente(String nome, String cognome){
        super(nome, cognome);
        matricola = UUID.randomUUID();
    }

    public UUID getMatricola() {
        return matricola;
    }

    public void setTutorAssociato(Tutor tutorAssociato) {
        this.tutorAssociato = tutorAssociato;
    }

    public boolean equals(Studente studente) {
        return this.matricola.equals(studente.matricola);
    }
}
