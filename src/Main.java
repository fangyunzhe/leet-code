import java.util.HashMap;
import java.util.Map;

/**
 * @Description
 * @Author fyz
 * @Date 2020/6/19 10:42
 **/
public class Main {
    public char firstUniqChar(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (int i = 0; i < s.length(); i++) {
            Integer count = map.get(s.charAt(i));
            if (count == 1) {
                return s.charAt(i);
            }
        }
        return ' ';
    }
}
