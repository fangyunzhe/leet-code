package slide_window;

/**
 * @Description
 * @Author fyz
 * @Date 2020/6/9 17:49
 * <p>
 * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * 说明：你不能倾斜容器，且 n 的值至少为 2。
 * <p>
 * 示例：
 * 输入：[1,8,6,2,5,4,8,3,7]
 * 输出：49
 * <p>
 * 链接：https://leetcode-cn.com/problems/container-with-most-water
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class Q11_Max_Area {
    /**
     * 两个指针分别从数组的头部和尾部移动
     * 由于容积由较小的高度决定，所以优先移动高度较小的指针
     * 移动过程中记录容积的最大值
     */
    public int maxArea(int[] height) {
        int res = 0;
        int left = 0;
        int right = height.length - 1;
        while (left != right) {
            int leftHeight = height[left];
            int rightHeight = height[right];
            int area = (right - left) * Math.min(rightHeight, leftHeight);
            res = Math.max(area, res);
            if (leftHeight <= rightHeight) {
                left++;
            } else {
                right--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(new Q11_Max_Area().maxArea(height));
    }

}
