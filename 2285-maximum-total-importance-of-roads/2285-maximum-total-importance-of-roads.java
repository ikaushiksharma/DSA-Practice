class Solution {
    public long maximumImportance(int n, int[][] road) {
        ArrayList<Integer>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++)
            adj[i] = new ArrayList<Integer>();
        for (int i = 0; i < road.length; i++) {
            adj[road[i][0]].add(road[i][1]);
            adj[road[i][1]].add(road[i][0]);
        }
        int importance[] = new int[n];
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(
                (a, b) -> adj[a].size() == adj[b].size() ? a - b : adj[a].size() - adj[b].size());
        int imp = 1;
        for (int i = 0; i < n; i++) {
            pq.add(i);
        }
        while (!pq.isEmpty()) {
            int node = pq.remove();
            importance[node] = imp;
            imp++;
        }
        long ans = 0;
        for(int i=0;i<n;i++){
            ans+=importance[i]*adj[i].size();
        }
        return ans;
    }
}