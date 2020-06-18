package binary_tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * @Author fyz
 * @Date 2020/6/18 11:25
 * 给定一个二叉树，返回它的后序遍历。
 **/
public class Q145_Post_Order_Traversal {

    public List<Integer> postOrderTraversal(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        helper(root, ret);
        return ret;
    }

    private void helper(TreeNode root, List<Integer> ret) {
        if (root != null) {
            if (root.left != null) {
                helper(root.left, ret);
            }
            if (root.right != null) {
                helper(root.right, ret);
            }
            ret.add(root.val);
        }

    }
}
