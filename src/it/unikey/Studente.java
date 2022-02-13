
package it.unikey;

import java.util.Comparator;
import java.util.Scanner;

public class Studente extends Persona {
    static int matricola;
    static String nome;
    static String cognome;

    public Studente(int matricola,String nome, String cognome) {
        super();
        this.matricola = matricola;
        this.nome = nome;
        this.cognome = cognome;
        Scuola.studenti.add(this);
    }

    public static int getMatricola() {
        return matricola;
    }


    public  String getNome() {
        return nome;
    }


    public String getCognome() {
        return cognome;
    }


    public static Studente creaStudente(){

        System.out.println("Inserisci Studente : ");
        System.out.println("matricola:");
        int matricola = Integer.parseInt(new Scanner(System.in).nextLine());
        System.out.println("nome:");
        String nome = new Scanner(System.in).nextLine();
        System.out.println("cognome:");
        String cognome = new Scanner(System.in).nextLine();
        Studente nuovoStudente = new Studente(matricola, nome, cognome);
        return nuovoStudente;

    }
    public static String visualizzaStudente(){
       Scuola.studenti.stream()
        .sorted(Comparator.comparing(Studente :: getCognome))
        .sorted(Comparator.comparing(Studente :: getNome))
               .forEach(System.out :: println);
        return null;
    }

    @Override
    public String toString() {
        return "Studente{" +
                "nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", matricola='" + matricola + '\'' +

                '}';
    }
}
