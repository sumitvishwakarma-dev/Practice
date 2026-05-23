public class Object {
    void main(){
        Student s1 =new Student();

    }

}

class Student{
    String name;
    int age;
    int rollNumber;
    String clg;
    Student(){
        this("unknown");
        IO.println("In Default Constructor");
    }

    Student(String name){
        this(name,28);
        IO.println("In one paramitraized Constructor");
    }

    Student(String name, int age){
        this(name,age,001);
        IO.println("In two parameter Constructor");
    }

    Student(String name,int age,int rollNumber){
        this(name,age,rollNumber, "VIT");
        IO.println("In three parameter Constructor");
    }

    Student(String name , int age, int rollNumber, String clg){
        this.name=name;
        this.rollNumber=rollNumber;
        this.age=age;
        this.clg=clg;

        System.out.println(name+"\t"+age+"\t"+rollNumber+"\t"+clg);
        IO.println("In 4th Constructor");
    }


}
