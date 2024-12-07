class Solution {
    public int minimumSize(int[] nums, int maxOperations) {
        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->b-a);
        for(int i:nums){
            pq.add(i);
        }
        while(maxOperations-- >=0){
            int ele=pq.poll();
            int first=ele/2;
            int second=ele-first;
            pq.add(first);
            pq.add(second);
        }
        return pq.poll();
    }
}