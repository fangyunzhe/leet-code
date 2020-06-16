package binary_tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * @Author fyz
 * @Date 2020/6/16 12:07
 * 给定一个二叉树，返回它的中序遍历。
 **/
public class Q94_In_Order_Traversal {

    /**
     * 递归
     */
    public List<Integer> inOrderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        helper(root, list);
        return list;
    }

    private void helper(TreeNode root, List<Integer> ret) {
        if (root != null) {
            if (root.left != null) {
                helper(root.left, ret);
            }
            ret.add(root.val);
            if (root.right != null) {
                helper(root.right, ret);
            }
        }
    }
}
