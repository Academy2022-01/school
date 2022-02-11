package it.unikey.ui;

public class WrongCredentialsException extends Exception {

    public WrongCredentialsException() {
        super();
    }

    @Override
    public String getMessage() {
        return "Wrong Username or password, please try again.";
    }


}
