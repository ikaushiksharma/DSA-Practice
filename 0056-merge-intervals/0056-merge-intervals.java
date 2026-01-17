class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        List<int[]> a=new ArrayList<>();
        for(int[] interval:intervals){
            if(a.isEmpty() || a.get(a.size()-1)[1]<interval[0])
                a.add(interval);
                else
                a.get(a.size()-1)[1]=Math.max(interval[1],a.get(a.size()-1)[1]);
        }
        return a.toArray(new int[a.size()][]);
    }
}