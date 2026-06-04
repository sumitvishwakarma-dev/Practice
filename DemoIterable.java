import java.util.Iterator;

public class DemoIterable {
    public static void main(String[] args){
        String [] name = {"Sumit","Amit","Abhi","Vandan"};
        NameContaines names= new NameContaines(name);

        Iterator<String> itr= names.iterator();
        while(itr.hasNext()){
            System.out.println(itr.next());
        }

//        for(String name1 : name){
//            System.out.println(name1);
//        }

    }

    static class NameContaines implements Iterable{

        private String[] names;
        private int size;

        NameContaines(String [] names ){
            this.names = names;
            this.size = this.names.length;
        }

        @Override
        public Iterator iterator() {
            return new Iterator<String>() {                 //Anonymous Class
                private int pos = 0;
                @Override
                public boolean hasNext() {
                    return pos < size;
                }

                @Override
                public String next() {
                    return names[pos++];
                }
            };
        }
    }
}
