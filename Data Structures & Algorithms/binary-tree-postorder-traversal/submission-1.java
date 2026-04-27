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
        if(root == null){
            return new ArrayList<>();
        }

        ArrayList<Integer> list = new ArrayList<>();
        List<Integer> leftResult = postorderTraversal(root.left);
        list.addAll(leftResult);
        List<Integer> rightResult = postorderTraversal(root.right);
        list.addAll(rightResult);
        list.add(root.val);
        return list;
    }
}