package it.unikey;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Login {

    public boolean login(){
        boolean isAuthenticated = false;

        Scanner sc = new Scanner(System.in);

        System.out.println("username: ");
        String username = sc.next();

        System.out.println("Password: ");
        String password = sc.next();

        String path ="src\\account\\utenze.txt";

        File file = new File(path);

        try {
            Scanner inputBuffer = new Scanner(file);

            while(inputBuffer.hasNext()){
                String line = inputBuffer.nextLine();
                String[] values = line.split(",");

                if(values[0].equals(username)) {
                    if(values[1].equals(password)) {
                        isAuthenticated = true;
                    }
                }
            }
        }catch (FileNotFoundException fe){
            fe.printStackTrace();
        }
        return isAuthenticated;
    }
}
