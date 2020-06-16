package heap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @Description
 * @Author fyz
 * @Date 2020/6/16 11:40
 * <p>
 * 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
 * <p>
 * 示例 1:
 * 输入: nums = [1,1,1,2,2,3], k = 2
 * 输出: [1,2]
 * <p>
 * 示例 2:
 * 输入: nums = [1], k = 1
 * 输出: [1]
 *  
 * 提示：
 * 你可以假设给定的 k 总是合理的，且 1 ≤ k ≤ 数组中不相同的元素的个数。
 * 你的算法的时间复杂度必须优于 O(n log n) , n 是数组的大小。
 * 题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的。
 * 你可以按任意顺序返回答案。
 * <p>
 * 链接：https://leetcode-cn.com/problems/top-k-frequent-elements
 **/
public class Q347_Top_K_Frequent {

    /**
     * 使用map统计出数组中每个元素出现的次数
     * 维护一个大顶堆，按照元素个数排序（PriorityQueue默认是小顶堆）
     * 将map的key放入大顶堆，此时大顶堆中前k个元素即为结果
     */
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> countMap = new HashMap<>();
        for (int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> (countMap.get(b) - countMap.get(a)));
        maxHeap.addAll(countMap.keySet());
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            list.add(maxHeap.poll());
        }
        int[] ret = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ret[i] = list.get(i);
        }
        return ret;
    }
}
