package it.unikey;

import java.io.IOException;
import java.util.Scanner;
/*Realizzare un programma per la gestione delle anagrafiche di una scuola.
Si prevedano in particolare due tipologie di persone: Studenti e Tutor.
Degli studenti dovranno essere registrati nome, cognome e numero di matricola

Dei tutor dovranno essere registrati nome, cognome e data di nascita.
Per accedere al programma dovranno essere inserite username e password
Che devono essere controllate su un file che chiamerete utenze.txt e che
sarà di sola lettura
(scelte nella scrittura del codice)

Prevedere un menu principale con un'interfaccia tipo:
1 - Inserisci Studente
2 - Inserisci Tutor
3 - Visualizza Studenti
4 - Visualizza Tutor
0 - Esci

Nell'inserimento inserire i nuovi studenti/tutor in una lista adatta.
Nella visualizzazione convertire la lista in array, ordinarlo in ordine alfabetico per
cognome, e stamparlo ordinato.

nomi e cognomi dovranno essere salvati con la prima lettera maiuscola e
tutte le altre minuscole (esempio: alessANDRO in input verrà salvato Alessandro)

se i cognomi sono uguali proseguire l'ordinamento in ordine alfabetico in
base al nome.

Salvare gli studenti in un file che verrà chiamato elencostudenti.txt
Salvare i Tutor in un file che verrà chiamato elencotutor.txt

Prevedere la possibilità che ad ogni studente verrrà assegnato un tutor.
I tutor però possono essere collegati a più studenti. Non lasciate, però
un riferimento agli studenti nella classe Tutor.

punto extra:
	rendere invisibile l'input della password, o sostituire con *
*/
public class Main {
//TODO
    //opzione esci dell' interfaccia non fuzniona, perche quando inserisco lo 0 che rientra nel caso default mi stampa " numero sbagliato "
    //molto apprezzato la suddivisione in classi per il login e la console , anche lo witch dell'nterfaccia si poteva inserire in console  e richiamre solo il metodo nel main.
    //manca la parte di passaggio da arraylist e array e il cambio formato per i nomi e cognomi con la lettera maiuscola
    //non è best practice avere tutti gli attributi statici
    //ti ho corretto il nextline dello scanner perhce dva problemi nella login quando veniva ripetuta

    public static void main(String[] args) throws IOException {
        Login login = new Login();
        Console console = new Console();
        Scanner tast = new Scanner(System.in);

        do{
            boolean isLogin = login.login();
            if (isLogin){
                int n;
                do {
                    System.out.println("M o d a l i t à     D E V E L O P E R: ");
                    console.output();
                    n = tast.nextInt();
                    switch (n) {
                        case 1:
                            Studente.insertStudent();
                            break;
                        case 2:
                            Tutor.insertTutor();
                            break;
                        case 3:
                            Studente.visStudenti("src\\registro\\elencoStudenti.txt");
                            break;
                        case 4:
                            Tutor.visTutor("src\\registro\\elencoTutor.txt");
                            break;
                        default:
                            System.out.println("numero sbaglaito!");
                    }
                }while (n!=0);
            }else{
                System.out.println("Username e-o password sbagliato-i");
            }
        }while(true);
    }
}
