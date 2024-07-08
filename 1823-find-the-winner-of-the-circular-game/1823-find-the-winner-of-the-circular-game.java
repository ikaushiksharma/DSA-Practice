class Solution {
    public int findTheWinner(int n, int k) {
        Queue<Integer> pool=new LinkedList<>();
        for(int i=0;i<n;i++) {
            pool.offer(i + 1);
        }
        while(pool.size()!=1){
                for (int i = 1; i < k; i++)
                pool.offer(pool.poll());
            pool.poll();
        }
        return pool.poll();
    }
}