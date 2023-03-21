import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ComparableTest {
    public static void main(String[] args) {
        // create student list
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student(1,"AAA",24));
        studentList.add(new Student(2,"DDD",21));
        studentList.add(new Student(3,"CCC",22));
        studentList.add(new Student(4,"BBB",22));

        Collections.sort(studentList);

        for (Student student : studentList){
            System.out.println(student.toString());
        }
    }
}
