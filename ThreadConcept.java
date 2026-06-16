public class ThreadConcept {
    void main(){
        Thread t1 = new Thread(
                () -> System.out.println("Main Thread Start :: ")
        );
        t1.start();
        try{
            Thread.sleep(2000);
            System.out.println("Main Thread Start 32:: ");

        }
        catch(InterruptedException e){
            System.out.println(e.getMessage());
        }

        System.out.println("Main Thread Ends ::");
    }
}
