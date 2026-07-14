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
    int[] result = new int[2];

    public int kthSmallest(TreeNode root, int k) {
        helper(root, k);
        return result[1];
    }

    public void helper(TreeNode root, int k){
        if(root == null){
            return;
        }
        helper(root.left, k);
        result[0]++;
        if(result[0] == k){
            result[1] = root.val;
            return;
        }
        helper(root.right, k);
    }
}
