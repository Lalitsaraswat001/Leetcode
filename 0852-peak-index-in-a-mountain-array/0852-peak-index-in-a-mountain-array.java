class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int low = 0;
        int high = arr.length - 1;

        while (low < high) {
            int guess = low + (high - low) / 2;

            if (arr[guess] < arr[guess + 1]) {
                low = guess + 1;
            } else {
                high = guess;
            }
        }
        
        return low; // Can return both either high or low because when we do high = guesss in such conditions at the end low and high will be at the same position.
    }
}