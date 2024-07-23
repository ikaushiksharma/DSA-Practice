class Solution {
    public int[] frequencySort(int[] nums) {
        HashMap<Integer, Integer> mp = new HashMap<>();
        for (int i : nums) {
            mp.put(i, mp.getOrDefault(i, 0) + 1);
        }
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[1] == b[1] ? b[0] - a[0] : a[1] - b[1]);
        for (Map.Entry<Integer, Integer> entry : mp.entrySet()) {
            minHeap.add(new int[] { entry.getKey(), entry.getValue() });
        }
        int index = 0;
        while (!minHeap.isEmpty()) {
            int[] min = minHeap.poll();
            while (index < nums.length && min[1] > 0) {
                nums[index++] = min[0];
                min[1]--;
            }
        }
        return nums;
    }
}