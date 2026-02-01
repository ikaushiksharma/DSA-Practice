class Solution {
    public int minimumCost(int[] nums) {
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        for(int i=1;i<nums.length;i++) pq.add(nums[i]);
        int res=nums[0];
        res+=pq.poll();
        res+=pq.poll();
        return res;
    }
}