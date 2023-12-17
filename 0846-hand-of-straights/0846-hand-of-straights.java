class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if(hand.length%groupSize!=0) return false;
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        for(int i:hand) pq.add(i);
        while(!pq.isEmpty()){
            int head=pq.poll();
            for(int i=1;i<groupSize;i++){
                if(!pq.remove(head+i)) return false;
            }
        }
        return true;
    }
}