package it.unikey.controller;

import it.unikey.entities.Student;
import it.unikey.entities.StudentList;
import it.unikey.entities.Tutor;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;
import java.util.stream.Collectors;

public class UserInterface {
    public static void start() throws IOException {
        StudentList sl = new StudentList();

        boolean done = false;
        String cmd = "start";
        while (!done) {
            Scanner scan = new Scanner(System.in);
            switch (cmd) {
                case "start":
                    System.out.println("Digita un numero per compiere un' azione\n" +
                            "1. Inserisci Studente.\n" +
                            "2. Inserisci Tutor.\n" +
                            "3. Visualizza Studenti.\n" +
                            "4. Visualizza Tutor.\n" +
                            "0. Esci.\n");
                    cmd = scan.nextLine();
                    break;
                case "1":
                    cmd = insertStudent();
                    break;
                case "2":
                    cmd = insertTutor();
                    break;
                case "3":
                    cmd = printAllStudents();
                    break;
                case "4":
                    cmd = printAllTutor();
                    break;
                case "0":
                    done = true;
                    break;
                default:
                    System.out.println("Non ho capito.\n");
                    cmd = "start";
            }
        }
    }


    public static String insertStudent() throws IOException {
        Scanner in = new Scanner(System.in);

        System.out.println("Nome dello studente:");
        String nome = in.nextLine();
        System.out.println("Cognome dello studente:");
        String cognome = in.nextLine();
        nome = nome.substring(0, 1).toUpperCase() + nome.substring(1).toLowerCase();
        cognome = cognome.substring(0,1).toUpperCase() + cognome.substring(1).toLowerCase();
        Student s = new Student(nome, cognome);

        Files.write(Paths.get(".\\src\\it\\unikey\\elencoStudenti.txt"), (nome+";"+cognome+";"+ s.getMatricola()+"\n").getBytes(), StandardOpenOption.APPEND);

        return "start";
    }


    private static List<Student> getAllStudents() throws IOException {

        List<String> lines = Files.readAllLines(Paths.get(".\\src\\it\\unikey\\elencoStudenti.txt"));
        return lines.stream().map(x -> new Student(x.split(";")[0], x.split(";")[1], x.split(";")[2])).collect(Collectors.toList());

    }


    public static String printAllStudents() throws IOException {
        getAllStudents().stream().sorted(Comparator.comparing(Student::getSurname).thenComparing(Student::getName)).forEach(System.out::println);
        return "start";
    }


    public static String insertTutor() {
        Scanner in = new Scanner(System.in);
        Tutor t = null;
        boolean done = true;

        do {
            try {
                System.out.println("Nome del tutor: ");
                String nome = in.nextLine();
                System.out.println("Cognome del tutor: ");
                String cognome = in.nextLine();
                nome = nome.substring(0, 1).toUpperCase() + nome.substring(1).toLowerCase();
                cognome = cognome.substring(0, 1).toUpperCase() + cognome.substring(1).toLowerCase();
                System.out.println("Anno di nascita: ");
                int anno = Integer.parseInt(in.nextLine());
                System.out.println("Mese di nascita: ");
                int mese = Integer.parseInt(in.nextLine());
                System.out.println("Giorno: ");
                int giorno = Integer.parseInt(in.nextLine());
                t = new Tutor(nome, cognome, new Date(anno, mese, giorno));
                Files.write(Paths.get(".\\src\\it\\unikey\\elencoTutor.txt"), (nome+";"+cognome+";"+anno+";"+mese+";"+giorno+"\n").getBytes(), StandardOpenOption.APPEND);
                done = true;
            } catch (Exception e) {
                System.out.println("Devi inserire un numero");
                done = false;
            }
        } while (!done);

        return "start";
    }


    private static List<Tutor> getAllTutor() throws IOException {
        return Files.
                readAllLines(Paths.get(".\\src\\it\\unikey\\elencoTutor.txt")).
                stream().
                map(x -> new Tutor(x.split(";")[0], x.split(";")[1], new Date(Integer.parseInt(x.split(";")[2]), Integer.parseInt(x.split(";")[3]), Integer.parseInt(x.split(";")[4])))).
                collect(Collectors.toList());
    }


    public static String printAllTutor() throws IOException {
        getAllTutor().stream().sorted(Comparator.comparing(Tutor::getSurname).thenComparing(Tutor::getName)).forEach(System.out::println);
       return "start";
    }


  /*  public static String insertStudent() throws IOException {
        Scanner in = new Scanner(System.in);

        System.out.println("Nome dello studente:");
        String nome = in.nextLine();
        System.out.println("Cognome dello studente:");
        String cognome = in.nextLine();
        nome = nome.substring(0, 1).toUpperCase() + nome.substring(1).toLowerCase();
        cognome = cognome.substring(0,1).toUpperCase() + cognome.substring(1).toLowerCase();
        Student s = new Student(nome, cognome);

        try(FileOutputStream fos = new FileOutputStream(".\\src\\it\\unikey\\elencoStudenti.txt", true);
            ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            if(getAllStudents() == null) {
                StudentList st = new StudentList(new ArrayList<>());
                st.getArrs().add(s);
                oos.writeObject(st);
            }
            else {
                StudentList stl = getAllStudents();
                stl.getArrs().add(s);
            oos.writeObject(stl);
            }
        } catch(IOException e)
        {
            System.out.println("Problemi con il file.");
        }
        return "start";
    }


    public static StudentList getAllStudents() {
        StudentList stl = null;
        try(FileInputStream fis = new FileInputStream(".\\src\\it\\unikey\\elencoStudenti.txt");
            ObjectInputStream ois = new ObjectInputStream(fis)) {
            stl = (StudentList) ois.readObject();
        } catch (IOException e) {
            System.out.println("Errore con il file.");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return stl;
    }


    public static String printAllStudents() {
        getAllStudents().getArrs().stream().sorted(Comparator.comparing(Student::getSurname).thenComparing(Student::getName)).forEach(System.out::println);
        return "start";
    }


    public static String insertTutor() {
        Scanner in = new Scanner(System.in);
        Tutor t = null;
        boolean done = true;

        do {
            try {
                System.out.println("Nome del tutor: ");
                String nome = in.nextLine();
                System.out.println("Cognome del tutor: ");
                String cognome = in.nextLine();
                nome = nome.substring(0, 1).toUpperCase() + nome.substring(1).toLowerCase();
                cognome = cognome.substring(0, 1).toUpperCase() + cognome.substring(1).toLowerCase();
                System.out.println("Anno di nascita: ");
                int anno = Integer.parseInt(in.nextLine());
                System.out.println("Mese di nascita: ");
                int mese = Integer.parseInt(in.nextLine());
                System.out.println("Giorno: ");
                int giorno = Integer.parseInt(in.nextLine());
                t = new Tutor(nome, cognome, new Date(anno, mese, giorno));
            } catch (Exception e) {
                System.out.println("Devi inserire un numero");
                done = false;
            }
        } while (!done);

        try(FileOutputStream fos = new FileOutputStream(".\\src\\it\\unikey\\elencoTutor.txt", true);
        ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(t);
            oos.writeChars("\n");
        } catch(IOException e) {
            System.out.println("Problemi con i file");
        }
        return  "start";
    }*/

}
