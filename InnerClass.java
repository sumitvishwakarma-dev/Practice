class A1{
    public void show(){
        System.out.println("In A show");
    }

    class B1 {
        public void show2(){
            System.out.println("In  B show");
        }
    }
}
public class InnerClass {
    public static void main(String [] args ){
        A1 a= new A1();
        a.show();
        A1.B1 b = a.new B1();
        b.show2();
    }
}
