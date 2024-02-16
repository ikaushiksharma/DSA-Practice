class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int lo=0;
        int hi=(int)(1e9);
        int ans=0;
        while(lo<=hi){
            int mid=((lo+hi)>>1);
            if(isValid(piles,h,mid)){
                ans=mid;
                hi=mid-1;
            }
            else{
                lo=mid+1;
            }
        }
        return ans;
    }
    private boolean isValid(int arr[],int h,int k){
        int cnt=0;
        for(int i=0;i<arr.length;i++){
            cnt+=Math.ceil(arr[i]/((float)k));
        }
        return cnt<=h;
    }
}