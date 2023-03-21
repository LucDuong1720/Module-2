public class Student implements Comparable<Student> {
    private int id;
    private String name;
    private int age;
    public Student(){

    }

    public Student(int id, String name, int age){
        super();
        this.id = id;
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student: id= " + id + ", name= " + name
                + ", age= " + age;
    }

    @Override
    public int compareTo(Student student){
        if (this.age == student.age){
            return student.getID() - this.getID();
        }
        return this.getAge() - student.getAge();
    }

    public int getAge(){
        return age;
    }
    public String getName(){
        return name;
    }

    public int getID(){
        return id;
    }
}