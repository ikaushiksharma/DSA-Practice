class Solution {
    public int majorityElement(int[] nums) {
        int count=0;
        Integer res=null;
        for(int i:nums)
        {
            if(count==0)
                res=i;
            count+=(res==i)?1:-1;
        }
        return res;
    }
}