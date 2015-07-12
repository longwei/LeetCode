package leetcode.Tree;

/**
 * Created by longwei on 7/11/15.
 * BST: for all the node, the left children are less than current one, which is less than all right nodes
 * DFS, print out the tree to see if it is sorted
 */

import java.util.Stack;
public class ValidateBST {
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x;}
    }
    //In-order traversal, just checking strict increasing order
    //public static  int last_seen = Integer.MIN_VALUE;
    //but the edge case is the node contains {Integer.MIN_VALUE} {Integer.MIN_VALUE, Integer.MIN_VALUE}
    //#1 using a stack to record all print out
    //#2 using Integer, and use null for left most and right most
    //#2 using long
   public Stack<Integer> last_seen;

    public boolean isValidBST1(TreeNode root) {
        if(root == null) return true;
        if(!isValidBST(root.left)) {return false;}
        if(last_seen.isEmpty()){
            last_seen.push(root.val);
        } else {
            if(root.val <= last_seen.peek()) return false;
        }
        last_seen.push(root.val);
        if(!isValidBST(root.right)) {return false;}
        return true;
    }

    //another solution is smarter that passing the left and right limits for children nodes
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isValidBST(TreeNode root, long minVal, long maxVal) {
        if (root == null) return true;
        if (root.val >= maxVal || root.val <= minVal) return false;
        return isValidBST(root.left, minVal, root.val) && isValidBST(root.right, root.val, maxVal);
    }

    //lame version to get over edge case
    public boolean isValidBST2(TreeNode root) {
        return valid(root, null, null);
    }
    private boolean valid(TreeNode p, Integer low, Integer high) {
        if (p == null) return true;
        return (low == null || p.val > low) && (high == null || p.val < high)
                && valid(p.left, low, p.val)
                && valid(p.right, p.val, high);
    }

}
