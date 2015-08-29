package leetcode.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import utils.TreeNode;
/**
 * Created by longwei on 8/28/15.
 * http://www.lintcode.com/en/problem/binary-tree-level-order-traversal/#
 */
public class BFS {
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if (root == null) return result;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            ArrayList<Integer> level = new ArrayList<>();
            int size = q.size();
            for (int i = 0; i < size; i++){
                TreeNode head = q.poll();
                level.add(head.val);
                if (head.left != null) q.add(head.left);
                if (head.right != null) q.add(head.right);
            }
            result.add(level);
        }
        return result;
    }
}
