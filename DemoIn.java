public class DemoIn {
    public static void main(String args []){
        A obj = new B();
        obj.show1();

        B obj2 = (B) obj;
        obj2.show2();
        obj2.show1();
    }
}
class A{
    public void show1(){
        System.out.println("Show in A");
    }
}

class B extends A{
    public void show2(){
        System.out.println("Show In B");
    }
}