
public class ImmutableTestClass {
    void main(){
        College1 collegeRef = new College1("IIT Bombay", "Mumbai");
        Student1 student = new Student1("Sumit",98,collegeRef);

        System.out.println("Name: " +student.getName()+"\nAge : "+student.getAge()+
                "\nCollege Name : "+ student.getCollege1().name+
                        "\nCollege address : "+student.getCollege1().address
                );

        student.getCollege1().name = "IIT G";
        student.getCollege1().address = "Assam";

        System.out.println("\nAfter altering the values ::::\n");
        System.out.println("Name: " +student.getName()+"\nAge : "+student.getAge()+
                "\nCollege Name : "+ student.getCollege1().name +
                    "\nCollege address : "+student.getCollege1().address
        );
    }
}

class Student1{
   private final String name;
    private final int age;
    private final College1 college1;

    Student1(String name, int age, College1 college1){
        this.name = name;
        this.age = age;
        this.college1 = new College1(college1.name,college1.address);   //redirecting to temp Object

    }

    public int getAge(){
        return this.age;
    }

    public String getName(){
        return this.name;
    }

    public College1 getCollege1() {
        return new College1(this.college1.name, this.college1.address);
    }
}

class College1{
    String name;
    String address;

    College1(String name, String address){
            this.name=name;
            this.address =address;
    }

}