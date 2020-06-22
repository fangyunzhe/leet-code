package in_action.interview;

/**
 * @Description
 * @Author fyz
 * @Date 2020/6/22 10:12
 * <p>
 * 给定两个字符串 s1 和 s2，请编写一个程序，确定其中一个字符串的字符重新排列后，能否变成另一个字符串。
 * <p>
 * 示例 1：
 * 输入: s1 = "abc", s2 = "bca"
 * 输出: true
 * <p>
 * 示例 2：
 * 输入: s1 = "abc", s2 = "bad"
 * 输出: false
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/check-permutation-lcci
 **/
public class Q2_Check_Permutation {
    public boolean CheckPermutation(String s1, String s2) {
        char[] chars1 = new char[128];
        char[] chars2 = new char[128];
        for (int i = 0; i < s1.length(); i++) {
            chars1[s1.charAt(i) - ' ']++;
        }
        for (int i = 0; i < s2.length(); i++) {
            chars2[s2.charAt(i) - ' ']++;
        }
        for (int i = 0; i < chars1.length; i++) {
            if (chars1[i] != chars2[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Q2_Check_Permutation().CheckPermutation("a", "ab"));
    }
}
