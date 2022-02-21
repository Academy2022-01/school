package it.unikey;

import javax.swing.text.MaskFormatter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class UserInterface {

// non ho messo molti check per gli inserimenti
    
    public static void loginMenu()
    {
        boolean loginMenu = true;
        Scanner scanner1 = new Scanner(System.in);

        while (loginMenu == true) {
            System.out.println("inserisci il tuo nome");
            String firstName = scanner1.nextLine();
            System.out.println("inserisci il tuo cognome");
            String lastName = scanner1.nextLine();

            String fullName = firstName + lastName;

            System.out.println("inserisci la password");
            int password = scanner1.nextInt();

            Login login = new Login(fullName, password);
            LoginManager.loginCheck(login);


            //Commento del prof:
            //come ti ho detto anche a voce qui nell'else ti ho inserito uno scanner1.nextLine() a vuoto visto che hai scelto
            //di usare il nextInt() per la password
            if (LoginManager.loginCheck(login) == true) {
                loginMenu = false;
                mainMenu();
            } else {
                System.out.println("Nome, cognome o password non corretti");
                scanner1.nextLine();
            }
        }
    }

    public  static void mainMenu()
    {
        Scanner scanner2 = new Scanner(System.in);
        boolean start = true;

        while (start == true)
        {
            System.out.println("Cosa vuoi fare? \n" +
                    "1. aggiungi studente \n" +
                    "2. aggiungi tutor \n" +
                    "3. visualizza tutti gli studenti \n" +
                    "4. visualizza tutti i tutor \n" +
                    "5. esci");

            int choice1 = scanner2.nextInt();

            if (choice1 == 1 || choice1 == 2 ||choice1 == 3 ||choice1 == 4 ||choice1 == 5)
            {
                switch (choice1)
                {
                    case 1:
                        System.out.println("inserisci il nome dello studente");
                        scanner2.nextLine();
                        String studentName = scanner2.nextLine();

                        System.out.println("inserisci il cognome dello studente");
                        String studentSurname = scanner2.nextLine();

                        studentName = studentName.substring(0, 1).toUpperCase() + studentName.substring(1).toLowerCase();
                        studentSurname = studentSurname.substring(0, 1).toUpperCase() + studentSurname.substring(1).toLowerCase();

                        Student student = new Student(studentName, studentSurname);
                        StudentManager.registerStudent(student);

                    break;

                    case 2:
                        SimpleDateFormat dataFormatter = new SimpleDateFormat("dd-MM-yyyy");

                        System.out.println("inserisci il nome del tutor");
                        scanner2.nextLine();
                        String tutorName = scanner2.nextLine();
                        System.out.println("inserisci il cognome del tutor");
                        String tutorSurname = scanner2.nextLine();
                        System.out.println("inserisci la data di nascita del tutor - 'dd-MMM-yyyy'");

                        tutorName = tutorName.substring(0, 1).toUpperCase() + tutorName.substring(1).toLowerCase();
                        tutorSurname = tutorSurname.substring(0, 1).toUpperCase() + tutorSurname.substring(1).toLowerCase();

                        Date birtDate = null;
                        try {
                            birtDate = dataFormatter.parse(scanner2.nextLine());
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }

                        Tutor tutor = new Tutor(tutorName, tutorSurname, birtDate);
                        TutorManager.registerTutor(tutor);


                        break;

                    case 3:
                        StudentManager.visualizzaStudenti(StudentManager.students);
                    break;
                    case 4:
                        TutorManager.visualizzaTutor(TutorManager.tutors);
                    break;
                    case 5:
                        return;
                }
            }else
            {
                System.out.println("inserisci un numero corretto");
            }
        }
    }
}
