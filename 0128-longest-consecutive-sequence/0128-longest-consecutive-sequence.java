class Solution {
    public int longestConsecutive(int[] nums) {
        int ans=0;
        HashSet<Integer> set=new HashSet<>();
        for(int i:nums) set.add(i);
        int i=0;
        int n=nums.length;
        for (int num: nums) {
            if (!set.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;

                while (set.contains(currentNum + 1)) {
                    currentNum += 1;
                    currentStreak += 1;
                }

                ans = Math.max(ans, currentStreak);
            }
        }

        return ans;
    }
}