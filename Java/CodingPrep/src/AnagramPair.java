
import java.util.*;
import java.util.stream.Collectors;

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
           pairAccrodingToAlpha(names);

        }

        public static void pairAccrodingToAlpha(String [] strs){

            Map<String, List<String>> map = new HashMap<>();
            for(String str : strs){
                char [] ch = str.toCharArray();
                Arrays.sort(ch);
                String key = new String(ch);
                map.computeIfAbsent(key, k -> new ArrayList<>()).add(str);
            }
            map.forEach((key, value) ->
                    System.out.println(key + " → " + value));

        }
}
