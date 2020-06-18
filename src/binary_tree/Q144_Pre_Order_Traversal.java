package binary_tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * @Author fyz
 * @Date 2020/6/17 18:46
 * 给定一个二叉树，返回它的前序遍历。
 **/
public class Q144_Pre_Order_Traversal {
    public List<Integer> preOrderTraversal(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        helper(root, ret);
        return ret;
    }

    private void helper(TreeNode root, List<Integer> ret) {
        if (root != null) {
            ret.add(root.val);
            if (root.left != null) {
                helper(root.left, ret);
            }
            if (root.right != null) {
                helper(root.right, ret);
            }
        }
    }
}
