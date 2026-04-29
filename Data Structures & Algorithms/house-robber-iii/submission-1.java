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
    Map<TreeNode, Integer> cache = new HashMap<>();
    public int rob(TreeNode root) {
        if(root == null){
            return 0;
        }
        if(cache.get(root) != null){
            return cache.get(root);
        }
        int result = root.val;
        if(root.left != null){
            result += rob(root.left.left) + rob(root.left.right);
        }
        if(root.right != null){
            result += rob(root.right.right) + rob(root.right.left);
        }
        result = Math.max(result,rob(root.left)+rob(root.right));
        cache.put(root,result);
        return result;
    }
}