package offer;

import java.util.HashMap;
import java.util.Map;

public class Q57 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            int a = target - num;
            if (map.containsKey(a)) {
                return new int[]{map.get(num), num};
            }
            map.put(num, a);

        }
        return null;
    }
}
