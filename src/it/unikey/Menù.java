package it.unikey;

import java.util.Scanner;

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

            } while (menù<0 && menù>4);
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
