class Solution {
    public int[] replaceElements(int[] arr) {
        int n=arr.length;
        int res[]=new int[n];
        res[n-1]=-1;
        int maxSoFar=arr[n-1];
        for(int i=n-2;i>=0;i--){
            res[i]=maxSoFar;
            maxSoFar=Math.max(maxSoFar,arr[i]);
        }
        return res;
    }
}