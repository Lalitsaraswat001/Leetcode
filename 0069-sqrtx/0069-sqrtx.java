// Find the largest integer n such that n × n <= x.

class Solution {
    public int mySqrt(int x) {

        if (x < 2) {
            return x;
        }

        int left = 1;
        int right = x / 2;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (mid <= x / mid) {            // mid * mid <= x
                left = mid + 1;
            } 
            else {
                right = mid - 1;
            }
        }

        return right;
    }
}

/*
When you get a problem, ask yourself these 3 questions:

Question 1: Am I searching for something?

Question 2: Is there a range of possible answers?

Question 3: If I test one value, can I determine whether I should go left or right?
*/