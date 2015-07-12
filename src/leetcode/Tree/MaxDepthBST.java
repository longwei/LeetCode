package leetcode.Tree;

import utils.TreeNode;

/**
 * Created by longwei on 7/12/15.
 */
public class MaxDepthBST {
    public int maxDepth(TreeNode node){
        if(node == null) return 0;
        return Math.max(maxDepth(node.left),maxDepth(node.right))+1;
    }
    //for the min depth, the the counting didn't stop on null node,
    // it has continue until it reach leaf nodes
    //       x
    //  null    l1

    public int minDepth(TreeNode root){
        if(root == null) return 0;
        if(root.left == null) return minDepth(root.right)+1;
        if(root.right == null) return minDepth(root.left)+1;
        return Math.min(minDepth(root.left), minDepth(root.right))+1;
    }

    //better solution is BFS
    //TODO
}
