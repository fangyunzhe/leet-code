package numbers;

/**
 * @Description
 * @Author fyz
 * @Date 2020/6/8 15:33
 * <p>
 * 请你来实现一个 atoi 函数，使其能将字符串转换成整数。
 * 首先，该函数会根据需要丢弃无用的开头空格字符，直到寻找到第一个非空格的字符为止。接下来的转化规则如下：
 * 如果第一个非空字符为正或者负号时，则将该符号与之后面尽可能多的连续数字字符组合起来，形成一个有符号整数。
 * 假如第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成一个整数。
 * 该字符串在有效的整数部分之后也可能会存在多余的字符，那么这些字符可以被忽略，它们对函数不应该造成影响。
 * 注意：假如该字符串中的第一个非空格字符不是一个有效整数字符、字符串为空或字符串仅包含空白字符时，则你的函数不需要进行转换，即无法进行有效转换。
 * 在任何情况下，若函数不能进行有效的转换时，请返回 0 。
 * <p>
 * 提示：
 * 本题中的空白字符只包括空格字符 ' ' 。
 * 假设我们的环境只能存储 32 位大小的有符号整数，那么其数值范围为 [−231,  231 − 1]。如果数值超过这个范围，请返回  INT_MAX (231 − 1) 或 INT_MIN (−231) 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/string-to-integer-atoi
 **/
public class Q8_My_Atoi {
    public int myAtoi(String str) {
        // 去除空格
        str = str.trim();
        if (str.length() == 0) {
            return 0;
        }
        boolean negative = false;
        // 以符号开头，进行截取
        if (str.charAt(0) == '-') {
            negative = true;
            str = str.substring(1);
        } else if (str.charAt(0) == '+') {
            str = str.substring(1);
        }
        int res = 0;
        // 开始循环字符并计算结果
        // 遇到第一个不是数字的字符终止循环
        for (int i = 0; i < str.length(); i++) {
            char t = str.charAt(i);
            if (Character.isDigit(t)) {
                // 结算结果
                int temp = res * 10 + (t - '0');
                // 如果越界则根据符号返回最小值或最大值
                if ((temp - (t - '0')) / 10 != res || temp < 0) {
                    return negative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
                }
                res = temp;
            } else {
                break;
            }
        }
        return negative ? -res : res;

    }

    public static void main(String[] args) {
        System.out.println(new Q8_My_Atoi().myAtoi("4193 with words"));
    }
}
