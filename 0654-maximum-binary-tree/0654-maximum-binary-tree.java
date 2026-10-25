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

    TreeNode build(int[] nums, int low, int high){
        if(low>high){
            return null;
        }

        int maxIndex = low;

        for(int i = low+1; i<=high; i++){
            if(nums[i]>nums[maxIndex]){
                maxIndex = i;
            }
        }

        TreeNode root = new TreeNode(nums[maxIndex]);

        root.left = build(nums,low,maxIndex-1);
        root.right = build(nums,maxIndex+1,high);

        return root;
    }
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return build(nums,0,nums.length-1);
    }
}