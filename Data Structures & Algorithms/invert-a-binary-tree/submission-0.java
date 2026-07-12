/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    private static void invert(final TreeNode node) {
        if (node == null) {
            return;
        }
        final TreeNode left = node.left;
        final TreeNode right = node.right;
        invert(node.left = right);
        invert(node.right = left);
    }
    public TreeNode invertTree(final TreeNode root) {
        invert(root);
        return root;        
    }
}
