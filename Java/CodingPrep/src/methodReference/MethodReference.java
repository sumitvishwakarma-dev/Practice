package methodReference;

public class MethodReference {

    public static void main(String [] args){
        CalculateSum c1 = (a,b) -> {
           return MathCalculation.add(a,b);
        };

        // To make the method reference
        //    1. Only have one method
        //      2. Method calling should happen

        int sum = c1.add(10,40);
        CalculateSum c2 = MathCalculation :: add;
        System.out.println("Sum of c1 : "+sum);
        System.out.println("Sum of c2: "+c2.add(20,12));

    }
}
