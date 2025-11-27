class Solution {
    final String PREV="../";
    final String SAME="./";
    public int minOperations(String[] logs) {
        int level=0;
        for(int i=0;i<logs.length;i++){
            String curr=logs[i];
            if(curr.equals(SAME)) continue;
            if(curr.equals(PREV)) level=Math.max(0,level-1);
            else level++;
        }
        return level;
    }
}