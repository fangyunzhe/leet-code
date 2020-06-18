package binary_tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Description
 * @Author fyz
 * @Date 2020/6/17 17:25
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 * 本题中，一棵高度平衡二叉树定义为：
 * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/balanced-binary-tree
 **/
public class Q110_Is_Balanced {
    public boolean isBalanced(TreeNode root) {
        if (root == null){
            return true;
        }
        List<Integer> heights = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int height = 0;
        while (!queue.isEmpty()) {
            int count = queue.size();
            height++;
            while (count > 0) {
                TreeNode current = queue.remove();
                if (current.left != null) {
                    queue.add(current.left);
                }
                if (current.right != null) {
                    queue.add(current.right);
                }
                if (current.left == null || current.right == null) {
                    heights.add(height);
                }
                count--;
            }
        }
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (Integer integer : heights) {
            if (integer > max) {
                max = integer;
            }
            if (integer < min) {
                min = integer;
            }
        }
        return max - min < 2;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = null;
        root.right = new TreeNode(2);
        root.right.left = null;
        root.right.right = new TreeNode(3);
        System.out.println(new Q110_Is_Balanced().isBalanced(root));
    }
}
