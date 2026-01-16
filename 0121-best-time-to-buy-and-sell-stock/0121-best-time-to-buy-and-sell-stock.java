class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int maxSoFar=prices[n-1];
        int maxProfit=0;
        int currProfit=0;
        for(int i=n-1;i>=0;i--){
            if(prices[i]>maxSoFar){
                maxSoFar=prices[i];
            }else{
                currProfit=maxSoFar-prices[i];
                maxProfit=Math.max(currProfit,maxProfit);
            }
        }
        return maxProfit;
    }
}