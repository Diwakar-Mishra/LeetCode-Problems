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
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        return isSymmetric(root.left,root.right);
    }
    public boolean isSymmetric(TreeNode left, TreeNode right){
        if(left == null && right == null) return true;
        else if(left == null || right == null) return false;
        else if(left.val != right.val) return false;
        else if(isSymmetric(left.right,right.left) && isSymmetric(left.left,right.right)) return true;
        else return false; 
    }
}
