import java.util.Random;

public class Student {
    public int studentID;
    public String studentNameFirst;
    public String studentNameLast;

    public Student(String first_name, String last_name){
        Random rnd = new Random();
        setStudentID(rnd.nextInt(100000));
        setStudentName(first_name, last_name);
    }

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public String getStudentName() {
        return studentNameLast + ", " + studentNameFirst;
    }

    public void setStudentName(String studentNameFirst, String studentNameLast) {
        this.studentNameFirst = studentNameFirst;
        this.studentNameLast = studentNameLast;
    }
}

