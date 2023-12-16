class Solution {
    public int repeatedNTimes(int[] nums) {
        Set<Integer> set=new HashSet<>();
        for(int i: nums)
            set.add(i);
        for(int n:nums)
            {if(set.contains(n))
                set.remove(n);
            else
                return n;}
        return -1;

    }
}