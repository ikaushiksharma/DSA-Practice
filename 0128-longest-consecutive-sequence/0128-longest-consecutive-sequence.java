class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set=new HashSet<>();
        int maxLen=0;
        for(int i:nums) set.add(i);
        for(int i:nums){
            if(!set.contains(i-1)){
                int num=i;
                int cnt=1;
                while(set.contains(num+1)){
                    cnt++;
                    num++;
                }
                maxLen=Math.max(maxLen,cnt);
            }
        }
        return maxLen;
    }
}