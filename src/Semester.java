public class Semester {
    public String semname;
    public int semyear;
    public Semester(String semname, int semyear){
        this.semname = semname;
        this.semyear = semyear;
    }
    public boolean equals(Semester s){
        boolean res = false;
        if((s.semname.compareTo(this.semname) == 0) || (s.semyear == this.semyear)){
            res = true;
        }
        return res;
    }

    public String toString(){
        String res = "";
        String sfl = "" + this.semname.charAt(0);
        String semname = this.semname.substring(1);
        res = res + sfl + semname + " " + semyear;
        return res;
    }
}
