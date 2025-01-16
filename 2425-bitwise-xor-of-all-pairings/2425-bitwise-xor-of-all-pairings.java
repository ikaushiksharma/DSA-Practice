class Solution {
    public int xorAllNums(int[] nums1, int[] nums2) {
        if ((nums1.length & 1) == 1 && (nums2.length & 1) == 1)
            return findXor(nums1, nums2);
        if ((nums2.length & 1) == 1)
            return xorAllNums(nums2, nums1);
        else if ((nums1.length & 1) == 1)
            return findXor(nums2, new int[0]);
        return 0;
    }
    private int findXor(int a[],int b[]){
        int res=0;
        for(int i:a) res^=i;
        for(int i:b) res^=i;
        return res;
    }
}