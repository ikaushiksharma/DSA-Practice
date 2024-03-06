class Solution {
    public int candy(int[] ratings) {
        int n=ratings.length;
        int suf[]=new int[n];
        int pre[]=new int[n];
        pre[0]=suf[n-1]=1;
        int ans=0;
        for(int i=1;i<n;i++){
            if(ratings[i]>ratings[i-1]) pre[i]=pre[i-1]+1;
            else pre[i]=1;
        }
        for(int i=n-2;i>=0;i--){
            if(ratings[i]>ratings[i+1]) suf[i]=suf[i+1]+1;
            else suf[i]=1;
            ans+=Math.max(suf[i],pre[i]);
        }
        return ans+=Math.max(pre[n-1],suf[n-1]);
    }
}