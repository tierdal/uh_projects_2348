public class Exam2 {

    public static void main(String[] args) {
        String student_name_first;
        String student_name_last;

        Student [][] school = new Student[5][20];
        for(int counter_classroom = 1; counter_classroom < 6; counter_classroom++){
            int student_counter = 0;
            if(counter_classroom>2){
                System.out.println("-Classroom "+ counter_classroom + "-----------------");
                System.out.println("No Students in this class.");
            } else {
                System.out.println("-Classroom " + counter_classroom + "-----------------");
                for (int counter_student = 1; counter_student < 4; counter_student++) {
                    student_counter++;
                    student_name_first = "FirstName_c" + counter_classroom + "s" + student_counter;
                    student_name_last = "LastName_c" + counter_classroom + "s" + student_counter;
                    school[counter_classroom - 1][counter_student - 1] = new Student(student_name_first, student_name_last);
                    outputSchool(school[counter_classroom - 1][counter_student - 1].getStudentID(),school[counter_classroom - 1][counter_student - 1].getStudentName());
                }
            }
        }
    }

    private static void outputSchool(int id, String name) {

        System.out.println(id + ", " + name);
    }
}
