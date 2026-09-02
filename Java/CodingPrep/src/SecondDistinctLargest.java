import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SecondDistinctLargest {

    public static void main(String[] args) {

        int [] arr = {2,13,13,1,4,2,12};
        int numberLargestSecond = secondLargest(arr);
        System.out.println("Second Largest :: "+numberLargestSecond);
    }

    public static int secondLargest( int [] arr){

        List<Integer> list = List.of(1,2,3,2,3,4,5);
        Map<Integer,String> map = Map.of(1,"Sumit", 2,"Amit");


        Integer [][] arr2 = {
                {1,2,3},
                {25,3,21,1}
        };

        List<Integer> list2 = Arrays.asList(arr2).stream()
                .flatMap(Arrays::stream)
                .collect(Collectors.toList());
        System.out.println(list2);




        int n = arr.length;

        if(n == 1){
            return -1;
        }

        Integer largest = null;             // int largest = Integer.MIN_VALUE;
        Integer secondLargest = null;       // int secondLargest = Integer.MIN_VALUE;

        for(int i : arr){
            if(largest == null || i > largest){
                secondLargest = largest;
                largest = i;
            }else if((secondLargest == null || i > secondLargest) && i != largest){
                secondLargest = i;
            }
        }
        return secondLargest == null ? -1 : secondLargest;
    }
}
