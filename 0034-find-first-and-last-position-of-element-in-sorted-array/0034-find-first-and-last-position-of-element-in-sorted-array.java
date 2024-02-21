class Solution {
    public int[] searchRange(int[] nums, int target) {
        int res[]=new int[2];
        res[0]=binarySearch(nums,target,0,nums.length-1,true);
        res[1]=binarySearch(nums,target,0,nums.length-1,false);
        return res;
    }
    private int binarySearch(int arr[],int k,int lo,int hi,boolean isFirst){
        int ans=-1;
        while(lo<=hi){
            int mid=lo+(hi-lo)/2;
            if(arr[mid]==k){
                ans=mid;
                if(!isFirst){
                    lo=mid+1;
                }else{
                    hi=mid-1;
                }
            }else if(arr[mid]>k){
                hi=mid-1;
            }else{
                lo=mid+1;
            }

        }
        return ans;
    }
}