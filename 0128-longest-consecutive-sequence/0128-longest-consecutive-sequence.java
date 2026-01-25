class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        for (int n:nums) numSet.add(n);

        int best = 0;
        for (int num:numSet){
            if(!numSet.contains(num-1)){
                int nextNum = num+1;
                while (numSet.contains(nextNum)){
                    nextNum++;
                }
                best = Math.max(best,nextNum-num);
            }
        }
        return best;
    }
}