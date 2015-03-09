package leetcode.level5;

/**
 * Created by longwei on 1/11/15.
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
//    public static  int last_seen = Integer.MIN_VALUE;
    //this will fail some edge case where {Integer.MIN_VALUE} {Integer.MIN_VALUE, Integer.MIN_VALUE}

    //#1 using a stack to record all print out
    //# using long as upper & lower limit
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


    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isValidBST(TreeNode root, long minVal, long maxVal) {
        if (root == null) return true;
        if (root.val >= maxVal || root.val <= minVal) return false;
        return isValidBST(root.left, minVal, root.val) && isValidBST(root.right, root.val, maxVal);
    }
}
