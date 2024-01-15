class Solution {
    public boolean validPath(int n, int[][] edges, int s, int d) {
        ArrayList<Integer>[] adjList = new ArrayList[n];
        for(int i=0;i<n;i++) adjList[i]=new ArrayList<>();
        for(int i=0;i<edges.length;i++){
            int u=edges[i][0];
            int v=edges[i][1];
            adjList[u].add(v);
            adjList[v].add(u);
        }
        boolean visited[]=new boolean[n];
        dfs(s,d,visited,adjList);
        return visited[d];
    }
    private void dfs(int s,int d,boolean[] visited,ArrayList<Integer>[] adjList){
        if(visited[d]==true) return;
        visited[s]=true;         
        for(int i=0;i<adjList[s].size();i++){
            int u=adjList[s].get(i);
                if(!visited[u])
                    dfs(adjList[s].get(i),d,visited,adjList);
        }
    }
}