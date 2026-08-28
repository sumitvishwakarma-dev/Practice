import java.util.Arrays;

public class SumOfSqaureOfOddNumbers {

    public static void main(String[] args) {
        int [] arr = {2,3,1,4,5,9,3,2,7};

        long sum = sumOfSqaureOfOdd(arr);
       System.out.println("Sum of sqaure of odd numbers "+sum);
    }

    public static long sumOfSqaureOfOdd(int [] arrs){

        long  sumOfSquareOdd = Arrays.stream(arrs)
                .filter(x -> x %2 != 0)
                .map(x -> x*x)
                .sum();


        return sumOfSquareOdd;

    }
}


