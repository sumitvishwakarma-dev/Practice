import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ComparatorAndComparable {

    public  static void main(String args[]){

        EmployeeForComparatorAndComparable emp1 = new EmployeeForComparatorAndComparable(
                "Sumit",12,"SDE"
        );
        EmployeeForComparatorAndComparable emp2 = new EmployeeForComparatorAndComparable(
                "amit",13,"Director"
        );EmployeeForComparatorAndComparable emp3 = new EmployeeForComparatorAndComparable(
                "Sit",17,"Intructor"
        );EmployeeForComparatorAndComparable emp4 = new EmployeeForComparatorAndComparable(
                "sujit",9,"MANAGER"
        );EmployeeForComparatorAndComparable emp5 = new EmployeeForComparatorAndComparable(
                "aman",4,"INTERN"
        );

        List<EmployeeForComparatorAndComparable> list = new ArrayList<>();
        list.add(emp1);
        list.add(emp2);
        list.add(emp3);
        list.add(emp4);
        list.add(emp5);

        System.out.println(list);


    }
}
