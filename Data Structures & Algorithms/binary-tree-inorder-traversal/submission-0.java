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
    public List<Integer> inorderTraversal(TreeNode root) {
        if(root == null){
            return new ArrayList<>();
        }

        ArrayList<Integer> list = new ArrayList()<>;
        List<Integer> leftResult = inorderTraversal(root.left);
        list.addAll(leftResult);
        list.add(root.val);
        List<Integer> rightResult = inorderTraversal(root.right);
        list.addAll(rightResult);

        return list;
    }
}