import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IratableInArray {
    public static void main(String [] args){

        String [] names = {"Sumit","Amit","Raj","Aman"};
        NameContainer container = new NameContainer(names);

//        Iterator<String> it = container.iterator();
//        while(it.hasNext()){
//            System.out.println(it.next());
//        }

        for(String str : container){
            System.out.println(str);
        }

    }
}

class NameContainer implements Iterable<String>{
    private String[] names;
    private int size;

    NameContainer(String[] names){
        this.names = names;
        this.size = this.names.length;
    }

    @Override
    public Iterator<String> iterator() {
        return new Iterator<String>(){          //Anonymous Class
            private int pos = 0;

            @Override
            public boolean hasNext(){
                return pos < size;
            }

            @Override
            public String next(){
                return names[pos++];
            }
        };
    }

//    private class ArrayListIterator implements Iterator<String>{
//        private int pos = 0;
//        @Override
//        public boolean hasNext(){
//            return pos < size;
//        }
//        @Override
//        public String next(){
//            return names[pos++];
//        }
//    }

}
