package it.unikey.main;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

import it.unikey.entities.Studente;

/* import it.unikey.entities.Scuola;
import it.unikey.entities.Studente;
import it.unikey.entities.Tutor; */

public class TestMain {
    public static void main(String[] args) {
         /* Studente a = new Studente("Edoardo", "Carradori");
        Studente b = new Studente("Danny", "Carey");
        Studente c = new Studente("Maynard James", "Keenan");

        Scuola.getListaStudenti().add(a);
        Scuola.getListaStudenti().add(b);
        Scuola.getListaStudenti().add(c);
        Scuola.visualizzaStudentiDaLista();

        Tutor d = new Tutor("Edoardo", "Carradori","2022-02-11");
        Tutor e = new Tutor("Danny", "Carey","2022-02-11");
        Tutor f = new Tutor("Maynard James", "Keenan","2022-02-11");

        Scuola.getListaTutor().add(d);
        Scuola.getListaTutor().add(e);
        Scuola.getListaTutor().add(f);
        Scuola.visualizzaTutorDaLista();
        a.scriviSuFile();
        System.out.println(a.getClass().getSimpleName()); */
        try(FileInputStream in = new FileInputStream("./src/main/java/it/unikey/files/elencostudenti.txt");
                ObjectInputStream oIn = new ObjectInputStream(in);) {

                Studente a = (Studente) oIn.readObject();
                //Studente b = (Studente) oIn.readObject();
                System.out.println(a);
                //System.out.println(b);
                
            } catch (Exception e) {
                e.printStackTrace();
            }
    }
}
