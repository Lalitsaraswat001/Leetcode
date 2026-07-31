class Solution {
    public int minimumPushes(String word) {

        // Use this approach because its not have same characters if they have same characters then use 3016 Question approach.

        int ans = 0;

        for (int i = 0; i < word.length(); i++) {
            ans += (i / 8) + 1;
        }
        return ans;
    }
}