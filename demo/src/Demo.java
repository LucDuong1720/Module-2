class Student{
    int rollno;
    String name;

    Student(int rollno, String name){
        this.rollno=rollno;
        this.name=name;
    }

//    public String toString(){
//        return rollno+" "+name;
//    }
    public static void main(String args[]){
        Student s1=new Student(101,"A");
        Student s2=new Student(102,"B");

        System.out.println(s1);
        System.out.println(s2);
    }
}
