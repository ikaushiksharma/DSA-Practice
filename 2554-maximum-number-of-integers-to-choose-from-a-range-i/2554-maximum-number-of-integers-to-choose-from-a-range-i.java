class Solution {
    public int maxCount(int[] banned, int n, int maxSum) {
        HashSet<Integer> set = new HashSet<>();
        for (int i : banned)
            set.add(i);
        int sum = 0;
        int cnt = 0;
        int i = 1;
        while (sum + i < maxSum && i <= n) {
            if (!set.contains(i)) {
                sum += i;
                cnt++;
            }
            i++;
        }
        return cnt;
    }
}