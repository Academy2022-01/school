package it.unikey;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class TutorManager {

    static ArrayList<Tutor> tutors = new ArrayList<>();
    static Random randomGen = new Random();
    static String writePath = "log\\";
    static String nomeFile = "ListaTutor.txt";

    public static void registerTutor(Tutor tutor) //il tutor lo creo nella UI
    {
        int passwordRandom = randomGen.nextInt(2000000000 - 1000000000);
        String content = (tutor.getFullName() + " - " + passwordRandom + "\n");

        if (!tutors.contains(tutor.getFullName()))
        {
            tutors.add(tutor);

            if (!Files.exists(Paths.get(LoginManager.readWritePath + LoginManager.nomeFile)))
            {
                try {
                    Files.createFile(Paths.get(LoginManager.readWritePath + LoginManager.nomeFile));
                    Files.write(Paths.get(LoginManager.readWritePath + LoginManager.nomeFile),
                            content.getBytes(), StandardOpenOption.APPEND);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }else
            {
                try {
                    Files.write(Paths.get(LoginManager.readWritePath + LoginManager.nomeFile), content.getBytes(),
                            StandardOpenOption.APPEND);

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }else
        {
            System.out.println("un tutor con questo è gia stato registrato");
        }

    }

    public static void visualizzaTutor(ArrayList<Tutor> tutors)
    {
        String[] tutorsNamesArray = new String[tutors.size()];

        for (int i = 0; i < tutorsNamesArray.length; i++)
        {
            tutorsNamesArray[i] = tutors.get(i).getFullName();
        }

        Arrays.sort(tutorsNamesArray, String.CASE_INSENSITIVE_ORDER);
        for (int i = 0; i < tutorsNamesArray.length; i++)
        {
            System.out.println(tutorsNamesArray[i]);
        }


        if (!Files.exists(Paths.get(writePath + nomeFile)))
        {
            try
            {
                Files.createFile(Paths.get(writePath + nomeFile));

                Files.write(Paths.get(writePath + nomeFile),
                        tutors.stream().map(x -> x.getFullName() + " - " + x.getBirthDate()).collect(Collectors.joining()).getBytes(),
                        StandardOpenOption.APPEND);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }else
        {
            try
            {
                Files.write(Paths.get(writePath + nomeFile),
                        tutors.stream().map(x -> x.getFullName() + " - " + x.getBirthDate()).collect(Collectors.joining()).getBytes(),
                        StandardOpenOption.APPEND);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
