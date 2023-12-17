class Solution {
    public int maximumGap(int[] nums) {
        int max=0,supermax=0;
        Arrays.sort(nums);
        if(nums.length==2)
        return (nums[1]-nums[0]);
        else
        for(int i=1;i<nums.length;i++)
        {
            max=nums[i]-nums[i-1];
            supermax=Math.max(max,supermax);
        }
       if(nums.length==1||supermax==0)
        return 0;
     return supermax;   
    }
}