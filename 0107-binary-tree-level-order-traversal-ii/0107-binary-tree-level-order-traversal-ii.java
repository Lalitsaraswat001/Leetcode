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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> ans = new LinkedList<>();

        if(root == null){
            return ans;
        }
        queue.offer(root);

        while(!queue.isEmpty()){
            int size = queue.size();

            List<Integer> subList = new LinkedList<>();

            for(int i = 0; i < size; i++){
                TreeNode node = queue.poll();
                subList.add(node.val);

                if(node.left != null){
                    queue.add(node.left);
                }
                if(node.right != null){
                    queue.add(node.right);
                }
            }
            ans.add(subList);
        }
        Collections.reverse(ans);
        return ans;
    }
}