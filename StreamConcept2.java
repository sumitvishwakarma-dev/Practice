import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamConcept2 {
    void main(){





//        List<Integer> list = List.of(23,24,53,67,43,89);
//                list.stream()
//                        .filter(x -> x >25)
//                        .peek(System.out :: println)
//                        .sorted((a,b)-> b-a)
//                        .map(x -> x *2)
//                        .forEach(System.out :: println);


//        Stream.iterate(1, x-> x+2)
//                .limit(10)
//                .skip(5)
//                .toList()
//                .forEach(System.out :: println);
//
//        List<Integer> list2 = new ArrayList<>(List.of(10,20,13,24,31,29));
//        list2.stream()
//                .collect(Collectors.toList());
//        list2.add(90);
//        list2.add(2,16);
//        list2.add(5,27);

//        System.out.println(list2);
//
//        Optional<Integer> sum = list2.stream()
//                .reduce((a,b) -> a+b);
//        System.out.print(" "+sum.get());              //260

//        int sum = list2.stream()
//                .reduce(0,(a,b) -> a+b);
//        System.out.print(" "+sum);                  //260

        Optional<User> user = getUser();

        user.map(x -> x.address)
                .map(x -> x.city)
                .ifPresentOrElse(System.out :: println, () -> System.out.print("Unknown"));
                        // if null then get unknown else that value

    }
    public static Optional<User> getUser(){

        Address address =new Address();
        address.city = "Mumbai";
        User u = new User();
        u.address = address;
        return Optional.of(u);
    }
}
class User{
    public Address address;
}

class Address {
    String city;
}
