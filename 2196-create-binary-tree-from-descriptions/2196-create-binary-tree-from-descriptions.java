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
        public TreeNode createBinaryTree(int[][] descriptions) {
        Set<Integer> kids = new HashSet<>();
        Map<Integer, TreeNode> valToNode = new HashMap<>();
        for (int[] d : descriptions) {
            int parent = d[0], kid = d[1], left = d[2];
            valToNode.putIfAbsent(parent, new TreeNode(parent));
            valToNode.putIfAbsent(kid, new TreeNode(kid));
            kids.add(kid);
            if (left == 1) {
                valToNode.get(parent).left = valToNode.get(kid);
            }else {
                valToNode.get(parent).right = valToNode.get(kid);
            }
        }
        valToNode.keySet().removeAll(kids);
        return valToNode.values().iterator().next();
    }
}