package it.unikey.fileManagement;

import it.unikey.entities.School;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;



public class FileGestion {

    //Commento del prof: ho cambiato i path senza usare l'absolute path ma quello a partire dalla root, senno dal mio pc
    //non sarebbe stato accessibile questo file
    static String pathStudent = "src/it/unikey/log/listStudent.txt";
    static String pathTutor = "src/it/unikey/log/listTutor.txt";

    public static void writeListStudent(){
        School.setStudent.forEach(s -> {
            try {
                Files.write(Paths.get(pathStudent),(s.toString() + "\n").getBytes(), StandardOpenOption.APPEND);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }//end method

    public static void writeListTutor() {
        School.setTutor.forEach(s -> {
            try {
                Files.write(Paths.get(pathTutor), (s.toString() + "\n").getBytes(), StandardOpenOption.APPEND);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }); //end method



    } //end class



}//endClass