class Solution {
    public int findCenter(int[][] edges) {
        boolean isCenter[]=new boolean[edges.length*2];
        for(int i=0;i<edges.length;i++){
            if(isCenter[edges[i][0]]==true) return edges[i][0];
            else if(isCenter[edges[i][1]]==true) return edges[i][1];
            isCenter[edges[i][0]]=true;
            isCenter[edges[i][1]]=true;
        }
        return -1;
    }
}