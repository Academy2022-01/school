package it.unikey;

import java.io.IOException;
import java.util.Scanner;

public class Main {

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
