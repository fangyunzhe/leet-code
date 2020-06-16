package heap;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @Description
 * @Author fyz
 * @Date 2020/6/16 10:46
 * <p>
 * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 * 示例 1:
 * 输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 * <p>
 * 示例 2:
 * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
 * 输出: 4
 * <p>
 * 说明:
 * 你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/kth-largest-element-in-an-array
 **/
public class Q215_Find_Kth_Largest {

    /**
     * 维护一个小顶堆
     * 将数组中的元素放入堆中，并且保持堆中元素个数不大于k
     * 最后堆顶堆元素就是第k大元素
     */
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int num : nums) {
            minHeap.add(num);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        return minHeap.poll();
    }

    /**
     * 维护一个大顶堆，将数组中堆元素都放入堆中
     * 进行k次poll操作
     */
    public int findKthLargest2(int[] nums, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> (b - a));
        for (int num : nums) {
            maxHeap.add(num);
        }
        for (int i = 1; i < k; i++) {
            maxHeap.poll();
        }
        return maxHeap.poll();
    }

    public static void main(String[] args) {
        int[] nums = {6, 3, 4, 6, 7, 8, 9, 2};
        new Q215_Find_Kth_Largest().findKthLargest(nums, 2);
    }
}
