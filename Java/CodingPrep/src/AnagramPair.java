
import java.util.*;
public class AnagramPair {
        public static void main(String[] args) {

            String[] names = {
                    "apple",
                    "elpap",
                    "sumit",
                    "timus",
                    "amit",
                    "tmai",
                    "aman",
                    "atim"
            };
            List<List<String>> list = pairAccrodingToAlpha(names);
            System.out.println(list);

        }

        public static List<List<String>> pairAccrodingToAlpha(String [] strs){

            Map<String, List<String>> map = new HashMap<>();
            for(String str : strs){
                char [] ch = str.toCharArray();
                Arrays.sort(ch);
                String key = new String(ch);
                map.computeIfAbsent(key, k -> new ArrayList<>()).add(str);
            }

            return new ArrayList<>(map.values());
        }
}
