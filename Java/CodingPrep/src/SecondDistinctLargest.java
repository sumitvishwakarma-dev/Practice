public class SecondDistinctLargest {

    public static void main(String[] args) {

        int [] arr = {2,13,13,1,4,2,12};
        int numberLargestSecond = secondLargest(arr);
        System.out.println("Second Largest :: "+numberLargestSecond);
    }

    public static int secondLargest( int [] arr){
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
