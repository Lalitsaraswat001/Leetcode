class Solution {

    public long fun(int[] piles, int speed) {
        long hours = 0;

        for (int i = 0; i < piles.length; i++) {
            hours += piles[i] / speed;

            if (piles[i] % speed != 0) {
                hours++;
            }
        }

        return hours;
    }

    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = 0;

        for (int bananas : piles) {
            high = Math.max(high, bananas);
        }

        int res = high;

        while (low <= high) {
            int guess = low + (high - low) / 2;

            long hours = fun(piles, guess);

            if (hours > h) {
                low = guess + 1;
            } else {
                res = guess;
                high = guess - 1;
            }
        }

        return res;
    }
}