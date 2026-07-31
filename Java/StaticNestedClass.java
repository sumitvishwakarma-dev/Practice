public class StaticNestedClass {
    void main(){
//        Outer outer = new Outer();
//        Outer.Inner inner = outer.new Inner();
        Outer.Inner inner= new Outer().new Inner();
        inner.show();
    }
}
class Outer{
    static double principal;

    static double calculateRate(double principal, double rate){
        Outer.principal=principal;
        return principal * rate;
    }

    class Inner{
        void show(){
           double amount =  Outer.calculateRate(5000,10);
            IO.println("Principal "+Outer.principal+" Amount after 10% interest becomes "+ amount );
        }
    }

}
