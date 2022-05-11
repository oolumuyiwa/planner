package edu.vassar.cmpu203.plannerapp.model;

import java.io.Serializable;

public class Semester implements Serializable {

    public String semname;
    public int semyear;

    public Semester(String semname, int semyear){
        this.semname = semname;
        this.semyear = semyear;
    }

    public boolean equals(Semester s){

        boolean res = (s.semname.compareTo(this.semname) == 0) || (s.semyear == this.semyear);

        return res;
    }

    public String toString(){

        String res = "";
        String sfl = "" + this.semname.charAt(0);
        String semname = this.semname.substring(1);
        res = res + sfl.toUpperCase() + semname + " " + semyear;
        return res;
    }
}
