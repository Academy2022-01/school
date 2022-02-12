package it.unikey.entities;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;

import it.unikey.utilities.StringUtil;
import lombok.Getter;

@Getter
public class Tutor extends Persona {
    private static List<String> formatStrings = Arrays.asList("d/M/y", "d-M-y", "y/M/d", "y-M-d");

    private Date dataDiNascita;

    public Tutor(String nome, String cognome, String dataDiNascita) {
        super(nome, cognome);
        for (String formatString : formatStrings) {
            try {
                this.dataDiNascita = new SimpleDateFormat(formatString).parse(dataDiNascita);
                // break;
            } catch (ParseException e) {
            }
        }
    }

    static void inserisciTutor() {
        // SE NON E' GIA' PRESENTE SU FILE E SU LISTA
        System.out.print("\nInserisci il nome: ");
        String nome = StringUtil.inizialeMaiuscola(Login.input.nextLine());
        System.out.print("\nInserisci il cognome: ");
        String cognome = StringUtil.inizialeMaiuscola(Login.input.nextLine());
        System.out.print("\nInserisci la data di nascita: ");
        String dataDiNascita = Login.input.nextLine();
        Tutor nuovoTutor = new Tutor(nome, cognome, dataDiNascita);

        Scuola.getSetTutor().add(nuovoTutor);
        System.out.println("\nIl tutor " + nome + " " + cognome + " e' stato inserito con successo!");
        Menu.checkNewIteration();
    }

    @Override
    public String toString() {
        return "Tutor(nome=" + super.getNome() + ", cognome=" + super.getCognome() + ", dataDiNascita="
                + (new SimpleDateFormat("dd/MM/yyyy").format(dataDiNascita)) + ")";
    }

}
