import java.util.LinkedList;
import java.util.Scanner;

public class Demo {

    public static void main(String [] args){

        Scanner sc= new Scanner(System.in);

        System.out.println("Enter the linked list size :");
        int valueSize = sc.nextInt();
        LinkedList<Integer> list = new LinkedList<>();
        System.out.println("Enter the value for linked list :");
        for (int i=0; i < valueSize; i++){
            int numValue = sc.nextInt();
            if (numValue > 0){
                list.add(numValue);
            }else{
                return;
            }
        }

    }
}
