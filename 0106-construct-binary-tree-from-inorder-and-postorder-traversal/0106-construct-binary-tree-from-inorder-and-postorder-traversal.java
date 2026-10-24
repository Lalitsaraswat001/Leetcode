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
    HashMap<Integer,Integer> f = new HashMap<>();
    int idx;

    TreeNode build(int[] postorder, int low, int high){
        if(low>high){
            return null;
        }

        TreeNode root = new TreeNode(postorder[idx]);
        idx--;

        int id = f.get(root.val);

        root.right = build(postorder, id+1, high);
        root.left = build(postorder, low, id-1);
        
        return root;
    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for(int i = 0; i<inorder.length; i++){
            f.put(inorder[i],i);
        }

        idx = postorder.length - 1;
        return build(postorder, 0, inorder.length-1);
    }
}