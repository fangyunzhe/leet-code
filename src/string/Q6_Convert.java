package string;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * @Author fyz
 * @Date 2020/6/15 17:48
 * <p>
 * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
 * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
 * L   C   I   R
 * E T O E S I I G
 * E   D   H   N
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
 * 请你实现这个将字符串进行指定行数变换的函数：
 * string convert(string s, int numRows);
 * <p>
 * 示例 1:
 * 输入: s = "LEETCODEISHIRING", numRows = 3
 * 输出: "LCIRETOESIIGEDHN"
 * <p>
 * 示例 2:
 * 输入: s = "LEETCODEISHIRING", numRows = 4
 * 输出: "LDREOEIIECIHNTSG"
 * 解释:
 * L     D     R
 * E   O E   I I
 * E C   I H   N
 * T     S     G
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zigzag-conversion
 **/
public class Q6_Convert {

    /**
     * 第 0 行和第 numRows-1 行需要变换方向
     */
    public String convert(String s, int numRows) {
        if (numRows == 1){
            return s;
        }
        List<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            rows.add(new StringBuilder());
        }
        int currentRow = 0;
        boolean changeDirect = true;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            rows.get(currentRow).append(c);
            if (currentRow == 0 || currentRow == numRows - 1) {
                changeDirect = !changeDirect;
            }
            currentRow = currentRow + (changeDirect ? -1 : 1);
        }
        StringBuilder ret = new StringBuilder();
        for (StringBuilder row : rows) {
            ret.append(row);
        }
        return ret.toString();
    }

    public static void main(String[] args) {
        String s = "PAYPALISHIRING";
        System.out.println(new Q6_Convert().convert(s, 3));
    }
}
