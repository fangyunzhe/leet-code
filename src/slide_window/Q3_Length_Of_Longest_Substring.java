package slide_window;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author fyz
 * @Date 2020/6/8 17:42
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * 示例 1:
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * <p>
 * 示例 2:
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * <p>
 * 示例 3:
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
 **/
public class Q3_Length_Of_Longest_Substring {

    public int lengthOfLongestSubstring(String s) {
        int res = 0;
        int left = 0;
        int right = 0;
        Set<Character> set = new HashSet<>();
        while (left < s.length() && right < s.length()) {
            char c = s.charAt(right);
            if (set.contains(c)) {
                set.remove(s.charAt(left));
                left++;
            } else {
                set.add(c);
                right++;
                res = Math.max(set.size(), res);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Q3_Length_Of_Longest_Substring().lengthOfLongestSubstring("abca"));
    }

}
