package leetcode.Tree;


import utils.TreeNode;
/**
 * Created by longwei on 8/12/15.
 */
public class MaxPathSum {
    int maxValue = Integer.MIN_VALUE;
    private int maxPathDown(TreeNode root){
        if (root == null) {
            return 0;
        }
        int left = Math.max(0,maxPathDown(root.left));
        int right = Math.max(0,maxPathDown(root.right));
        maxValue = Math.max(maxValue, left + right + root.data);
        return Math.max(left,right) + root.data;
    }

    public int maxPathSum(TreeNode root) {
        maxPathDown(root);
        return maxValue;

    }
    /*
    计算树的最长path有2种情况：
    1. 通过根的path.
    (1)如果左子树从左树根到任何一个Node的path大于零，可以链到root上
    (2)如果右子树从右树根到任何一个Node的path大于零，可以链到root上
    2. 不通过根的path. 这个可以取左子树及右子树的path的最大值。
    */
}
