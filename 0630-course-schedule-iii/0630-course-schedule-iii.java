class Solution {
    public int scheduleCourse(int[][] courses) {

        // Sort by deadline
        Arrays.sort(courses, (a, b) -> a[1] - b[1]);

        // Max Heap: stores course durations
        PriorityQueue<Integer> pq = new PriorityQueue<>(
            (a, b) -> b - a
        );

        int time = 0;

        for (int[] course : courses) {

            int duration = course[0];
            int deadline = course[1];

            time += duration;
            pq.offer(duration);

            // If deadline is exceeded,
            // remove the longest course
            if (time > deadline) {
                time -= pq.poll();
            }
        }

        return pq.size();
    }
}