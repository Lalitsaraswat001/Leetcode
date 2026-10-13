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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> ans = new LinkedList<>();

        if(root == null){
            return ans;
        }
        queue.offer(root);

        boolean leftToRight = true;

        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> subList = new LinkedList<>();

            for(int i = 0; i<size; i++){
                TreeNode node = queue.poll();

                if(leftToRight){
                    subList.add(node.val);
                }
                else{
                    subList.add(0,node.val);
                }

                if(node.left != null){
                    queue.add(node.left);
                }
                if(node.right != null){
                    queue.add(node.right);
                }
            }
            ans.add(subList);
            leftToRight = !leftToRight;
        }
        return ans;
    }
}