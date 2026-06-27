public class ThreadSynchronizedCencept {
    public static void main(String args []){
        ThreadInner thi =new ThreadInner();

        Thread t1 = new Thread(()-> thi.show());
//        Thread t2 = new Thread(thi::show);
        Thread t2 = new Thread(()-> ThreadInner.show() );


        Thread t3 = new Thread(()-> thi.deposit() );
        Thread t4 = new Thread(()-> thi.withdraw() );


        t3.start();
        t4.start();
        t1.start();
        t2.start();

        System.out.println("Thread Finished");
    }
}
class ThreadInner{
  /* can keep synchronized here also*/  public static void show(){
         synchronized(ThreadInner.class){   //block synchronized with having classname.class due to static method
             System.out.println(Thread.currentThread().getName()+" Thread inside");
             try{
                 Thread.sleep(2000);
             } catch (InterruptedException _) {}
             System.out.println(Thread.currentThread().getName()+" Thread inside finished");
         }
         }

        synchronized public void deposit(){
                System.out.println("Deposited"+ Thread.currentThread().getName());
         }


         synchronized public void withdraw(){
            System.out.println("Withdraw"+Thread.currentThread().getName());
        }

}
