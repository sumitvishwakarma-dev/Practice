public class ContructorChainingWithThis {
    void main(){
        Student student1= new Student();
    }
}
class Student{
    String name;
    int age;
    int rollNumber;
    String clg;

    Student(){
        this("Sumit");
    }
    Student(String name){
        this(name, 24);
    }
    Student(String name, int age){
        this(name, age, 001 );
    }
    Student(String name, int age, int rollNumber){
        this(name, age, rollNumber, "VIT");
    }
    Student(String name,int age, int rollNumber,String clg){
        this.name=name;
        this.age=age;
        this.rollNumber=rollNumber;
        this.clg=clg;

        IO.println("Name:\t"+name+"\nAge:\t"+age+"\nRoll Number:\t"+rollNumber+"\nCollege:\t"+clg);
    }
}
