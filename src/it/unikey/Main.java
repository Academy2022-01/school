package it.unikey;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        //UserInterface.loginMenu();
        Student jonathan = new Student("Jonathan", "Mosetti");
        Student sofia = new Student("Sofia", "Lipera");
        Student eren = new Student("Eren", "Jeager");
        Student natsu = new Student("Natsu", "Dragneel");

        Tutor gilberto = new Tutor("Gilberto", "Goracci", null);
        Tutor marcello = new Tutor("Marcello", "Sparini", null);
        Tutor otello = new Tutor("Otello", "Sifoni", null);
        Tutor sfacello = new Tutor("Sfacello", "di Notte", null);

        StudentManager.students.add(jonathan);
        StudentManager.students.add(sofia);
        StudentManager.students.add(eren);
        StudentManager.students.add(natsu);

        TutorManager.tutors.add(gilberto);
        TutorManager.tutors.add(marcello);
        TutorManager.tutors.add(otello);
        TutorManager.tutors.add(sfacello);
        //StudentManager.registerStudent(jonathan);

        UserInterface.loginMenu();

        Set<Student> croccantissimoSetDiGilberto = new HashSet<>();
        Set<Student> croccantissimoSetMarcello = new HashSet<>();
        croccantissimoSetDiGilberto.add(sofia);
        croccantissimoSetMarcello.add(eren);

        Map<Tutor, Set<Student>> tutorStudenti = new HashMap<>();
        tutorStudenti.put(gilberto, croccantissimoSetDiGilberto);
        tutorStudenti.put(marcello, croccantissimoSetMarcello);
        tutorStudenti.get(gilberto).add(jonathan);
        tutorStudenti.get(marcello).add(natsu);

    }
}
