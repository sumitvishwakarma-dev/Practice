import java.util.PriorityQueue;

public class PriorityQueues {
    public static void main(String [] args){
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.offer(20);
        pq.offer(10);
        pq.offer(30);
        pq.offer(40);
        pq.offer(50);



//        for (Integer i : pq){
//            System.out.println(i);
//        }

        PriorityQueue<Integer> pq2 = new PriorityQueue<Integer>((a,b)-> b-a);
        pq2.offer(10);
        pq2.offer(20);
        pq2.offer(30);
        pq2.offer(40);
        pq2.offer(50);

//        for (Integer pq2i : pq2){
//            System.out.println(pq2i);
//        }

        System.out.println(pq2.poll());
        System.out.println(pq2.poll());
        System.out.println(pq2.poll());
        System.out.println(pq2.poll());
        System.out.println(pq2.poll());




    }
}
