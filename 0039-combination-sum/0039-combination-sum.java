class Solution {

    void func(int[] candidates, int target, int n, int idx,
              List<Integer> dairy, int sum, List<List<Integer>> res) {

        if (idx == n) {
            if (sum == target) {
                res.add(new ArrayList<>(dairy));
            }
            return;
        }

        // 1. Don't take candidates[idx]
        func(candidates, target, n, idx + 1, dairy, sum, res);

        // 2. Take candidates[idx]
        if (sum + candidates[idx] <= target) {

            dairy.add(candidates[idx]);
            sum += candidates[idx];

            // idx stays same because we can reuse the same number
            func(candidates, target, n, idx, dairy, sum, res);

            // Backtrack
            dairy.remove(dairy.size() - 1);
            sum -= candidates[idx];
        }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> res = new ArrayList<>();
        List<Integer> dairy = new ArrayList<>();

        func(candidates, target, candidates.length, 0, dairy, 0, res);

        return res;
    }
}