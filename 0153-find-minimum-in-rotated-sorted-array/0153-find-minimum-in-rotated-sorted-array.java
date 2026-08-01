class Solution {
    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length - 1;

        // Becomes First occurrence question
        while(low<high){
            int guess = low + (high-low)/2;

            if(nums[guess]>nums[high]){
                low = guess + 1;
            }
            else{
                high = guess;  // also use res to store , high = guess - 1;
            }
        }
        return nums[high];
    }
}