class Solution {
    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
        int res[][]=new int[k][k];
        List<Integer> topoRow=topo(k,rowConditions);
        List<Integer> topoCol=topo(k,colConditions);
        if(topoRow.size()<k ||topoCol.size()<k) return new int[0][0];
        HashMap<Integer,Integer> m=new HashMap<Integer,Integer>();
        for(int i=0;i<k;i++) m.put(topoCol.get(i),i);
        for(int i=0;i<k;i++){
            res[i][m.get(topoRow.get(i))]=topoRow.get(i);
        }
        return res;
    }
    private List<Integer> topo(int n,int[][] edges){
        int indegree[]=new int[n];
        ArrayList<Integer> adj[]=new ArrayList[n];
        for(int i=0;i<n;i++) adj[i]=new ArrayList<Integer>();
        for(int edge[]:edges){
            adj[edge[0]-1].add(edge[1]-1);
            indegree[edge[1]-1]++;
        }
        Queue<Integer> q=new LinkedList<>();
        for(int i=n-1;i>=0;i--){
            if(indegree[i]==0){
                q.add(i);
            }
        }
        List<Integer> res=new ArrayList<>();
        while(!q.isEmpty()){
            int curr=q.remove();
            res.add(curr+1);
            for(int i:adj[curr]){
                indegree[i]--;
                if(indegree[i]==0) q.add(i);
            }
        }
        return res;
    }
}