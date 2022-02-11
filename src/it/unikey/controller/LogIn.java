package it.unikey.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class LogIn {

    private static Path utenze = Paths.get(".\\src\\it\\unikey\\utenze.txt");

    private static boolean verifyUser(String username, String pass) throws IOException {
        boolean res = false;
        List<Boolean> aut =  Files.readAllLines(utenze).stream().map(x -> pass.equals(x.split(";")[1]) && username.equals(x.split(";")[0])).collect(Collectors.toList());
        List<Boolean> fin = aut.stream().filter(x -> x).collect(Collectors.toList());
        return fin.size() >= 1;
    }

    public static boolean askCredential() throws IOException {
        while (true) {
            Scanner scan = new Scanner(System.in);
            System.out.println("Inserisci l'username: ");
            String username = scan.nextLine();
            System.out.println("Inserisci la password");
            String password = scan.nextLine();
            if (verifyUser(username, password))
                return true;
        }
    }
}
