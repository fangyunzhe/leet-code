package numbers;

/**
 * @Author fyz
 * @Date 2020/6/8 15:54
 * <p>
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 * 示例 1:
 * 输入: 121
 * 输出: true
 * <p>
 * 示例 2:
 * 输入: -121
 * 输出: false
 * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 * 示例 3:
 * <p>
 * 输入: 10
 * 输出: false
 * 解释: 从右向左读, 为 01 。因此它不是一个回文数。
 * <p>
 * 链接：https://leetcode-cn.com/problems/palindrome-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class Q9_Is_Palindrome {

    /**
     * 将数字反转，比较反转后的数字与原数字是否相等
     * 注意数字不是回文数
     */
    public boolean isPalindrome(int x) {
        int reverse = 0;
        int source = x;
        while (x != 0) {
            reverse = reverse * 10 + x % 10;
            x = x / 10;
        }
        return reverse == source;
    }

    public static void main(String[] args) {
        System.out.println(new Q9_Is_Palindrome().isPalindrome(-121));
    }
}
