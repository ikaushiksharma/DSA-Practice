class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if(n==0) return;
        int i=m+n-1;
        int a=m-1;
        int b=n-1;

        for(;i>=0;i--){
            if(a>=0 && b>=0){
                if(nums1[a]>=nums2[b]){
                    nums1[i]=nums1[a--];
                }else{
                    nums1[i]=nums2[b--];
                }
            }else{
                break;
            }
        }
        while(b>=0){
            nums1[i--]=nums2[b--];
        }
    }
}