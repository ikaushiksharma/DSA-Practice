class Solution {
    class Pair {
        int val;
        int idx;

        Pair(int v, int i) {
            val = v;
            idx = i;
        }
        public Pair multiply(int multiplier){
            this.val=val*multiplier;
            return this;
        }
        @Override
        public String toString(){
            return this.val+"|"+this.idx;
        }
    }

    public int[] getFinalState(int[] nums, int k, int multiplier) {
        PriorityQueue<Pair> pq = new PriorityQueue<>(
                (Pair a, Pair b) -> a.val == b.val ? a.idx - b.idx : a.val - b.val);
        for (int i = 0; i < nums.length; i++)
            pq.add(new Pair(nums[i], i));
        while (k-- > 0) {
            Pair min=pq.remove();
            min.multiply(multiplier);
            nums[min.idx]=min.val;
            pq.add(min);
        }
        return nums;
    }
}