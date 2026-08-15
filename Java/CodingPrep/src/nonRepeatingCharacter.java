import java.util.HashMap;
import java.util.Map;

public class nonRepeatingCharacter {
    public static void main(String [] args){
        String s = "swiwssid";
        char nonRepeatingCharacter = nonRepeatCharacter(s);
        System.out.println("Non Repeating Character :: "+nonRepeatingCharacter);
    }

    public static char nonRepeatCharacter(String s){
        char [] character = s.toCharArray();
        Map<Character,Integer> map = new HashMap<>();

        for (char ch : character){
            map.put(ch, map.containsKey(ch) ? map.get(ch)+1 : 1);
        }
        System.out.println(map);
        char nonRepeatingChar = ' ';
        for (char c : character){
            if (map.get(c) == 1){
                nonRepeatingChar = c;
                break;
            }
        }

        return nonRepeatingChar == ' '? '\0' : nonRepeatingChar;
    }
}
