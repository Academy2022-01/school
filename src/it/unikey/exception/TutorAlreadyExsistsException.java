package it.unikey.exception;

import it.unikey.entities.Student;
import it.unikey.entities.Tutor;

public class TutorAlreadyExsistsException extends Exception {
    public TutorAlreadyExsistsException(Student student, Tutor tutor) {
        super("Lo studente " + student.getName() + " " + student.getSurname() + " " + student.getSerialNumber() + " ha già un tutor ed esso si chiama " + tutor.getName());
    }
}
