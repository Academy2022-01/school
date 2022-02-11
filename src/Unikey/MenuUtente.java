package Unikey;

import javafx.util.converter.LocalDateStringConverter;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MenuUtente {
    private static File utentiRegistrati = new File(".\\src\\utenze.txt");
    private static List<String> utenze = new ArrayList<>();

    public static void start() {
        boolean done = false;
        String comando = "login";
        while (!done) {
            Scanner read = new Scanner(System.in);
            switch(comando){
                case "login":
                    System.out.println("Inserisci nome utente:");
                    String nome = read.nextLine();
                    System.out.println("Inserisci password:");
                    nome = nome + " " + read.nextLine();
                    try (BufferedReader bReader = new BufferedReader(new FileReader(utentiRegistrati))) {
                        String letta;
                        while((letta = bReader.readLine()) != null) {
                            utenze.add(letta);
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                }
                    for (String utentePassword : utenze)  {
                        if (nome.equals(utentePassword)) {
                            comando = "start";
                            break;
                        } else {
                            comando = "login";
                        }
                    } if (!comando.equals("start")) System.out.println("Nome utente o password non corretti");

                    break;
                case"start":
                    System.out.print("Dimmi cosa vuoi fare: " + "\n" +
                            "1 - Inserisci studente" + "\n" +
                            "2 - Inserisci tutor" + "\n" +
                            "3 - Visualizza studenti" + "\n + " +
                            "4 - Visualizza tutor" + "\n" +
                            "0 - Esci");
                    comando = read.nextLine();
                    break;
                case "1":
                    System.out.println("Dimmi il nome dello studente: ");
                    String nomeStudente = read.nextLine();
                    System.out.println("Dimmi il cognome dello studente:");
                    String CognomeStudente = read.nextLine();
                    Persona studente = new Studente (nomeStudente, CognomeStudente);
                    Scuola.aggiungiPersona(studente);
                    break;
                case "2":
                    System.out.println("Dimmi il nome del tutor: ");
                    String nomeTutor = read.nextLine();
                    System.out.println("Dimmi il cognome del tutor:");
                    String cognomeTutor = read.nextLine();
                    System.out.println("Sai la data di nascita del tutor?");
                    String data = read.nextLine();
                    Persona tutor = new Tutor(nomeTutor, cognomeTutor, LocalDate.parse(data));
                    Scuola.aggiungiPersona(tutor);
                    break;
                case "3":
                    Scuola.visualizzaElenco(Scuola.getElencoStudenti());
                    break;
                case "4":
                    Scuola.visualizzaElenco(Scuola.getElencoTutor());
                    break;
                case "0":
                    System.out.println("Grazie per aver utilizzato l'app");
                    done = true;
                    break;
                default:
                    System.out.println("Impossibile eseguire il comando. Scegli una delle opzioni disponibili");
                    comando = "start";
            }
        }
    }

}

