class Solution {
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int[][] matrix = new int[m][n];
        for (int val[] : walls) {
            matrix[val[0]][val[1]] = 2;
        }
        for (int val[] : guards) {
            matrix[val[0]][val[1]] = 3;
        }

        for (int val[] : guards) {
            int row = val[0];
            int col = val[1];
            // down
            for (int i = row + 1; i < m; i++) {
                if (matrix[i][col] == 2 || matrix[i][col] == 3) {
                    break;
                }
                matrix[i][col] = 1;
            }
            // up
            for (int i = row - 1; i >= 0; i--) {
                if (matrix[i][col] == 2 || matrix[i][col] == 3) {
                    break;
                }
                matrix[i][col] = 1;
            }
            // right
            for (int i = col + 1; i < n; i++) {
                if (matrix[row][i] == 2 || matrix[row][i] == 3) {
                    break;
                }
                matrix[row][i] = 1;
            }
            // left
            for (int i = col - 1; i >= 0; i--) {
                if (matrix[row][i] == 2 || matrix[row][i] == 3) {
                    break;
                }
                matrix[row][i] = 1;
            }
        }
        int res = 0;
        for (int val[] : matrix) {
            for (int i = 0; i < n; i++) {
                if (val[i] == 0)
                    res++;
                
            }
        }
        return res;
    }
}