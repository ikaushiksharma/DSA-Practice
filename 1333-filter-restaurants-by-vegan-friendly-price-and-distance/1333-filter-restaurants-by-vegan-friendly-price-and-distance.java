class Solution {
    public List<Integer> filterRestaurants(int[][] restaurants, int veganFriendly, int maxPrice, int maxDistance) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (a, b) -> a[1] == b[1] ? b[0] - a[0] : b[1] - a[1]);
        for (int[] r : restaurants) {
            if (veganFriendly == 1 && r[2] != 1) {
                continue;
            }
            if (r[3] <= maxPrice && r[4] <= maxDistance) {
                pq.offer(new int[] { r[0], r[1] });
            }
        }

        List<Integer> ans = new ArrayList<>();
        while (!pq.isEmpty()) {
            ans.add(pq.poll()[0]);
        }

        return ans;
    }
}