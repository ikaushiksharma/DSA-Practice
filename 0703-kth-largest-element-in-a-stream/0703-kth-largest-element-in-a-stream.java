class KthLargest {
    private PriorityQueue<Integer> pq;
    int k=0;
    public KthLargest(int k, int[] nums) {
        pq=new PriorityQueue<>();
        this.k=k;
        for(int i:nums) this.add(i);
    }
    
    public int add(int val) {
        pq.add(val);
        if(pq.size()>k) pq.remove();
        return pq.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */