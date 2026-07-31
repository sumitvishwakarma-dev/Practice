public class ObjectOrient {
    static int add(int a, int b) {

        int result = a + b;
        return result;

    }

    static void fib(int n){

//        int x= fib(n-1);
//
//        int y=fib(n-2);
//        int series = x + y;
//        return series;
        int n1=0,n2=1,n3;


        for (int i=0;i<n;i++){
            System.out.print(n1 +" ");
            n3 = n1 + n2;
            n1=n2;
            n2=n3;

        }
    }

    static void main(String[] args) {

        System.out.println(add(1028, 356));
        fib(10);
    }
}
