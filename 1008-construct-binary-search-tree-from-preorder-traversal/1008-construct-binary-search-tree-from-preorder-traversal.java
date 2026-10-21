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
    int idx = 0;

    private TreeNode fun(int[] preorder, long low, long high){
        if(idx == preorder.length){
            return null;
        }

        int val = preorder[idx];

        if(val <= low || val >= high){
            return null;
        }

        TreeNode root = new TreeNode(val);
        idx++;

        root.left = fun(preorder,low,val);
        root.right = fun(preorder,val,high);

        return root;
    }

    public TreeNode bstFromPreorder(int[] preorder) {
        return fun(preorder, Long.MIN_VALUE, Long.MAX_VALUE);
    }
}