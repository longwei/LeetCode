package leetcode.Tree;

import utils.TreeNode;

/**
 * Created by longwei on 7/12/15.
 */
public class BalancedBST {

    //-1 as false;
    public boolean isBalanced(TreeNode root) {
        return maxDepth(root) != -1;
    }
    private int maxDepth(TreeNode root) {
        if (root == null) return 0;
        int l = maxDepth(root.left);
        if (l == -1) return -1;
        int r = maxDepth(root.right);
        if (r == -1) return -1;
        return (Math.abs(l - r) <= 1) ? (Math.max(l, r) + 1) : -1;
    }
}
