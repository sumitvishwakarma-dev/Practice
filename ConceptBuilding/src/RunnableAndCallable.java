import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class RunnableAndCallable {

    public static void main(String [] args){

        print();
    }

    static void print(){

        ExecutorService executorService = Executors.newFixedThreadPool(2);

        executorService.submit(
                () -> {
                    System.out.println("Runnable will not return anything like Callable but currently running in " +Thread.currentThread().getName());
                }
        );

        Future<Integer> future =  executorService.submit(
                () -> {
                    System.out.println("Callable will be in "+Thread.currentThread().getName());
                    return 100;
                }
        );

        try{
            System.out.println("Callable returned the value "+future.get());
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }

    }
}
