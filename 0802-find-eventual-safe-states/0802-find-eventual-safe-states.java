class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int[] outdegree=new int[graph.length];
        List<Integer> res=new LinkedList<>();
        Map<Integer,Set<Integer>> mp=new HashMap<>();
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<graph.length;i++){
            int []edges=graph[i];
            outdegree[i]=edges.length;
            if(outdegree[i]==0) q.offer(i);
            for(int edge:edges){
                if(!mp.containsKey(edge)){
                    mp.put(edge,new HashSet<Integer>());
                }
                mp.get(edge).add(i);
            }
        }
        while(!q.isEmpty()){
            int ele=q.poll();
            if(mp.containsKey(ele)){
                Set<Integer> release=mp.get(ele);
                for(int i:release){
                    outdegree[i]--;
                    if(outdegree[i]==0) q.offer(i);
                }
            }
        }
        for(int i=0;i<outdegree.length;i++){
            if(outdegree[i]==0) 
                res.add(i);    
        }
        return res;
    }
}