package string;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * @Author fyz
 * @Date 2020/6/15 18:54
 * <p>
 * 字符串 S 由小写字母组成。我们要把这个字符串划分为尽可能多的片段，
 * 同一个字母只会出现在其中的一个片段。返回一个表示每个字符串片段的长度的列表。
 * <p>
 * 示例 1：
 * 输入：S = "ababcbacadefegdehijhklij"
 * 输出：[9,7,8]
 * 解释：
 * 划分结果为 "ababcbaca", "defegde", "hijhklij"。
 * 每个字母最多出现在一个片段中。
 * 像 "ababcbacadefegde", "hijhklij" 的划分是错误的，因为划分的片段数较少。
 *  
 * 提示：
 * <p>
 * S的长度在[1, 500]之间。
 * S只包含小写字母 'a' 到 'z' 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/partition-labels
 **/
public class Q763_Partition_Labels {

    public List<Integer> partitionLabels(String S) {
        // 用于存放char最后一次出现的下标
        int[] hash = new int[26];
        for (int i = 0; i < S.length(); i++) {
            hash[S.charAt(i) - 'a'] = i;
        }
        // start,end用于存放当前区间的首尾
        int start = 0;
        int end = 0;
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < S.length(); i++) {
            // 取最大值为了使end确定后保持不变
            end = Math.max(hash[S.charAt(i) - 'a'], end);
            // 遍历到char最后出现到位置，重新开始找下一个区间
            if (end == i) {
                res.add(i - start + 1);
                start = i + 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        List<Integer> list = new Q763_Partition_Labels().partitionLabels("ababcbacadefegdehijhklij");
        for (Integer integer : list) {
            System.out.print(integer + " ");
        }
    }
}
