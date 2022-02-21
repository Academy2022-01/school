package it.unikey;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class LoginManager {

    static String readWritePath = "log\\";
    static String nomeFile = "LoginInfoLog.txt";


    public static boolean loginCheck(Login login) // il login viene preso  dalla UI di login
    {
        if (Files.exists(Paths.get(readWritePath + nomeFile)))
        {
            try(FileReader reader = new FileReader(readWritePath + nomeFile);
                BufferedReader buffer = new BufferedReader(reader))
            {
                String reading;
                List<String> readLines = new ArrayList<>();

                while ((reading = buffer.readLine()) != null)
                {
                    readLines.add(reading.trim().replace(" ", ""));
                }

                for (String line : readLines)
                {
                    if (line.substring(0, line.indexOf("-")).equalsIgnoreCase(login.getFullname())
                            && line.substring(line.indexOf("-") + 1).equalsIgnoreCase(login.getPassword() + ""))
                    {
                        return true;
                    }else
                    {
                        return false;
                    }
                }
                //Commento del prof:
                //Come ti suggeriva anche l'IntelliSense qui non era utile dividere il blocco try catch con doppio catch per
                //intercettare la FileNotFoundException visto che essa stessa estende la IOException
            } catch (IOException e)
            {
                e.printStackTrace();
            }
        }else
        {
            System.out.println("Devi prima creare un file chiamato 'loginInfoLog'");
        }
        return false;
    }
}
