package slide_window;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author fyz
 * @Date 2020/6/9 18:09
 * <p>
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
 * 注意：答案中不可以包含重复的三元组。
 * <p>
 * 示例：
 * 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 * 满足要求的三元组集合为：
 * [
 * [-1, 0, 1],
 * [-1, -1, 2]
 * ]
 * <p>
 * 链接：https://leetcode-cn.com/problems/3sum
 **/
public class Q15_Three_Sum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return res;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            // 第一个数大于0，后面的数都大于0
            if (nums[i] > 0) {
                break;
            }
            // 去除重复情况
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    // 找到符合情况的元素继续寻找
                    left++;
                    right--;
                    // 去除重复
                    while (left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }
                    // 去除重复
                    while (left < right && nums[right] == nums[right + 1]) {
                        right--;
                    }
                } else if (sum > 0) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {-2, -1, -1, -1, 3, 3, 3};
        List<List<Integer>> list = new Q15_Three_Sum().threeSum(nums);
        for (List<Integer> integers : list) {
            for (Integer integer : integers) {
                System.out.print(integer + " ");
            }
        }
    }
}
