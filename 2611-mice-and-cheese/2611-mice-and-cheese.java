class Solution {
    public int miceAndCheese(int[] reward1, int[] reward2, int k) {
        int n = reward1.length;
        int res = 0;
        for (int i = 0; i < n; i++) {
            res += reward2[i];
            reward1[i] = reward1[i] - reward2[i];
        }
        Arrays.sort(reward1);
        for (int i = n-k; i < n; i++) {
            res += reward1[i];
        }
        return res;
    }
}