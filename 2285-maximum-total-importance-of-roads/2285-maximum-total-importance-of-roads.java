class Solution {
    public long maximumImportance(int n, int[][] roads) {
        ArrayList<Integer>[] adj=new ArrayList[n];
        for(int i=0;i<n;i++) adj[i]=new ArrayList<Integer>();
        for(int i=0;i<roads.length;i++){
            adj[roads[i][0]].add(roads[i][1]);
            adj[roads[i][1]].add(roads[i][0]);
        }
        int importance[]=new int[n];
        PriorityQueue<Integer> pq=new PriorityQueue<Integer>((a,b)->
            adj[a].size()==adj[b].size()?a-b:adj[a].size()-adj[b].size());
        int imp=1;
        for(int i=0;i<n;i++){
            pq.add(i);
        }
        while(!pq.isEmpty()){
            int node=pq.remove();
            importance[node]=imp;
            imp++;
        }
        long ans=0;
        for(int road[]:roads){
            ans+=importance[road[0]];
            ans+=importance[road[1]];
        }
        return ans;
    }
}