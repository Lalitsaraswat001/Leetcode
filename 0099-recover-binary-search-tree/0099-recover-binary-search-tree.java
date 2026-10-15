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
    TreeNode prev = null;
    TreeNode g1first = null;
    TreeNode g1second = null;
    TreeNode g2first = null;
    TreeNode g2second = null;
    int galat = 0;

    void fun(TreeNode root){
        if(root == null){
            return;
        }

        fun(root.left);

        if(prev != null && root.val < prev.val){
            if(galat == 0){
                g1first = prev;
                g1second = root;
            }
            else{
                g2first = prev;
                g2second = root;
            }
            galat++;
        }
            prev = root;

            fun(root.right);
        }
        
    public void recoverTree(TreeNode root) {

        fun(root);
        
        int temp;
        
        if(galat == 1){
            temp = g1first.val;
            g1first.val = g1second.val;
            g1second.val = temp;
        }
        else{
            temp = g1first.val;
            g1first.val = g2second.val;
            g2second.val = temp;
        }
    }
}