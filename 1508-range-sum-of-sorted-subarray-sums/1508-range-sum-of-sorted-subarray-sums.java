class Solution {
    public int rangeSum(int[] nums, int n, int left, int right) {
        int mod=(int)(1e9)+7;
        int temp[] = new int[n * (n + 1) / 2];
        int k=0;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += nums[j];
                temp[k++] = sum;
            }
        }
        Arrays.sort(temp);
        long res=0;
        for(int i=left-1;i<right;i++){
            res+=temp[i];
            res%=mod;
        }
        return (int)res;
    }
}