package leetcode.Tree;
import utils.TreeNode;
/**
 * Created by longwei on 8/4/15.
 */
public class LowestCommonAncestor {

    /**
     * @param root: The root of the binary search tree.
     * @param A and B: two nodes in a Binary.
     * @return: Return the least common ancestor(LCA) of the two nodes.
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode A, TreeNode B) {
        if (root == null || root == A || root == B) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, A, B);
        TreeNode right = lowestCommonAncestor(root.right, A, B);
        if (left != null && right != null) return root; //found.
        if (left != null) return left;
        if (right != null) return right;
        return null;
    }
}
