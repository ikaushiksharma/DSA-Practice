class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int prevC=0;
        int prevB=-prices[0];
        for(int i=1;i<n;i++){
            int currB=Math.max(-prices[i]+prevC,prevB);
            int currC=Math.max(prices[i]+prevB,prevC);
            prevB=currB;
            prevC=currC;
        }
        return Math.max(prevB,prevC);
    }
}