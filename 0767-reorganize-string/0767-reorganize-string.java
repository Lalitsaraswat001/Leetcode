class Solution {
    public String reorganizeString(String s) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(b[1], a[1])
        );

        int[] freq = new int[26];

        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if (freq[i] > 0) {
                pq.offer(new int[]{i, freq[i]});
            }
        }

        StringBuilder res = new StringBuilder();

        while (!pq.isEmpty()) {
            int[] p = pq.poll();

            if (res.length() == 0 || res.charAt(res.length() - 1) != (char) (p[0] + 'a')) {
                res.append((char) (p[0] + 'a'));
                p[1]--;

                if (p[1] > 0) {
                    pq.offer(p);
                }
            } else {
                if (pq.isEmpty()) {
                    return "";
                }

                int[] p2 = pq.poll();

                res.append((char) (p2[0] + 'a'));
                p2[1]--;

                if (p2[1] > 0) {
                    pq.offer(p2);
                }

                pq.offer(p);
            }
        }

        return res.toString();
    }
}