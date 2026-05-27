public class StaticAndFinal {

    public static void main(String args[]){

        RandomInStatic rIS = new RandomInStatic();
        IO.println("PI : "+rIS.PI);
        IO.println("PI : "+RandomInStatic.PI_Value);

        RandomInStatic.InnerRandomized ranInner = new RandomInStatic.InnerRandomized();

        IO.println("Inner Randmized :: "+ranInner.PI_Randomized_Value);

        IO.println("RandomInStatic.InnerRandomized Pvalue nm :::");RandomInStatic.InnerRandomized.pIvalue();


    }
}

class RandomInStatic{
    double PI= 3.14;
    static double PI_Value=3.14;

    static class InnerRandomized{
        double PI_Randomized_Value=3.148;

        static final void pIvalue(){
            IO.println("I'm in InnerRandomized pIvalue method :: ");
        }

    }

}
