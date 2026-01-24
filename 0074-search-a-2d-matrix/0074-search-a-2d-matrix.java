class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int R = matrix.length;
        int C = matrix[0].length;
        int r = 0;
        int c = C - 1;
        while (r >= 0 && r < R && c >= 0 && c < C) {
            int curr = matrix[r][c];
            if (curr < target)
                r++;
            else if (curr > target)
                c--;
            else
                return true;
        }
        return false;
    }
}