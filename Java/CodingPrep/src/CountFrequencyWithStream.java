import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class CountFrequencyWithStream {

    public static void main(String [] args){
        int [] arr ={2,1,4,3,3,2,9,6,9,4,7,5,8};
        Map<Integer,Long> countFrequency = countFrequency(arr);
        System.out.println(countFrequency);
    }

    public static Map<Integer,Long> countFrequency(int [] nums){

        Map<Integer,Long> countFrequencyMap = Arrays.stream(nums)
                .boxed()
                .collect(Collectors.groupingBy(
                        element -> element,
                        Collectors.counting()
                ));


        // ----------- without Stream frequency Count ------------
//
//        Map<Integer,Long> countFrequencyMap = new HashMap<>();
//        for (int i : nums){
//            countFrequencyMap.put(i,
//                    countFrequencyMap.containsKey(i) ? countFrequencyMap.get(i)+1 : 1);
//        }

        countFrequencyMap.entrySet()
                .stream()
                .filter(element -> element.getValue() > 1)
                .forEach(System.out :: println);

        return countFrequencyMap;
    }



}
