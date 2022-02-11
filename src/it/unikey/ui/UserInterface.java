package it.unikey.ui;

import it.unikey.controller.ControlMethods;
import it.unikey.entities.Student;
import it.unikey.entities.Tutor;

import java.util.Scanner;

public class UserInterface {
    public static void startMenu() {

        boolean flag=true;

        checkpoint:
        while (flag = true) {

            System.out.println("Welcome to the school registry,\n" +
                               "please insert your username and password");

            Scanner sc1 = new Scanner(System.in);
            Scanner sc2 = new Scanner(System.in);

            System.out.println("Username: ");
                String insertedUsername = sc1.nextLine().toString();
                    System.out.println("\n");
            System.out.println("Password: ");
                String insertedPassword = sc2.nextLine().toString();
                    System.out.println("\n");

            switch (CredentialsVerifier.verifyCredentials(insertedUsername, insertedPassword)) {
                case ("student"):
                    System.out.println("1.View students list.\n" +
                                       "2.View tutors list.\n" +
                                       "3.View Student-Tutor pairings\n" +
                                       "4.Logout.\n" +
                                       "5.Exit.\n" +
                                       "Make your choices by typing 1,2 or 3");
                    Scanner sc3 = new Scanner(System.in);
                    switch (sc3.nextLine().toString()) {
                        case "1":
                            ControlMethods.viewStudentsList();
                            break;
                        case "2":
                            ControlMethods.viewTutorsList();
                            break;
                        case ("3"):
                            ControlMethods.viewStudentTutorMap();
                            break;
                        case "4":
                            System.out.println("Logging out, redirecting to login section");
                            break checkpoint;
                        case"5":
                            ControlMethods.exit();
                            flag=false;
                            break;
                        default:
                            System.out.println("You didn't insert a valid choice.");
                            break ;
                    }
                    break;
                case ("tutor"):
                    System.out.println("1.Insert a student.\n" +
                                       "2.Insert a tutor.\n" +
                                       "3.View students list.\n" +
                                       "4.View tutors list.\n" +
                                       "5.Assign tutors to all Students.\n" +
                                       "6.View Student-Tutor pairing.\n" +
                                       "7.Logout.\n" +
                                       "Make your choices by typing numbers 1 through 5");
                    Scanner sc4=new Scanner(System.in);
                    switch(sc4.toString().toString()){
                        case("1"):

                            System.out.println("Type in the student's name:");
                            Scanner sc5 = new Scanner(System.in);
                            String studentName = sc5.nextLine().toString();
                            System.out.println("Type in the student's surname:");
                            Scanner sc6 = new Scanner(System.in);
                            String studentSurname=sc6.nextLine().toString();

                            ControlMethods.insertStudent(new Student(studentName,studentSurname));

                            break;
                        case("2"):
                            System.out.println("Type in the tutor's name:");
                            Scanner sc7 = new Scanner(System.in);
                            String tutorName = sc7.nextLine().toString();
                            System.out.println("Type in the tutor's surname:");
                            Scanner sc8 = new Scanner(System.in);
                            String tutorSurname=sc8.nextLine().toString();

                            ControlMethods.insertTutor(new Tutor(tutorName,tutorSurname));

                            break;
                        case("3"):
                            ControlMethods.viewStudentsList();
                            break;
                        case("4"):
                            ControlMethods.viewTutorsList();
                            break;
                        case("5"):
                            ControlMethods.assignTutor();
                            break;
                        case("6"):
                            ControlMethods.viewStudentTutorMap();
                            break;
                        case("7"):
                            System.out.println("Logging out, redirecting to login section");
                            break checkpoint;
                        default:
                            System.out.println("You didn't insert a valid choice.");
                            break checkpoint;
                    }
                    break;
                default:
                    System.out.println("Wrong Username or password, please try again.");
                    break checkpoint;
            }
        }
    }
}
