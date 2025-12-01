class Solution {
    public long maxRunTime(int n, int[] batteries) {
        Arrays.sort(batteries);
        long lo=1;
        long hi=Arrays.stream(batteries).asLongStream().sum()/n;
        while(lo<hi){
            long mid=hi-(hi-lo)/2;
            if(isValid(mid,n,batteries)){
                lo=mid;
            }else{
                hi=mid-1;
            }
        }
        return lo;
    }
    private boolean isValid(long min,int n,int[] arr){
        long total=Arrays.stream(arr).asLongStream().map(battery->Math.min(battery,min)).sum();
        return total>=min*n;
    }
}