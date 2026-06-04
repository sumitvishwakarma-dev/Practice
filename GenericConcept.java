public class GenericConcept {
    public static void main(String [] args){
//        Box b =new Box("Sumit");
//        System.out.println(b.getValue());
//        b.setValue(20);
//        System.out.println(b.getValue());
//
//        Box b1 =new Box(30);
//        Box b2 = new Box("SUMITS");
//        Box b3 = new Box(false);
//
//        Integer x= (Integer) b1.getValue() + 5;
//        String s =(String) b2.getValue() + 5;
//        Boolean bool =(Boolean) b3.getValue();
//
//        System.out.println(x);
//        System.out.println(s);
//        System.out.println(bool);

        Box<Integer, String> b= new Box<>(10,"Sumit");
        Box<Double, String> b1= new Box<>(10.0,"Amit");


        System.out.println(b.getValue()+","+b.getName());
        System.out.println(b1.getValue()+","+b1.getName());


        System.out.println("::::::::: Value Set ::::::::::");

        b1.setValue(11.0,"Sam Curren");
        b.setValue(11,"Tom Curren");


        System.out.println(b.getValue()+","+b.getName());
        System.out.println(b1.getValue()+","+b1.getName());

    }
}
class Box<T,S>{
   private T boxValue;
   private S name;

   Box(T boxValue, S name){
       this.boxValue = boxValue;
       this.name = name;
   }

   public T getValue(){
       return boxValue;
   }

   public S getName(){
       return name;
   }

   public void setValue(T boxValue, S name){
       this.boxValue=boxValue;
       this.name=name;
   }

}
