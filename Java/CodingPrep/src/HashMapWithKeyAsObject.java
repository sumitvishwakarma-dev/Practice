import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class HashMapWithKeyAsObject {

    public static void main(String [] args){
        Employee empl1 = new Employee(101,"Sumit");
        Employee emp2 = new Employee(101,"Amit");

        Map<Employee, String> map = new HashMap<>();
        map.put(empl1 , "Developer");
        System.out.println(map.get(emp2));
    }


}

class Employee{

    int id;
    String name;

    Employee(int id , String name){
        this.id = id;
        this.name = name;
    }

    @Override
    public boolean equals(Object obj){

        if(this == obj)
            return true;

        if( !(obj instanceof Employee)){
            return false;
        }

        Employee employee = (Employee) obj;

        return id == employee.id;

    }

    @Override
    public int hashCode(){
        return Objects.hash(id);
    }
}
