import java.util.*;

public class DiffBetweenPairAsTarget {

    public static void main(String [] args){

        int [] arr = {2,4,3,5,1,7,3};
        int diff = 2;

        Set<List<Integer>> result = new HashSet<>();
        Set<Integer> set = new HashSet<>();

        for (int i : arr){
            set.add(i);
        }

        for (int num : arr){
            int addition = num + diff;
            if(set.contains(addition)){
                result.add(Arrays.asList(num ,addition));
            }
        }
        System.out.print(result);


        // Remove Duplicates from List

        List<Integer> list = List.of(1,2,4,3,2,5,6,3);
        Set<Integer> setDiffernceList = new HashSet<>(list);
        System.out.print(setDiffernceList);


        //Remove duplicate from Array
        int [] arr1 = {2,4,1,3,2,4,6,5,1};
        Set<Integer> duplicateSetRemove = new HashSet<>();
        for (int i : arr1){
            duplicateSetRemove.add(i);
        }
        System.out.print(" :::::::::: "+duplicateSetRemove);

            // Preserve Order using stream API
        List<Integer> duplicateList = Arrays.stream(arr1)
                .boxed()
                .distinct()
                .toList();
        System.out.println(duplicateList);

    }
}
