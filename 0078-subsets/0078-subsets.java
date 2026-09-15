import java.util.*;

class Solution {

    static void subsets(int[] nums, int indx, List<Integer> tmp, List<List<Integer>> ans) {
        // Base Case
        if (indx == nums.length) {
            ans.add(new ArrayList<>(tmp));
            return;
        }
        // No
        subsets(nums, indx + 1, tmp, ans);
        // Yes
        tmp.add(nums[indx]);
        subsets(nums, indx + 1, tmp, ans);
        tmp.remove(tmp.size() - 1);
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> tmp = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();

        // For starting with indx 1...
        subsets(nums, 0, tmp, ans);

        return ans;
    }
}