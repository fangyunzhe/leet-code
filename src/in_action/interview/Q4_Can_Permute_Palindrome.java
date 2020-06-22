package in_action.interview;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description
 * @Author fyz
 * @Date 2020/6/22 12:11
 * <p>
 * 给定一个字符串，编写一个函数判定其是否为某个回文串的排列之一。
 * 回文串是指正反两个方向都一样的单词或短语。排列是指字母的重新排列。
 * 回文串不一定是字典当中的单词。
 * <p>
 * 示例1：
 * 输入："tactcoa"
 * 输出：true（排列有"tacocat"、"atcocta"，等等）
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindrome-permutation-lcci
 **/
public class Q4_Can_Permute_Palindrome {
    public boolean canPermutePalindrome(String s) {
        int length = s.length();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < length; i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        int count = 0;
        for (Character character : map.keySet()) {
            if (map.get(character) % 2 != 0) {
                count++;
            }
        }
        return (length % 2 == 0 && count == 0) || (length % 2 != 0 && count == 1);
    }
}
