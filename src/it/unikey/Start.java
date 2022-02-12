package it.unikey;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Start {
    private String pathUtenze = "G:\\FileTxTperJava\\utenze.txt";


    Studente stu = new Studente();

    Tutor tut = new Tutor();

    public void registrazione(Scanner inserimento) {


        boolean verifica = false;

        do {

            final String password, message = "Scrivi la password";
            if (System.console() == null) {
                final JPasswordField pf = new JPasswordField();
                password = JOptionPane.showConfirmDialog(null, pf, message,
                        JOptionPane.OK_CANCEL_OPTION,
                        JOptionPane.QUESTION_MESSAGE) == JOptionPane.OK_OPTION ?
                        new String(pf.getPassword()) : "";
            } else
                password = new String(System.console().readPassword("%s> ", message));

            System.out.println("Inserisci il nome");
            String nomeUtente = inserimento.next();

            String nomePassword = nomeUtente + " " + password;

            List<String> utenze = new ArrayList<>();
            try (FileReader fr = new FileReader(pathUtenze);
                 BufferedReader br = new BufferedReader(fr);) {
                String letta;
                while ((letta = br.readLine()) != null) {

                    utenze.add(letta);

                }
            } catch (IOException E) {
                System.out.println(E.getMessage());
            }
            for (String t : utenze) {
                if (t.equals(nomePassword))
                    verifica = true;
            }

        } while (verifica == false);
    }

    public void menuIniziale(Scanner scanner){

        boolean ripeti = true;

        do {


            System.out.println("---------------------- \n" +
                    "Benvenuto,scegli cosa vuoi fare:\n" +
                    "1 - Inserisci Studente\n" +
                    "2 - Inserisci Tutor\n" +
                    "3 - Visualizza Studenti\n" +
                    "4 - Visualizza Tutor\n" +
                    "0 - Esci\n" +
                    "------------------------- \n"
            );

            String sceltaMenu = scanner.next();

            switch (sceltaMenu){

                case "1":
                    System.out.println("Hai scelto Inserisci Studente");

                    stu.inserisciStudenti(scanner);
                    break;

                case "2":
                    System.out.println("Hai scelto Inserisci Tutor");

                    tut.inserisciTutor(scanner);
                    break;

                case "3":
                    System.out.println("Hai scelto Visualizza Studenti");

                    stu.leggiStudente();
                    break;

                case "4" :
                    System.out.println("Hai scelto Visualizza Tutor");

                  tut.leggiTutor();
                    break;

                case "0":
                    System.out.println("Hai scelto esci : Addio");
                    ripeti = false;
                    break;

                default:
                    System.out.println("Non va bene , inserisci un numero da 0 a 4");
                    break;
            }

        }while (ripeti == true);
    }
}
