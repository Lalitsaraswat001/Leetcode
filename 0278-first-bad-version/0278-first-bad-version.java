/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {

        int low = 1, high = n;
        int res = 0;

        while (low <= high) {
            int guess = low + (high - low) / 2;

            if (!isBadVersion(guess)) {
                low = guess + 1;
            } else {
                res = guess;
                high = guess - 1;
            }
        }

        return res;
    }
}