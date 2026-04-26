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
    public List<Integer> preorderTraversal(TreeNode root) {
        if(root == null){
            return new ArrayList<>();
        }

        ArrayList<Integer> list = new ArrayList<>();
        list.add(root.val);

        List<Integer> leftResult = preorderTraversal(root.left);
        List<Integer> rightResult = preorderTraversal(root.right);
        list.addAll(leftResult);
        list.addAll(rightResult);

        return list;
    }
}