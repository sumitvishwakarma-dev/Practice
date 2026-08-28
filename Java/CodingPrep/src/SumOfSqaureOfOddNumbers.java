import java.util.Arrays;
import java.util.List;

public class SumOfSqaureOfOddNumbers {

    public static void main(String[] args) {
        int [] arr = {2,3,1,4,5,9,3,2,7};

        long sum = sumOfSqaureOfOdd(arr);
       System.out.println("Sum of sqaure of odd numbers "+sum);
    }

    public static long sumOfSqaureOfOdd(int [] arrs){

        long  sumOfSquareOdd = Arrays.stream(arrs)
                .filter(x -> x % 2 != 0)
                .map(x -> x*x)
                .sum();

        List<Integer> list = Arrays.asList(1,3,2,4);
        int num = list.stream()
                .filter(x -> x % 2 != 0)
                .mapToInt(x -> x * x)
                .sum();
        System.out.println(num);

        List<Integer> listInteger = Arrays.stream(arrs)
                .filter(x -> x % 2 != 0)
                .boxed()
                .map(x -> x * x)
                .toList();

        int sumInteger = 0;
        for (int i : listInteger){
            sumInteger += i;
        }
        System.out.print(sumInteger);


        return sumOfSquareOdd;

    }
}


