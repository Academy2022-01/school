package it.unikey;

import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) {

        Start controllore = new Start();

        controllore.registrazione(scanner);

        controllore.menuIniziale(scanner);

    }
}
