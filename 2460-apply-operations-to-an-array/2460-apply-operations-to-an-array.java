
class Solution {
    public int[] applyOperations(int[] nums) {
        int[] res = new int[nums.length];

        for(int i = 0; i<nums.length; i++){
            res[i] = nums[i];
        }

        for(int i = 0; i<nums.length-1; i++){
            if(res[i] == res[i+1]){
                res[i] = res[i]*2;
                res[i+1] = 0;
            }
        }

        int j = 0;

        for(int i = 0; i<res.length; i++){
            if(res[i] != 0){
                int tmp = res[i];
                res[i] = res[j];
                res[j] = tmp;
                j++;
            }
        }
        return res;
    }
}