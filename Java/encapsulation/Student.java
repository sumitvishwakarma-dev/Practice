package encapsulation;

 class Student {

    private String name;
    private int age;

    Student(String name, int age){
        this.name=name;
        this.age=age;
    }

     void display(){
        System.out.println("Name : " +name+ "Age : "+age);
    }
}
