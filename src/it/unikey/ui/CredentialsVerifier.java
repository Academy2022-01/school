package it.unikey.ui;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class CredentialsVerifier {

    public static boolean checkFile(File file, String word) {
        boolean flag = false;
        try (FileReader fr = new FileReader(file);

             BufferedReader br = new BufferedReader(fr);) {
            while (br.readLine() != null) {
                if (br.readLine() == word) {
                    flag = true;
                } else {
                    flag = false;
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return flag;
    }

    public static String verifyCredentials(String username, String password) {
        String userpass = username.concat("@".concat(password));
        String loggedAs=null;

        File tutors = new File("Database/Tutors/tutorsLogCredentials.txt");
        File students = new File("Database/Students/studentsCredentials.txt");

        if (checkFile(tutors, userpass)) {
            loggedAs = "tutor";
            System.out.println("Access granted as tutor.");
            return loggedAs;
        } else if (checkFile(students, userpass)) {
            loggedAs = "student";
            System.out.println("Access granted as student.");
            return loggedAs;
        } else {
            return loggedAs;
        }
    }
}
