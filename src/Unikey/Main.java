package Unikey;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.time.LocalDate;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Persona marzia = new Studente("marzia", "Bragaglia");
        Persona angela = new Studente("AnGela", "Morelli");
        Persona silvia = new Studente("Silvia", "inserrA");
        Persona edo = new Studente("Edoardo", "Inserra");
        Persona roby = new Tutor("Roberta", "Vaia", LocalDate.parse("1990-06-10"));

        Scuola.aggiungiPersona(silvia);
        /*Scuola.aggiungiPersona(marzia);
        Scuola.aggiungiPersona(edo);*/
        Scuola.aggiungiPersona(roby);
        Scuola.aggiungiPersona(angela);

        System.out.println(Scuola.visualizzaElenco(Scuola.getElencoStudenti()));

    }
}
