package advance;

public class Object {

    void main(){

        Student s=  new Student();
        Student s2=  new Student();
        s.name="Sumit";
        s.age=20;
        s2.name="Sumit";
        s2.age=20;
        System.out.print(s.toString());
        System.out.println("Equals ::: "+s.equals(s2));
    }
}

class Student extends Object {
    String name;
    int age;


    @Override
    public String toString(){
        return (name+" , " +age);
    }




}
