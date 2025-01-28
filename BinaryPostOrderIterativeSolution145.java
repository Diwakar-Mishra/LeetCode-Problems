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
    public List<Integer> postorderTraversal(TreeNode root) {
        TreeNode node = root;
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> ans = new ArrayList<>();
        while(node != null || stack.size() > 0){
            if(node == null){
                // left portion has been finished 
                // check the right waala portion 
                TreeNode temp = stack.peek().right;
                if(temp == null){
                    // matlab right waale part mai bhi ab kuch nahi bacha 
                    TreeNode temp2 = stack.pop(); // meri baari aa chuki hai and meraa kaam khatam 
                    ans.add(temp2.val);
                    while(stack.size()>0 && stack.peek().right == temp2){
                        temp2 = stack.pop();
                        ans.add(temp2.val);
                    }
                }else{
                    node = temp;
                }
            }else {
                stack.push(node);
                node = node.left;
            }
        }
        return ans;
    }
}
