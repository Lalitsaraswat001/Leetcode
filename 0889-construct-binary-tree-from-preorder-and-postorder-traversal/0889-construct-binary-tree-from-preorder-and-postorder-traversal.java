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

    HashMap<Integer, Integer> map = new HashMap<>();
    int preIndex;

    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {

        for (int i = 0; i < postorder.length; i++) {
            map.put(postorder[i], i);
        }

        preIndex = 0;

        return build(preorder, postorder, 0, postorder.length - 1);
    }

    public TreeNode build(int[] preorder, int[] postorder, int low, int high){

        if (preIndex >= preorder.length || low > high) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[preIndex]);
        preIndex++;

        if (low == high) {
            return root;
        }

        int next = preorder[preIndex];
        int index = map.get(next);

        root.left = build(preorder, postorder, low, index);
        root.right = build(preorder, postorder, index + 1, high - 1);

        return root;
    }
}