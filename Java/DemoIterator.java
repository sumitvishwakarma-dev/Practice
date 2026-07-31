import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DemoIterator {
    public static void main(String [] args ){

        List<String> list = new ArrayList<>();
        list.add("Sumit");
        list.add("Amit");
        list.add("Abhi");
        list.add("Sabhi");
        Iterator<String> itr = list.iterator();

        while(itr.hasNext()){

           if (itr.next().equals("Abhi")) {
                itr.remove();
           }
           System.out.println(itr.next());

        }

        System.out.println(" ::::::::::::::::::::: ");

        for(String str : list){
            System.out.println(str);
        }
    }


}
