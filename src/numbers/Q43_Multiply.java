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
        if ("0".equals(num1) || "0".equals(num2)) {
            return "0";
        }
        String res = "0";
        // num2的每一位与num1相乘，结果相加
        //     1 2 3
        //     4 5 6
        //----------
        //     7 3 8
        //   6 1 5 0
        // 4 9 2 0 0
        //----------
        // 5 6 0 8 8
        for (int i = num2.length() - 1; i >= 0; i--) {
            int carry = 0;
            StringBuilder temp = new StringBuilder();
            // 末尾补0
            for (int j = 0; j < num2.length() - 1 - i; j++) {
                temp.append("0");
            }
            int n2 = num2.charAt(i) - '0';
            for (int j = num1.length() - 1; j >= 0; j--) {
                int n1 = num1.charAt(j)-'0';
                int product = (n1 * n2 + carry) % 10;
                temp.append(product);
                carry = (n1 * n2 + carry) / 10;
            }
            if (carry>0){
                temp.append(carry);
            }
            res = addString(res, temp.reverse().toString());
        }
        return res;
    }

    private String addString(String num1, String num2) {
        StringBuilder res = new StringBuilder();
        int abs = Math.abs(num1.length() - num2.length());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < abs; i++) {
            sb.append("0");
        }
        if (num1.length() < num2.length()) {
            num1 = sb.append(num1).toString();
        } else {
            num2 = sb.append(num2).toString();
        }
        int carry = 0;
        for (int i = num2.length() - 1; i >= 0; i--) {
            int n1 = num1.charAt(i) - '0';
            int n2 = num2.charAt(i) - '0';
            int temp = n1 + n2 + carry;
            res.append(temp % 10);
            carry = temp / 10;
        }
        if (carry == 1) {
            res.append("1");
        }
        return res.reverse().toString();
    }

    public static void main(String[] args) {
        String num1 = "9";
        String num2 = "9";
        System.out.println(new Q43_Multiply().multiply(num1, num2));
    }
}
