import java.util.Comparator;
import java.util.PriorityQueue;

public class PriorityQueueDemo {

    public static void main(String [] args){

        PriorityQueue q = new PriorityQueue();
        System.out.println("Peek: "+q.peek());
        //System.out.println("Element: "+q.element()); //RE : NoSuchElementException
        for (int i=0; i<=10; i++){
            q.offer(i);
        }
        System.out.println("Queue Elements before Poll : "+q);
        System.out.println("Poll: "+q.poll());
        System.out.println("Queue Element after Poll : "+q);
        System.out.println("Poll: "+q.poll());
        System.out.println("Queue Element after Poll : "+q);

        System.out.println("/////// PRIORITY QUEUE USING COMPARATOR ////////");

        PriorityQueue pr = new PriorityQueue<>(15 , new MyComparatorForPriorityQ());
        pr.offer("Sumit");
        pr.offer("Amit");
        pr.offer("Aman");
        pr.offer("Atul");

        System.out.println("Priority Queue : " +pr);

    }
}

class MyComparatorForPriorityQ implements Comparator{

    public int compare(Object obj1 , Object obj2){

        String str1 = (String) obj1;
        String str2 = obj2.toString();
        return str2.compareTo(str1);

    }

}
