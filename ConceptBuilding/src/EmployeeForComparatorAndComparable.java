public class EmployeeForComparatorAndComparable {

    private String name;
    private int empNumber;
    private String designation;

    EmployeeForComparatorAndComparable(String name,
                                       int empNumber,
                                       String designation){
        this.name = name;
        this.empNumber = empNumber;
        this.designation = designation;
    }


    public String getName(){
        return name;
    }

    public int getEmpNumber(){
        return empNumber;
    }

    public String getDesignation(){
        return designation;
    }

    public String setName(String name){
        return this.name = name;
    }

    public int setEmpNumber(int empNumber){
        return  this.empNumber = empNumber;
    }

    public String setDesignation(String designation){
        return this.designation = designation;
    }

    @Override
    public String toString() {
        return "EmployeeForComparatorAndComparable{" +
                "name='" + name + '\'' +
                ", empNumber=" + empNumber +
                ", designation='" + designation + '\'' +
                '}';
    }
}
