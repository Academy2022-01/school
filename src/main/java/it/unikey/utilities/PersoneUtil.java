package it.unikey.utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import it.unikey.entities.Persona;
import it.unikey.entities.Scuola;
import it.unikey.entities.Studente;

public class PersoneUtil {

    /* public static <T extends Persona> boolean isPersonaInFile(T persona) {
        if(persona.getClass().getSimpleName().equals("Studente")) {
            try(FileInputStream in = new FileInputStream("./src/main/java/it/unikey/files/elencostudenti.txt");
                Stream<String> righeFile = Files.lines(Paths.get("./src/main/java/it/unikey/files/elencostudenti.txt"));
                ObjectInputStream oIn = new ObjectInputStream(in);) {
                righeFile
                .map(x -> {
                    File riga = new File()
                })

            } catch (Exception e) {
                e.printStackTrace();
            }
                
            /* Files.lines()) {
                ObjectInputStream oIn = new ObjectInputStream(in);
                //Scuola.getSetStudenti().addAll(
                
                    
                //)
            } catch (Exception e) {
                e.printStackTrace();
            } 
        }

        return false;
    }  */

    public static <T extends Persona> void scriviSuFile(T persona) {
        if(persona.getClass().getSimpleName().equals("Studente")) {
            try(FileOutputStream out = new FileOutputStream("./src/main/java/it/unikey/files/elencostudenti.txt", true);
                ObjectOutputStream oOut = new ObjectOutputStream(out)) {
                oOut.writeObject(persona);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if(persona.getClass().getSimpleName().equals("Tutor")) {
            try(FileOutputStream out = new FileOutputStream("./src/main/java/it/unikey/files/elencotutor.txt", true);
            ObjectOutputStream oOut = new ObjectOutputStream(out)) {
                oOut.writeObject(persona);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
       
    }
    
}
