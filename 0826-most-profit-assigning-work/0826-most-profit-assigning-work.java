class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int res = 0, j = 0, best = 0;
        List<Pair<Integer, Integer>> temp = new ArrayList<>();
        
        for (int i = 0; i < worker.length; ++i) {
            temp.add(new Pair<>(difficulty[i], profit[i]));
        }

        // 2,4,6,8,10
        //10,20,30,40,50
        //4,5,6,7

        temp.sort((a,b)->a.getKey()-b.getKey());
        Arrays.sort(worker);
        for(int work:worker){
            while(j<temp.size() && work>=temp.get(j).getKey() && best<=temp.get(j).getValue()){
                best=temp.get(j).getValue();
                j++;
            }
            res+=best;
        }
        return res;
    }
}