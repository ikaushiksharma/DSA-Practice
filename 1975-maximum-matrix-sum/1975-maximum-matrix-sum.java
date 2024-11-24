class Solution {
    public long maxMatrixSum(int[][] matrix) {
        int m=matrix.length;
        int n=matrix[0].length;
        int negCnt=0;
        int sum=0;
        int min=Integer.MAX_VALUE;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int val=Math.abs(matrix[i][j]);
                min=Math.min(min,val);
                if(matrix[i][j]<0) negCnt++;
                sum+=val;
            }
        }
        if(negCnt%2==0) return sum;
        else return sum-2*min;
    }
}