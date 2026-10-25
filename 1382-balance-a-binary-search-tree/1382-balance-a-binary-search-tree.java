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
    List<Integer> list = new ArrayList<>();

    void inorder(TreeNode root){
        if(root == null){
            return;
        }

        inorder(root.left);
        list.add(root.val);
        inorder(root.right);
    }

    TreeNode build(TreeNode root, int low, int high){
        if(low>high){
            return null;
        }

        int mid = low + (high-low)/2;
        TreeNode node = new TreeNode(list.get(mid));

        node.left = build(root,low,mid-1);
        node.right = build(root,mid+1,high);

        return node;
    }

    public TreeNode balanceBST(TreeNode root) {
        inorder(root);
        return build(root,0,list.size()-1);    
    }
}