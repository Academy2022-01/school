package it.unikey;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.security.cert.CRLReason;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class StudentManager {

    static ArrayList<Student> students = new ArrayList<>();
    static Random randomGen = new Random();
    static String writePath = "C:\\Users\\jonat\\Desktop\\";
    static String nomeFile = "ListaStudenti.txt";

    public static void registerStudent(Student student) // lo sudente lo creo nella UI
    {
        int passwordRandom = randomGen.nextInt(2000000000 - 1000000000);
        String content = (student.getFullName() + " - " + passwordRandom + "\n");

        if (!students.contains(student.getFullName()))
        {
            students.add(student);

            if (!Files.exists(Paths.get(LoginManager.readWritePath + LoginManager.nomeFile)))
            {
                try {
                    Files.createFile(Paths.get(LoginManager.readWritePath + LoginManager.nomeFile));
                    Files.write(Paths.get(LoginManager.readWritePath + LoginManager.nomeFile), content.getBytes(), StandardOpenOption.APPEND);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }else
            {
                try {
                    Files.write(Paths.get(LoginManager.readWritePath + LoginManager.nomeFile), content.getBytes(), StandardOpenOption.APPEND);

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }else
        {
            System.out.println("uno studente con questo è gia stato registrato");
        }

    }

    public static void visualizzaStudenti(ArrayList<Student> students)
    {
        String[] studentsNamesArray = new String[students.size()];

        for (int i = 0; i < studentsNamesArray.length; i++)
        {
            studentsNamesArray[i] = students.get(i).getFullName();
        }

        Arrays.sort(studentsNamesArray, String.CASE_INSENSITIVE_ORDER);
        for (int i = 0; i < studentsNamesArray.length; i++)
        {
            System.out.println(studentsNamesArray[i]);
        }


        if (!Files.exists(Paths.get(writePath + nomeFile)))
        {
            try
            {
                Files.createFile(Paths.get(writePath + nomeFile));
                Files.write(Paths.get(writePath + nomeFile),
                        students.stream().map(x -> x.getStudentId() + " - " + x.getFullName()).collect(Collectors.joining()).getBytes(),
                        StandardOpenOption.APPEND);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }else
        {
            try
            {
                Files.write(Paths.get(writePath + nomeFile),
                        students.stream().map(x -> x.getStudentId() + " - " + x.getFullName()).collect(Collectors.joining()).getBytes(),
                        StandardOpenOption.APPEND);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
