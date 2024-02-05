class Solution {
    public long interchangeableRectangles(int[][] rectangles) {
        HashMap<Double,Long> mp=new HashMap<>();
        for(int i=0;i<rectangles.length;i++){
            double ratio=rectangles[i][1]/(1.0 * rectangles[i][0]);
            mp.put(ratio,mp.getOrDefault(ratio,(long)0)+1);
        }
        long res=0;
        for(long i:mp.values()){
            res+=(i*(i-1))/2;
        }
        return res;
    }
}