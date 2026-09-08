import java.util.concurrent.CompletableFuture;

public class CompletableFutureWithThen {

    public static void main(String [] args){

      CompletableFuture.supplyAsync(
              () -> {
                  System.out.println("In Completable Future ");
                  return "Sumit";
              }
      ).thenAccept(name -> System.out.println("Sending welcome email to "+name));

    }

}
