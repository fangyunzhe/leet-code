package slide_window;

/**
 * 给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的连续子数组，并返回其长度。如果不存在符合条件的连续子数组，返回 0。
 * <p>
 * 示例: 
 * <p>
 * 输入: s = 7, nums = [2,3,1,2,4,3]
 * 输出: 2
 * 解释: 子数组 [4,3] 是该条件下的长度最小的连续子数组。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-size-subarray-sum
 */
public class Q209_Min_Sub_Array_Len {

    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int start = 0;
        int end = 0;
        int sum = 0;
        int res = nums.length + 1;
        while (end < nums.length) {
            sum += nums[end];
            while (sum >= s) {
                sum -= nums[start];
                res = Math.min(res, end - start + 1);
                start++;
            }
            end++;
        }
        return res == nums.length + 1 ? 0 : res;
    }
}
