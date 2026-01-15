class Solution {
    public int maximizeSquareHoleArea(int n, int m, int[] hBars, int[] vBars) {
        int maxSide=Math.min(maxConsective(hBars),maxConsective(vBars));
        return maxSide*maxSide;
    }
    private int maxConsective(int arr[]){
        Arrays.sort(arr);
        int n=arr.length;
        int curr=1;
        int res=1;
        int prev=0;
        for(int i=0;i<n;i++){
            if(arr[i]==prev+1){
                curr++;
            }else{
                curr=1;
            }
            prev=arr[i];
            res=Math.max(res,curr);
        }
        return res+1;
    }
}