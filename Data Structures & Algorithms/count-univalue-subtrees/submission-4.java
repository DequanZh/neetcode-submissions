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
    public int countUnivalSubtrees(TreeNode root) {
        int[] result = new int[1];
        dfs(root, result);
        return result[0];
    }

    public boolean dfs(TreeNode root, int[] result){
        if(root == null){
            return true;
        }
        boolean left = dfs(root.left, result);
        boolean right = dfs(root.right, result);
        if(left && right){
            if(root.left == null && root.right == null){
                result[0] += 1;
                return true;
            }
            if(root.left != null && root.right != null && root.val == root.left.val && root.right.val == root.left.val){
                result[0] += 1;
                return true;
            }
            if(root.right == null && root.left != null && root.val == root.left.val){
                result[0] += 1;
                return true;
            }
            if(root.left == null && root.right != null && root.val == root.right.val){
                result[0] += 1;
                return true;
            }
            return false;
        }
        return false;
    }
}
