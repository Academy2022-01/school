package it.unikey.entities;

import java.io.Serializable;
import java.util.ArrayList;

public class StudentList implements Serializable {
    public ArrayList<Student> arrs;

    public StudentList(ArrayList<Student> arrs) {
        this.arrs = arrs;
    }

    public StudentList() {}

    public ArrayList<Student> getArrs() {
        return arrs;
    }

    public void setArrs(ArrayList<Student> arrs) {
        this.arrs = arrs;
    }
}
