public class Lambada {
    public static void main(){
       // Calculator c = new Addition();
       // System.out.println(c.addition(45,78));
        print(4,6,(a,b)-> a*b);
        Calculator cal = (a,b)->a+b;
        print(4,8,cal);
        System.out.println("Addition : "+cal);

    }
    public  static void print(int a,int b, Calculator c){
        System.out.println(c.addition(a,b));
    }
}

interface Calculator{
    int addition(int a , int b);
}

//class Addition implements Calculator{
//    @Override
//    public int addition(int a, int b){
//        return a+b;
//    }
//}
