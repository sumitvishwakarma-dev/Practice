import java.util.Comparator;
import java.util.TreeSet;

public class TreeSetWithComparatorAndComparable {

    public static void main(String [] args){

        TreeSet tree = new TreeSet(new MyComparator());
        tree.add("Su");
        tree.add(new StringBuffer("Su"));
        tree.add("AA");
        tree.add(new StringBuffer("Amit"));
        tree.add(new StringBuffer("A"));
        tree.add("B");

        System.out.println(tree);
    }
}

class MyComparator implements Comparator{
     public int compare(Object obj1, Object obj2){
         String s1 = obj1.toString();
         String s2 = obj2.toString();
         int s1Length = s1.length();
         int s2Length = s2.length();

         if (s1Length < s2Length)
             return -1;
         else if (s1Length > s2Length)
                    return 1;
         else return s1.compareTo(s2);   // if length same then use alphabetical order to do sort
     }
}
