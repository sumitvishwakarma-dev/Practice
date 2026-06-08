import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class LambadaTypes {
    public static void main(String [] args){
        Function<Integer,Integer> fun = x->x*x;
        System.out.println(fun.apply(8));

        Consumer<Integer> consume = x -> System.out.println(x+x);
        consume.accept(6);

        Supplier<Double> supplier = () -> Math.sqrt(9);
        System.out.println(supplier.get());

        Predicate<Integer> predicate =  x -> (x % 2 == 0);
        System.out.println(predicate.test(9));

        List<Integer> list =new ArrayList<>(List.of(1,2,3,4,5,3,2,56,8));
        //list.forEach(x -> System.out.println(x));

        list.forEach(System.out :: println);

        //Preicate Chaining
        Predicate<StudentPredicate> isPassed = x -> x.marks>=40;
        Predicate<StudentPredicate> isAdult = x -> x.age >= 18;
        Predicate<StudentPredicate> isEligible = isPassed.and(isAdult);
        System.out.println(isEligible.test(new StudentPredicate(20,40)));
    }
}
class StudentPredicate{
    int age;
    int marks;

    public StudentPredicate(int age, int marks){
        this.age = age;
        this.marks =marks;
    }
}
