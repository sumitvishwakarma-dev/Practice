import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparatorConcept {
    public static void main(String [] args){
        List<SchoolStudent> list = new ArrayList<>();
        list.add(new SchoolStudent("Sumit", 78,101));
        list.add(new SchoolStudent("Amit", 98,102));
        list.add(new SchoolStudent("Soomit", 78,104));
        list.add(new SchoolStudent("demit", 87,103));

//
//        Comparator<SchoolStudent> c1 =new SortByName();
//        Comparator<SchoolStudent> c2 =new SortByMarks();
//        Comparator<SchoolStudent> c3 =new SortByRollNo();

//        Collections.sort(list, new Comparator<SchoolStudent>() {
//            @Override
//            public int compare(SchoolStudent s1, SchoolStudent s2) {
//                return s1.marks - s2.marks;
//            }
//        });

        //Using lambda expression

        Collections.sort(list, (s1,s2)-> s2.marks-s1.marks);

        System.out.println("SORT by Marks NO ::");
        for(SchoolStudent mark : list){
            System.out.println(mark.rollNo+" "+mark.name+" "+mark.marks);
        }

    }
}
class SchoolStudent{
    String name;
    int marks;
    int rollNo;

    SchoolStudent(String name, int marks, int rollNo){
        this.name =name;
        this.rollNo = rollNo;
        this.marks = marks;
    }
}

//class SortByName implements Comparator<SchoolStudent> {
//
//    @Override
//    public int compare(SchoolStudent s1, SchoolStudent s2) {
//        return s1.name.compareTo(s2.name);
//    }
//}
//class SortByMarks implements Comparator<SchoolStudent>{
//    @Override
//    public int compare(SchoolStudent s1, SchoolStudent s2) {
//        return s1.marks - s2.marks;
//    }
//}
//class SortByRollNo implements Comparator<SchoolStudent>{
//    @Override
//    public int compare(SchoolStudent s1, SchoolStudent s2) {
//        return s1.rollNo - s2.rollNo;
//    }
//}
