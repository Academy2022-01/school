package it.unikey;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {


    private static int menu;

    public static void main(String[] args) {

        Tutor tutor1= new Tutor(LocalDate.of(1960, 3, 28), "Giacomo", "Poretti");
        Tutor tutor2= new  Tutor(LocalDate.of(1970, 7, 20), "Paolo", "piu");

        Studente studente1= new  Studente(123,"Luca","Papaleo");

        Menù.menùScelta();
        Studente.visualizzaStudente();

        // String a = new Scanner(System.in).nextLine();
        System.out.println("-------------------------------");


        System.out.println("Tutor:");

        //String pathLettura="C:\\Users\\Martina\\IdeaProjects\\esercizio_scuola\\utenze.txt";


        String pathScrittura="C:\\Users\\Martina\\IdeaProjects\\esercizio_scuola\\elencoStudenti.txt";
        String pathScrittura1="C:\\Users\\Martina\\IdeaProjects\\esercizio_scuola\\elencoTutor.txt";
       String empty = "";
        ;
        /*List<String> testo=new ArrayList<>();
       List<String> testo1=new ArrayList<>();


        try(FileReader fr= new FileReader(pathLettura);
            BufferedReader br= new BufferedReader(fr);
        ){
            String letta;

            while((letta=br.readLine() )!= null){

                testo.add(letta);



            }

        }catch (IOException E){
            System.out.println(E.getMessage());
        }
        for(String t: testo){
            System.out.println(t);
        }

        for(int i=0;i<testo.size();i++){
            testo.set(i,testo.get(i).toUpperCase());
        }*/


      /*  try(FileWriter fw=new FileWriter(pathScrittura);
            BufferedWriter bw=new BufferedWriter(fw);){

            for(String r: testo){
                bw.write(r);
                bw.newLine();
            }

        }catch(IOException e ){
            System.out.println(e.getMessage());
        }*/


        /*if(!Files.exists(Paths.get(pathScrittura))){
            try {
                Files.createFile(Paths.get(pathScrittura));
            } catch (IOException e) {
                e.printStackTrace();
            }

        }*/
        //String ciao =Studente.visualizzaStudente();

        try {
            Files.write(Paths.get(pathScrittura),empty.getBytes(), StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }

        /*try(FileWriter fw=new FileWriter(pathScrittura1);
            BufferedWriter bw=new BufferedWriter(fw);){

            for(String r: testo1){
                bw.write(r);
                bw.newLine();
            }

        }catch(IOException e ){
            System.out.println(e.getMessage());
        }*/


       /* if(!Files.exists(Paths.get(pathScrittura1))){
            try {
                Files.createFile(Paths.get(pathScrittura1));
            } catch (IOException e) {
                e.printStackTrace();
            }

        }*/
        //String ciao1 =Tutor.visualizzaTutor();

        try {
            Files.write(Paths.get(pathScrittura1),empty.getBytes()/*, StandardOpenOption.APPEND*/);
        } catch (IOException e) {
            e.printStackTrace();
        }




    }


    }

