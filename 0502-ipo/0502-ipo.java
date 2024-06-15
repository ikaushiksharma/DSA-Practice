class T {
  public int pro;
  public int cap;
  public T(int pro, int cap) {
    this.pro = pro;
    this.cap = cap;
  }
}

class Solution {
    public int findMaximizedCapital(int k, int W, int[] profits, int[] capital) {
        Queue<T> minHeap = new PriorityQueue<>((a, b) -> a.cap - b.cap);
        Queue<T> maxHeap = new PriorityQueue<>((a, b) -> b.pro - a.pro);
        for(int i=0;i<capital.length;++i)
            minHeap.offer(new T(profits[i], capital[i]));
        while (k-- > 0){
            while(!minHeap.isEmpty() && minHeap.peek().cap <= W)
                maxHeap.offer(minHeap.poll());
            if(maxHeap.isEmpty())
                break;
            W+=maxHeap.poll().pro;
        }
    return W;
    }
}