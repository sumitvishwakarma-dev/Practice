import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class InputStreamClass
{
    void main() throws IOException {

        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter the age : " );
        int age = Integer.parseInt(br.readLine());
        System.out.print("Enter the name : " );
        String name= br.readLine();
        System.out.println("Entered name is : " +name);
        System.out.println("Entered age is : " +age);

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter percentage : ");
        double percentage = sc.nextDouble();
        System.out.println("Entered percentage is : " +percentage);


    }
}
