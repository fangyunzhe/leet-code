package numbers;

/**
 * @Author fyz
 * @Date 2020/6/8 16:08
 * <p>
 * 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
 * <p>
 * 示例 1:
 * 输入: num1 = "2", num2 = "3"
 * 输出: "6"
 * <p>
 * 示例 2:
 * 输入: num1 = "123", num2 = "456"
 * 输出: "56088"
 * <p>
 * 说明：
 * num1 和 num2 的长度小于110。
 * num1 和 num2 只包含数字 0-9。
 * num1 和 num2 均不以零开头，除非是数字 0 本身。
 * 不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/multiply-strings
 **/
public class Q43_Multiply {
    public String multiply(String num1, String num2) {
        if ("0".equalsIgnoreCase(num1) || "0".equals(num2)) {
            return "0";
        }
        String res;
        long sum = 0;
        int carry = 0;
        for (int i = num1.length(), f = 0; i > 0; i--, f++) {
            for (int j = num2.length(), g = 1; j > 0; j--, g *= 10) {
                int a = num1.charAt(i - 1) - '0';
                int b = num2.charAt(j - 1) - '0';
                int temp = a * b % 10 + carry;
                carry = a * b / 10;
                sum = temp * g * 10 + sum;
            }
        }
        res = String.valueOf(sum);
        if (carry > 0) {
            res = carry + res;
        }
        return res;
    }

    public static void main(String[] args) {
        String num1 = "123";
        String num2 = "456";
        System.out.println(new Q43_Multiply().multiply(num1, num2));
    }
}
