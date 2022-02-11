package it.unikey;

public class Main {

    public static void main(String[] args) throws Exception {
        School.login();

        Tutor tutor1 = new Tutor("Botan", "Shishiro", 2002, 43, 20);
        Tutor tutor2 = new Tutor("Nene", "Momosuzu", 2003, 12, 430);
        Tutor tutor3 = new Tutor("lAmY", "yUKiHana", 1994, 5, 30);
        Tutor tutor4 = new Tutor("poLKa", "OmarU", 2009, 63, 16);

        Student student1 = new Student("Joseph", "Joestar", tutor2);
        Student student2 = new Student("arturo", "armando");
        Student student3 = new Student("uGO", "amogus", tutor1);
        Student student4 = new Student("sus", "aMOGUS");

        School.mainMenu();

    }
}
