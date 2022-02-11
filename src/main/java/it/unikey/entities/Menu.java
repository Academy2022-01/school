package it.unikey.entities;

import it.unikey.utilities.IntUtil;
import lombok.Getter;

@Getter
public abstract class Menu {

    public static void launchAgain() {
        boolean isOption = false;
        System.out.print("\nVuoi tornare al menu'(si/no): ");
        String input = Login.input.nextLine();
        do {
            if(input.equalsIgnoreCase("si")) {
                isOption = true;
                Menu.launch();
            }
            else if(input.equalsIgnoreCase("no")) {
                isOption = true;
                System.out.println("\nAu Revoir, Shoshanna!!!");
            }
            else {
                System.out.print("\nErrore: non ho capito, vuoi tornare al menu'(si/no): ");
                input = Login.input.nextLine();
            }
        } while(!isOption);
    }

    public static void launch() {
        String option;
        boolean isOption = false;
        System.out.print("\nOperazioni disponibili:\n" +
                "\n1 - Inserisci Studente" +
                "\n2 - Inserisci Tutor" +
                "\n3 - Visualizza Studenti" +
                "\n4 - Visualizza Tutor" +
                "\n0 - Esci\n" +
                "\nSeleziona il numero dell'opzione desiderata: ");
        do {
            option = Login.input.nextLine();
            if (IntUtil.isInt(option)) {
                switch (Integer.parseInt(option)) {
                    case 1:
                        isOption = true;
                        Studente.inserisciStudente();
                        break;

                    case 2:
                        isOption = true;
                        Tutor.inserisciTutor();
                        break;

                    case 3:
                        isOption = true;
                        Scuola.visualizzaStudenti(Scuola.getSetStudenti());
                        break;

                    case 4:
                        isOption = true;
                        Scuola.visualizzaTutor(Scuola.getSetTutor());
                        break;

                    case 0:
                        isOption = true;
                        System.out.println("\nAu Revoir, Shoshanna!!!");
                        break;

                    default:
                        isOption = false;
                        System.out.print("\nErrore: inserisci un'opzione valida: ");
                        break;
                }
            } else
                System.out.print("\nErrore: inserisci IL NUMERO dell'opzione desiderata: ");
        } while (!isOption);
    }
}
