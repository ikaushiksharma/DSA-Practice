class Solution {
    public long pickGifts(int[] gifts, int k) {
        long sum=0;
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
        for(int i:gifts) pq.add(i);
        for(int i=0;i<k;i++){
            int val=pq.poll();
            pq.add((int)Math.sqrt(val));
        }
        while(!pq.isEmpty()) sum+=pq.poll();
        return sum;
    }
}