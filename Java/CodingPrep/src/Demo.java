import java.util.*;

public class Demo {

    public static void main(String [] args){

        List<Integer> arr = List.of(2,1,3,2,4,3,5,4,6,75);
        Set<Integer> set = new HashSet<>(arr);
        System.out.println(set);

        int [] arr1 = {3,2,4,1,6,5,7,2,4,8,2};
        int splitSize = 3;


        for (int i=0 ; i<arr1.length; i+=splitSize){
            int end = Math.min(i + splitSize,arr1.length);
            int [] splitedArr = Arrays.copyOfRange(arr1, i , end);

            System.out.println(Arrays.toString(splitedArr));
        }








    }

}
