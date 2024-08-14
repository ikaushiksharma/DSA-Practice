class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int low=0;
        int high=nums[nums.length-1]-nums[0];

        while(low<high){
            int mid=low+(high-low)/2;
            int pair=count(nums,mid);
            if(pair<k){
                low=mid+1;
            }
            else{
                high=mid;
            }
        }   
        return low;
    }
    public int count(int arr[],int mid){
        int cnt=0;
        int left=0;
        for(int right=1;right<arr.length;right++){
            while(arr[right]-arr[left]>mid) left++;
            cnt+=right-left;
        }
        return cnt;
    }
}