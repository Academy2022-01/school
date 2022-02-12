package it.unikey.entities;

import java.util.concurrent.ThreadLocalRandom;

import it.unikey.utilities.StringUtil;
import lombok.Getter;

@Getter
public class Studente extends Persona {
    private int numeroMatricola;

    public Studente(String nome, String cognome) {
        super(nome, cognome);
        numeroMatricola = ThreadLocalRandom.current().nextInt(0, (int) Integer.MAX_VALUE);
    }

    static void inserisciStudente() {
        // SE NON E' GIA' PRESENTE SU FILE E SU LISTA
        System.out.print("\nInserisci il nome: ");
        String nome = StringUtil.inizialeMaiuscola(Login.input.nextLine());
        System.out.print("\nInserisci il cognome: ");
        String cognome = StringUtil.inizialeMaiuscola(Login.input.nextLine());
        Studente nuovoStudente = new Studente(nome, cognome);
        if (Scuola.getSetStudenti().contains(nuovoStudente))
            System.out.println("\nErrore: " + nome + " " + cognome + " e' gia' presente nella lista degli studenti!");
        else {
            Scuola.getSetStudenti().add(nuovoStudente);
            System.out.println("\nLo studente " + nome + " " + cognome + " e'stato inserito con successo!");
        }

        Menu.checkNewIteration();
    }

    @Override
    public String toString() {
        return "Studente(nome=" + super.getNome() + ", cognome=" + super.getCognome() + ", numeroMatricola="
                + numeroMatricola + ")";
    }

}
