import java.util.*;

public class Demo {

    public static void main(String [] args){

        List<Integer> arr = List.of(2,1,3,2,4,3,5,4,6,75);
        Set<Integer> set = new HashSet<>(arr);
        System.out.println(set);
    }

}
