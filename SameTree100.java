class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        return isIdentical(p,q);
    }
    public boolean isIdentical(TreeNode root1, TreeNode root2 ){
        if(root1 == null && root2 == null) return true;
        else if(root1 == null || root2 == null) return false;
        else if(root1.val != root2.val) return false;
        else if(isIdentical(root1.left,root2.left)&&isIdentical(root1.right,root2.right)) return true;
        else return false;
    }
}
