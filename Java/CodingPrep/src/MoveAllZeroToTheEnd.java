public class MoveAllZeroToTheEnd {

    public static void main(String[] args) {

        int [] arr = {1,0,2,5,0,3,0,4};
        for(int i : arr){
            System.out.print(i+" ");
        }
        System.out.println();

        int [] arrModified = putAllZeroAtEnd(arr);
        for(int i : arrModified){
            System.out.print(i+" ");
        }
    }

    public static int[] putAllZeroAtEnd(int [] arr){

        int index = 0;

        for(int i= 0; i<arr.length; i++){
            if(arr[i] != 0){
                arr[index] = arr[i];
                index++;
            }
        }
        while (index < arr.length) {
            arr[index] = 0;
            index++;
        }

        return arr;
    }
}
