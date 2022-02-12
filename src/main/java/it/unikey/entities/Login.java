package it.unikey.entities;

import java.io.Console;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

import it.unikey.utilities.PasswordField;
import it.unikey.utilities.PersoneUtil;

public abstract class Login {

    public static Scanner input = new Scanner(System.in);
    private static Console console = System.console();

    public static void launch() {
        boolean isValidUser = false;
        int tentativi = 0;
        HashMap<String, String> utenteLoggando;

        System.out.println("\nBenvenuto nell'Accademy Unikey!");
        do {
            System.out.print("\nInserisci il nome utente: ");
            String username = input.nextLine();
            //String password = PasswordField.readPassword("\nInserisci la password: ");
            System.out.print("\nInserisci la password: ");
            String password = String.valueOf(console.readPassword());
            utenteLoggando = new HashMap<String, String>();
            utenteLoggando.put(username, password);
            try {
                List<Map<String, String>> listaUtenti = Files
                        .lines(Paths.get("./src/main/java/it/unikey/files/utenze.txt"))
                        .map(x -> {
                            HashMap<String, String> account = new HashMap<>();
                            account.put(x.split(" ")[0], x.split(" ")[1]);
                            return account;
                        })
                        .collect(Collectors.toList());
                if (listaUtenti.contains(utenteLoggando)) {
                    isValidUser = true;
                    System.out.println("\nBenvenuto " + username + "!");
                    break;
                } else
                    System.out.println("\nErrore: login errato");

            } catch (IOException e) {
                e.printStackTrace();
            }
        } while (++tentativi < 3);

        if (isValidUser) {
            PersoneUtil.inizializzaSetsPersone();
            Menu.launch();
        } else
            System.out.println("\nErrore: 3 tentativi di login consecutivi errati, riavvia il programma!");
    }
}
