import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class Solution {

    void main(){
        int[]  result = {2,7,11,15};
//        Arrays.sort(result);

        int[] response = twoSum(result,26);
        for(Integer i : response){
            System.out.print(i+" ");
        }
    }

//        public int[] twoSum(int[] nums, int target) {
//            Map<Integer,Integer> map = new HashMap<Integer, Integer>();
//            for(int i=0;i< nums.length;i++){
//                map.put(nums[i],i);
//            }
//            for(int i=0; i<map.size();i++){
//                int diff = target - nums[i];
//                 if(map.containsKey(diff) && map.get(diff) != i){
//                     return new int[] {i , map.get(diff)};
//                 }
//            }
//            return new int[] {};
//        }

            public int[] twoSum(int[] nums, int target) {
            int left=0;
            int right=nums.length-1;

            int[][] sortedArr = new int[nums.length][2];

            for (int i=0; i<nums.length;i++){
                sortedArr[i][0] = nums[i];
                sortedArr[i][1] = i;
            }

            Arrays.sort(sortedArr, (a,b )-> a[0] - b[0]);

            while(left < right){
                int number = sortedArr[left][0] + sortedArr[right][0];
                if(number == target){
                    return new int[] {sortedArr[left][1] ,sortedArr[right][1]};
                }else if(number > target){
                    right--;
                }else {
                    left++;
                }
            }

            return new int[] {};
        }
}
