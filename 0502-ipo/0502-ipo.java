class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;
        int[][] proj = new int[n][2];

        for (int i = 0; i < n; i++) {
            proj[i][0] = capital[i];
            proj[i][1] = profits[i];
        }

// For sorting in array
        Arrays.sort(proj, (a, b) -> a[0] - b[0]);

// Max Heap
        PriorityQueue<Integer> pq = new PriorityQueue<>(
            (a, b) -> b - a
        );

        int indx = 0;

        while(k-- > 0){
            while(indx<n){
                if(proj[indx][0]>w){
                    break;
                }
                pq.offer(proj[indx][1]);
                indx++;
            }
            if(pq.isEmpty()){
                return w;
            }
            w = w + pq.poll();
        }
        return w;
    }
}