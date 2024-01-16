class Solution {
    public long minOperations(int[] nums1, int[] nums2, int k) {
        if(k==0){
            return Arrays.equals(nums1,nums2)?0:-1;
        }
        int n = nums1.length;
        long res = 0;
        int sum1 = Arrays.stream(nums1).sum();
        int sum2 = Arrays.stream(nums2).sum();
        if (sum1 != sum2)
            return -1;
        for (int i = 0; i < n; i++) {
            int diff = (nums1[i] - nums2[i]);
            if (diff % k != 0)
                return -1;

            if ( diff / k > 0)
                res += diff / k;
        }
        return res;
    }
}