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

    }
}
