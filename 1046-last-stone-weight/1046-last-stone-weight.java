class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int i = 0; i<stones.length; i++){
            pq.offer(stones[i]);
        }
        
        while (!pq.isEmpty()) {
            int first = pq.poll();
            
            if (pq.isEmpty()) {
                return first;
            }
            
            int second = pq.poll();
            if (first != second) {
                pq.offer(first - second);
            }
        }
        return 0;
    }
}