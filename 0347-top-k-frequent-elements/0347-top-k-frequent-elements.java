import java.util.*;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        HashMap<Integer, Integer> f = new HashMap<>();

        for (int num : nums) {
            f.put(num, f.getOrDefault(num, 0) + 1);
        }

        // min heap
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> a[1] - b[1]
        );

        for (Map.Entry<Integer, Integer> entry : f.entrySet()) {

            int element = entry.getKey();
            int freq = entry.getValue();

            pq.offer(new int[]{element, freq});

            if (pq.size() > k) {
                pq.poll();
            }
        }

        int[] res = new int[k];

        for (int i = 0; i < k; i++) {
            res[i] = pq.poll()[0];
        }

        return res;
    }
}