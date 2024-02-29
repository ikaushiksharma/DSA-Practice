/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    public boolean isEvenOddTree(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        boolean even = true;
        while (q.size() > 0) {
            int size = q.size();
            int prev = (even) ? 0 : Integer.MAX_VALUE;
            while (size-- > 0) {
                TreeNode rem = q.poll();
                if (even) {
                    if (rem.val % 2 == 0 || rem.val <= prev)
                        return false;
                } else {
                    if (rem.val % 2 != 0 || rem.val >= prev)
                        return false;
                }
                if (rem.left != null)
                    q.add(rem.left);
                if (rem.right != null)
                    q.add(rem.right);
                prev = rem.val;
            }
            even = !even;
        }
        return true;
    }

}