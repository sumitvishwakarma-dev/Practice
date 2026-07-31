import java.util.*;

public class Maps {
    public static void main(String [] args ){
        Map<Integer, String> map = new HashMap<>();
        map.put(101,"Sumit");
        map.put(102,"Amit");
        Map<Integer,String> map2 = new HashMap<>();
        map2.put(101,"Sumit");
        map2.put(102,"Aman");
       // map.putAll(map2);

       // System.out.println("Map :: "+map.putIfAbsent(203,"Aman")); //null
       // System.out.println("Map :: "+map.putIfAbsent(203,"Aman")); //Aman

//        System.out.println("Map :: "+map2);
//        System.out.println(map.containsValue("Amit"));      //true
//        System.out.println(map);                           // {101=Sumit, 102=Amit}
//
//        System.out.println(map2);                           //{101=Sumit, 102=Aman}
//        System.out.println(map.equals(map2));               //false


        List<CollegeStudent> list = new ArrayList<>();
        list.add(new CollegeStudent("Sumit",57));
        list.add(new CollegeStudent("Amit", 89));
        list.add(new CollegeStudent("Aman",53));


        Collections.sort(list);

        for(CollegeStudent clgStudent : list){
            System.out.println(clgStudent.name + "," +clgStudent.marks);    //Ascending Order


        }

    }
}

class CollegeStudent implements Comparable<CollegeStudent>{
    String name;
    int marks;

    CollegeStudent(String name, int marks){
        this.name = name;
        this.marks = marks;
    }

    @Override
    public int compareTo(CollegeStudent other) {
        return this.marks - other.marks;
    }
}
