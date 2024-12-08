class Solution {
    public int maxTwoEvents(int[][] events) {
        // Step 1: Sort events by their start time
        Arrays.sort(events, Comparator.comparingInt(a -> a[0]));
        // Priority Queue to track events by their end time
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        int maxVal = 0, maxSum = 0;

        // Step 2: Process each event
        for (int[] event : events) {
            int startTime = event[0];
            int endTime = event[1];
            int value = event[2];

            // Step 3: Remove all events from the queue that end before the current event starts
            while (!pq.isEmpty() && pq.peek()[0] < startTime) {
                maxVal = Math.max(maxVal, pq.poll()[1]);
            }

            // Step 4: Calculate the maximum sum considering the current event
            maxSum = Math.max(maxSum, value + maxVal);

            // Step 5: Add the current event to the priority queue
            pq.add(new int[]{endTime, value});
        }

        return maxSum;
    }
}