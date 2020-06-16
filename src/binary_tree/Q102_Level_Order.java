package binary_tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Description
 * @Author fyz
 * @Date 2020/6/16 14:19
 **/
public class Q102_Level_Order {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<List<Integer>> list = new ArrayList<>();
        while (!queue.isEmpty()) {
            queue.poll();
        }
        return null;
    }
}
