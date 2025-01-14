class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int freq[] = new int[A.length + 1];
        int res[] = new int[A.length];
        int common=0;
        for (int i = 0; i < A.length; i++) {
            if (++freq[A[i]] == 2)
                common++;
            if (++freq[B[i]] == 2)
                common++;
            res[i]=common;
        }
        return res;
    }
}