package it.unikey;

import java.util.Scanner;
//vietato usare accenti per nomi di classi, variabile e metodi , assolutamente da non fare!!
//non necessario fare tutti questi cicli annidati , sopratutto con loop infinito che non serve
//meglio aggiungere un opzione nel menu che fa scegliere all utente se continuare a fare azioni o uscire , e usare variabili booleane per gestire i cicli while cambiando il valore quando si deve uscire dal ciclo
//manca tutta la classe scuola , username e password
public class Menù {
    public static void menùScelta(){
        Scanner scanner = new Scanner(System.in);
        int menù;
        do{

            System.out.println("Scegli una di queste opzioni:");
            System.out.println("1 -> Inserisci Studenti");
            System.out.println("2 -> Inserisci Tutor");
            System.out.println("3 -> Visualizza Studenti");
            System.out.println("4 -> Visualizza Tutor");
            System.out.println("0 -> Esci...");

            do{
                menù = scanner.nextInt();

            } while (menù<0 && menù>4);//??????????????????????????????????
            switch (menù){
                case 1:
                    Studente.creaStudente();
                    break;
                case 2:
                    Tutor.inserisciTutor();
                    break;
                case 3:
                    Studente.visualizzaStudente();
                    break;
                case 4:
                    Tutor.visualizzaTutor();

                    break;
                case 0 :
                    System.exit(0);
                    break;

            }


        }while(0==0);


    }
}
