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
    private static void traverse(final TreeNode node, final int depth, final List<List<Integer>> levels) {
        if (node == null) {
            return;
        }
        final List<Integer> current;
        if (depth == levels.size()) {
            current = new ArrayList<>();
            levels.add(current);
        } else {
            current = levels.get(depth);
        }
        current.add(node.val);
        traverse(node.left, depth + 1, levels);
        traverse(node.right, depth + 1, levels);
    }
    
    public List<List<Integer>> levelOrder(final TreeNode root) {
        final List<List<Integer>> levels = new ArrayList<>();
        traverse(root, 0, levels);
        return levels;
    }
}
