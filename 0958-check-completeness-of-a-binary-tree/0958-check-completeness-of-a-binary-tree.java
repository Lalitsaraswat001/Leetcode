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
    public boolean isCompleteTree(TreeNode root) {
       Queue<TreeNode> queue = new LinkedList<>();

       boolean nullSeen = false;

       if(root == null){
        return true;
       } 
       queue.offer(root);

       while(!queue.isEmpty()){
        TreeNode node = queue.poll();

        if(node == null){
            nullSeen = true;
        }
        else{
            if(nullSeen){
                return false;
            }
            queue.offer(node.left);
            queue.offer(node.right);
        }
       }
       return true;
    }
}