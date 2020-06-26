package in_action.byte_dance;

import java.util.HashSet;
import java.util.Set;

/**
 * @Description
 * @Author fyz
 * @Date 2020/6/23 10:48
 **/
public class Q1_Length_Of_Longest_Substring {
    public int lengthOfLongestSubstring(String s) {
        int res = 0;
        int left = 0;
        int right = 0;
        Set<Character> set = new HashSet<>();
        while (left < s.length() && right < s.length()) {
            char ch = s.charAt(right);
            if (set.contains(ch)) {
                set.remove(s.charAt(left));
                left++;
            } else {
                set.add(ch);
                right++;
                res = Math.max(res, set.size());
            }
        }
        return res;
    }
}
