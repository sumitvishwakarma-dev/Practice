import java.util.*;

public class TwoSumReturnAllPair {

    public static void main(String[] args) {

        int [] arr = {2,2,7,3,6,9};
        int target = 9;

        Map<Integer,Integer> map = new HashMap<>();
        List<List<Integer>> result = new ArrayList<>();

        for(int i=0; i<arr.length; i++){

            map.put(arr[i],i);

        }

        System.out.println(map);

        for(int numIndex=0; numIndex < arr.length ; numIndex++){
            int diff = target - arr[numIndex];

            if(map.containsKey(diff) && map.get(diff) > numIndex){
                result.add(Arrays.asList(numIndex, map.get(diff)));
            }
        }

        System.out.print(result);

    }
}
