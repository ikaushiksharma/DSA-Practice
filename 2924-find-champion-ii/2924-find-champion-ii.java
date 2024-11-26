class Solution {
    public int findChampion(int n, int[][] edges) {
        int[] in = new int[n];
        for (int edge[] : edges) {
            in[edge[1]]++;
        }
        int cnt = 0;
        int res = -1;
        for (int i = 0; i < n; i++) {
            if (in[i] == 0) {
                cnt++;
                res = i;
            }
        }
        return cnt == 1 ? res : -1;
    }
}