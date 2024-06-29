class Solution {
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        List<List<Integer>> ans = new ArrayList<>();
        List<List<Integer>> adj = new ArrayList<>();
        List<TreeSet<Integer>> ancestorList = new ArrayList();

        for(int i = 0; i < n; i++){
            ancestorList.add(new TreeSet<>());
            adj.add(new ArrayList<>());
        }
        int[] indegree = new int[n];
        for(int i = 0; i < edges.length;i++){
            int u = edges[i][0];
            int v = edges[i][1];
            indegree[v]++;
            adj.get(u).add(v);
        }
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<n;i++){
            if(indegree[i]==0) q.add(i);
        }
        while(!q.isEmpty()){
            int curr=q.poll();
            for(int node:adj.get(curr)){
                ancestorList.get(node).addAll(new TreeSet<>(ancestorList.get(curr)));
                ancestorList.get(node).add(curr);
                indegree[node]--;
                if(indegree[node]==0) q.add(node);
            }
        }
        for(TreeSet<Integer> set : ancestorList){
            ans.add(new ArrayList<Integer>(set));
        }

        return ans;
    }
}