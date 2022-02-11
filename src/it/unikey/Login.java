package it.unikey;

import java.util.Random;

public class Login {

    private String fullname;
    private int password;

    public Login(String fullname, int password) // viene creato dalla ui di login per poi essere controllato da LoginManager
    {
        this.fullname = fullname;
        this.password = password;
    }

    public Login() {
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }
}
