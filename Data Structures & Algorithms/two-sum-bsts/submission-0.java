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
    public boolean twoSumBSTs(TreeNode root1, TreeNode root2, int target) {
        if(root1 == null){
            return false;
        }
        int diff = target - root1.val;
        if(search(root2,diff)){
            return true;
        }
        return twoSumBSTs(root1.left, root2, target) || twoSumBSTs(root1.right, root2, target);
    }

    public boolean search(TreeNode root2, int target){
        if(root2 == null){
            return false;
        }
        if(root2.val == target){
            return true;
        }
        if(root2.val > target){
            return search(root2.left,target);
        }
        return search(root2.right,target);
    }
}
