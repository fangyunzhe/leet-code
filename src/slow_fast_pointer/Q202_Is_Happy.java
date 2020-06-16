package slow_fast_pointer;

import java.util.HashSet;
import java.util.Set;

/**
 * 编写一个算法来判断一个数 n 是不是快乐数。
 * 「快乐数」定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。如果 可以变为  1，那么这个数就是快乐数。
 * 如果 n 是快乐数就返回 True ；不是，则返回 False 。
 * <p>
 * 示例：
 * <p>
 * 输入：19
 * 输出：true
 * 解释：
 * 12 + 92 = 82
 * 82 + 22 = 68
 * 62 + 82 = 100
 * 12 + 02 + 02 = 1
 * <p>
 * 链接：https://leetcode-cn.com/problems/happy-number
 */
public class Q202_Is_Happy {

    /**
     * 由于可能出现死循环，所以将计算结果放入set中来检测死循环
     */
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        set.add(n);
        while (n != 1) {
            int sum = 0;
            String s = String.valueOf(n);
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                int num = Integer.parseInt(Character.toString(c));
                sum = num * num + sum;
            }
            if (set.contains(sum)) {
                return false;
            } else {
                set.add(sum);
                n = sum;
            }
        }
        return true;
    }
}
