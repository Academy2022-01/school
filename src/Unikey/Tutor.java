package Unikey;

import java.time.LocalDate;

public class Tutor extends Persona{
    public LocalDate dataDiNascita;

    public Tutor(String nome, String cognome, LocalDate dataDiNascita) {
        super(nome, cognome);
        this.dataDiNascita = dataDiNascita;
    }
    public LocalDate getDataDiNascita() {
        return dataDiNascita;
    }
}
