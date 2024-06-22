class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        return atMost(nums,k)-atMost(nums,k-1);
    }
    int atMost(int[] nums,int k){
        int even=0;
        int count=0;
        int left=0;
        for(int right=0;right<nums.length;right++){
            if(nums[right]%2==0)even++;
            while((right-left+1-even)>k){
                if(nums[left]%2==0)even--;
                left++;
            }
            count+=(right-left)+1;
        }
        return count;
    }
}