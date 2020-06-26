package offer;

import binary_tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Q55 {
    public int maxDepth(TreeNode root) {
        int depth = 0;
        if (root == null){
            return depth;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int count = queue.size();
            depth++;
            while (count > 0) {
                count--;
                TreeNode current = queue.remove();
                if (current.left != null) {
                    queue.add(current.left);
                }
                if (current.right != null) {
                    queue.add(current.right);
                }
            }
        }
        return depth;
    }
}
