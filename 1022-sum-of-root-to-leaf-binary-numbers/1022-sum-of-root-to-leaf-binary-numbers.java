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
    int sum=0;
    public int sumRootToLeaf(TreeNode root) {
        helper(root,"");
        return sum;
    }
    public void helper(TreeNode root,String out){
        if(root==null){
            return;
        }
        if(root.val==1) out+='1';
        else out+='0';
        if(root.left==null && root.right==null){
            sum+=Integer.parseInt(out,2);
            return;

        }
        helper(root.left,out);
        helper(root.right,out);
    }
}