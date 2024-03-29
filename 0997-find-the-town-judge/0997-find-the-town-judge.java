class Solution {
    public int findJudge(int n, int[][] trust) {
        int arr[]=new int[n+1];
        for(int i=0;i<trust.length;i++){
            arr[trust[i][1]]++;
        }
        boolean exists=false;
        int judge=0;
        for(int i=1;i<=n;i++){
            if(arr[i]==n-1){
                exists=true;
                judge=i;
            }
        }
        for(int i=0;i<trust.length;i++){
            if(trust[i][0]==judge) exists=false;
        }
        return exists?judge:-1;

    }
}