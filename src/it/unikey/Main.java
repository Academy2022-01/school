package it.unikey;

import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);

    //Commento del prof:
    //Mi piace come hai implementato il tutto, è codice pulito (anche se si può sempre migliorare)
    //Ma ti sei concentrata troppo sul nascondere la password (e non si può vedere che prima si inserisce la password e poi il nome utente -.-)
    //E non hai fatto la map per relazionare i tutor agli studenti

    public static void main(String[] args) {

        Start controllore = new Start();

        controllore.registrazione(scanner);

        controllore.menuIniziale(scanner);

    }
}
