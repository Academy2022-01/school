package it.unikey;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.Scanner;

public class Tutor extends Persona {
    private LocalDate dataDiNascita;
    private   String nome;
    private String cognome;


    public Tutor(LocalDate dataDiNascita, String nome, String cognome) {
        this.dataDiNascita = dataDiNascita;
        this.nome = nome;
        this.cognome = cognome;
        Scuola.tutor.add(this);
    }

    public LocalDate getDataDiNascita() {
        return dataDiNascita;
    }


    public Tutor(String nome, String cognome) {
        super(nome, cognome);
    }

    public Tutor() {
        super();
    }


    public  String getNome() {
        return nome;
    }


    public String getCognome() {
        return cognome;
    }
    public static Tutor inserisciTutor(){
        System.out.println("Inserisci Tutor ");
        System.out.println("nome:");
        String nome = new Scanner(System.in).nextLine();
        System.out.println("cognome:");
        String cognome = new Scanner(System.in).nextLine();
        System.out.println("data:");
        LocalDate data = LocalDate.parse(new Scanner(System.in).nextLine());
        Tutor nuovoTutor = new Tutor( data,nome,cognome);
        return nuovoTutor;


    }
    public static String visualizzaTutor(){
        Scuola.tutor.stream()
                .sorted(Comparator.comparing(Tutor :: getCognome))
                .sorted(Comparator.comparing(Tutor :: getNome))
                .forEach(System.out :: println);
        return null;
    }

    @Override
    public String toString() {
        return "Tutor{" +
                "dataDiNascita=" + dataDiNascita +
                ", nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                '}';
    }
}
