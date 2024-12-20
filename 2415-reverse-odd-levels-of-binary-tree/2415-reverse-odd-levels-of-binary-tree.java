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
    public TreeNode reverseOddLevels(TreeNode root) {
        helper(root.left,root.right,1);
        return root;
    }
    private void helper(TreeNode p,TreeNode q,int lvl){
        if(p==null || q==null) return;
        if(lvl%2==1){
            int temp=p.val;
            p.val=q.val;
            q.val=temp;
        }
        helper(p.left,q.right,lvl+1);
        helper(p.right,q.left,lvl+1);
    }
}