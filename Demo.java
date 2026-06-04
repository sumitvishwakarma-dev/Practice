import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Demo {
    public static  void main(String[] args) throws IOException {
        Scanner sc =  new Scanner(System.in);
        System.out.print("Enter the 1st value :: ");
        int a = sc.nextInt();
        System.out.print("Enter the 2nd value :: ");
        int b = sc.nextInt();
        int c = a+b;
        System.out.println("Sum is : "+c
        );

        InputStreamReader inputSR = new InputStreamReader(System.in);
        BufferedReader bufferedReader =new BufferedReader(inputSR);
        System.out.print("Enter the 1st value :: ");
        int a1=  Integer.parseInt(bufferedReader.readLine());
        System.out.print("Enter the 2nd value :: ");
        int a2 = Integer.parseInt(bufferedReader.readLine());
        int sum  = a1 + a2;
        System.out.print("Sum is :: "+sum);

//        int i1 = args.length;          accessing arguments
//        System.out.println(i1);


    }
}
