package it.unikey.control;

import it.unikey.exception.PasswordNotFoundException;
import it.unikey.exception.UsernameNotFoundException;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


public class FileLog {

    static String path = "C:\\Users\\ACER\\IdeaProjects\\Scuola\\src\\it\\unikey\\log\\users.txt";

    public static void checkUser(String user, String password) throws PasswordNotFoundException, UsernameNotFoundException {

        try {
            Map<String, String> mapUser = new HashMap<>();

            String users;
            String passwords;

            FileReader fr = new FileReader(path);
            BufferedReader readerFile = new BufferedReader(fr);

            String read;

            while ((read = readerFile.readLine()) != null) {
                mapUser.put(read.substring(0, read.indexOf(":")), read.substring(read.indexOf(":") + 1));
            }
            for (String a : mapUser.keySet()) {
                if (a.equals(user)) {
                    if (mapUser.get(a).equals(password)) {
                        System.out.println("L'user è esistente");
                        break;
                    } else
                        throw new PasswordNotFoundException("Password non trovata!");
                } else
                    throw new UsernameNotFoundException("Username non trovato");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    }