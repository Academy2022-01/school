package it.unikey.controller;

import it.unikey.entities.Student;
import it.unikey.entities.Tutor;
import jdk.nashorn.internal.runtime.regexp.joni.Regex;

import java.io.*;
import java.util.*;

public class ControlMethods {

    public static void insertStudent(Student student) {
        File file = new File("Database/Students/studentsList.txt");
        Set<String> listaStudenti = new HashSet<>();

        try (FileReader fr = new FileReader(file); BufferedReader br = new BufferedReader(fr);
             FileWriter fw = new FileWriter(file); BufferedWriter bw = new BufferedWriter(fw)) {
            String riga;
            while ((br.readLine()) != null) {
                riga = br.readLine();
                listaStudenti.add(riga);
            }
            if (listaStudenti.contains(student.getName() + " " + student.getSurname() + " " + student.getMatricola().toString())) {
                System.out.println("Student already exists in our database.");
            } else {
                listaStudenti.add(student.toString());
                listaStudenti.stream().forEach(x -> {
                    try {
                        bw.write(x);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
            }
        } catch (IOException e) {
            e.getMessage();
        }
    }


    public static void insertTutor(Tutor tutor) {
        File file = new File("Database/Tutors/tutorsList.txt");
        Set<String> listaTutors = new TreeSet<>();

        try (FileReader fr = new FileReader(file); BufferedReader br = new BufferedReader(fr);
             FileWriter fw = new FileWriter(file); BufferedWriter bw = new BufferedWriter(fw)) {
            String riga;
            while ((br.readLine()) != null) {
                riga = br.readLine();
                listaTutors.add(riga);
            }
            if (listaTutors.contains(tutor.getName() + tutor.getSurname())) {
                System.out.println("Tutor already exists in our database.");
            } else {
                listaTutors.add(tutor.toString());
                listaTutors.stream().forEach(x -> {
                    try {
                        bw.write(x);
                        bw.newLine();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
            }
        } catch (IOException e) {
            e.getMessage();
        }
    }


    public static void viewStudentsList() {

        File file = new File("Database/Students/studentsList.txt");
        Set<String> listaStudenti = new HashSet<>();

        try (FileReader fr = new FileReader(file); BufferedReader br = new BufferedReader(fr);) {
            String riga;
            while ((br.readLine()) != null) {
                riga = br.readLine();
                listaStudenti.add(riga);
            }
        } catch (IOException e) {
            e.getMessage();
        }
        listaStudenti.stream().forEach(System.out::println);

    }


    public static void viewTutorsList() {

        File file = new File("Database/Students/studentsList.txt");
        Set<String> listaTutors = new HashSet<>();

        try (FileReader fr = new FileReader(file); BufferedReader br = new BufferedReader(fr);) {
            String riga;
            while (br.readLine() != null) {
                riga = br.readLine();
                listaTutors.add(riga);
            }
        } catch (IOException e) {
            e.getMessage();
        }
        listaTutors.stream().forEach(System.out::println);
    }


    public static String getRandomTutor() {
        String randomTutor = null;
        String path = "Database/Tutors/tutorsList.txt";
        File file = new File(path);
        Set<String> listaTutors = new HashSet<>();

        try (FileReader fr = new FileReader(file); BufferedReader br = new BufferedReader(fr);) {
            String riga;
            while (br.readLine() != null) {
                riga = br.readLine();
                listaTutors.add(riga);
            }
        } catch (IOException e) {
            e.getMessage();
        }
        int sizeOfSet = listaTutors.size();
        int item = new Random().nextInt(sizeOfSet);
        int i = 0;
        for (String t : listaTutors) {
            if (i == item) randomTutor = t;
            i++;
        }
        return randomTutor;
    }


    public static void assignTutor() {
        String path = "Database/StudentTutorMap/studenTutor.txt";
        String path1 = "Database/Students/studentsList.txt";
        File file = new File(path);
        File file1 = new File(path1);

        Map<String, String> studenTutor = new TreeMap<>();
        Set<String> listaStudenti = new TreeSet<>();
        try (FileReader fr = new FileReader(file1); BufferedReader br = new BufferedReader(fr);) {
            String riga;
            while ((br.readLine()) != null) {
                riga = br.readLine();
                listaStudenti.add(riga);
            }
        } catch (IOException e) {
            e.getMessage();
        }

        for (String s : listaStudenti) {
            studenTutor.put(s, getRandomTutor());
        }

        try (FileWriter fw = new FileWriter(file); BufferedWriter bw = new BufferedWriter(fw);) {
            for (Map.Entry<String, String> entry : studenTutor.entrySet()) {
                bw.write(entry.getKey() + " " + entry.getValue());
            }

        } catch (IOException e) {
            e.getMessage();
        }
    }


    public static void viewStudentTutorMap() {
        String path = "Database/StudentTutorMap/studenTutor.txt";
        File file = new File(path);

        Set<String> listaTutoraggio = new TreeSet<>();
        try (FileReader fr = new FileReader(file); BufferedReader br = new BufferedReader(fr);) {
            String riga;
            while (br.readLine() != null) {
                riga = br.readLine();
                listaTutoraggio.add(riga);
            }
        } catch (IOException e) {
            e.getMessage();
        }
        listaTutoraggio.stream().forEach(System.out::println);
    }


    public static void exit() {
        System.out.println("Menu closing, have a good day!");
    }

    public static String regexGenerator() {
        Regex regex = new Regex("[A-Z]{2}\\d\\d\\d[A-Z]{2}");
        String randomString = regex.compile().toString();
        return randomString;
    }
}
