import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamConcept {
    public static void main(String [] args){

        String [] arr = {"Amit", "Sumit", "Virat","Rohit","Rohit"};
        Stream<String> str = Arrays.stream(arr);
        //System.out.println(str.toList());

        //Integer Stream
        Stream<Integer> value = Stream.of(23,13,24,56,43);
        str =str.sorted();
        str.forEach(System.out :: println);
        value.sorted().forEach(System.out :: println);

        System.out.println(":::::::::: Stream  Iterate :::::::::::::");
        Stream<Integer> strInt = Stream.iterate(1,x-> x+3)
        .limit(7);
        strInt.forEach(System.out::print);

        List<String> list = new ArrayList<>();
        int count=0;
        Stream<String> streamInt = Arrays.stream(arr).filter(x-> x == "Rohit");
        System.out.println(streamInt.count());

        System.out.println(":::::::::: Object to Int :::::::::::::");

        List<Integer> listInt = new ArrayList<>(List.of(2,1,3,4,2,2,2,1,6));
        Stream<Integer> stre = listInt.stream().filter(x -> x == 2);
        IntStream intStr = stre.mapToInt(x-> x);
//                intStr.forEach(System.out::print);
        System.out.println(intStr.count());

        System.out.println(":::::::::: Int to Object :::::::::::::");

        IntStream intStramVal = IntStream.of(1,2,3,4,5);
        Stream<Integer> strea = intStramVal.boxed();
        strea.forEach(System.out :: print);

    }
}
