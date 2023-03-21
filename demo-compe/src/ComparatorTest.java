import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparatorTest {
    public static void main(String[] args) {
        List <Student> studentList = new ArrayList<>();
        studentList.add(new Student(1,"DDD",24));
        studentList.add(new Student(2,"AAA",21));
        studentList.add(new Student(3,"CCC",22));
        studentList.add(new Student(4,"BBB",22));
        Collections.sort(studentList, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
        for (Student student : studentList){
            System.out.println(student.toString());
        }
        System.out.println();

        Collections.sort(studentList, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o2.getID() - o1.getID();
            }
        });
        for (Student student : studentList){
            System.out.println(student.toString());
        }

    }
}