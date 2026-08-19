import java.util.Scanner;

public class reverseWordFromStrings {

    public static void main(String[] args){

        Scanner sc =new Scanner(System.in);

        System.out.println("Enter the String ");
        String str = sc.nextLine();
        int left=0;
        int right= str.length() -1;

        String [] word = str.split("\\s+");


        StringBuilder result = new StringBuilder();         // Used it to avoid repeated IO calls and easy to trim

        // Each word reverse keep place same

//        for(String strWord : word){
//            left=0;
//            right = strWord.length()-1;
//            char []  arr = strWord.toCharArray();
//
//            while(left < right){
//                char temp = arr[left];
//                arr[left] = arr[right];
//                arr[right] = temp;
//                left++;
//                right--;
//            }
//
//            result.append(arr);
//            result.append(" ");
//        }
//        System.out.println(result);
//
        // Reverse the Whole String

//        char [] characterArr = str.toCharArray();
//
//        while(left < right){
//                char temp = characterArr[left];
//                characterArr[left] = characterArr[right];
//                characterArr[right] = temp;
//                left++;
//                right--;
//        }
//
//        System.out.println(characterArr);

        //

        for(int i=word.length-1;i>=0;i--){
            result.append(word[i]);
            if(i != 0){
                result.append(" ");
            }
        }
        System.out.print(result.toString());
    }


    // instead of split
    // for(int i=0;i<=word.length; i++){
    //     if(i == word.length || word[i] == ' '){
    //         left=0;
    //         right=word.length-1;
    //         while(left < right){
    //             char temp = word[left];
    //             word[left] = word[right];
    //             word[right] = temp;
    //             left++;
    //             right--;
    //         }
    //     }
    // }




}
