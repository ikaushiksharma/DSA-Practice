class NumMatrix {
    int arr[][];
    public NumMatrix(int[][] matrix) {
        arr = matrix;
        for(int i=0; i<matrix.length; i++){
            for(int j=1; j<matrix[i].length; j++){
                arr[i][j] += arr[i][j-1];
            }
        }
        for(int j=0; j<matrix[0].length; j++){
            for(int i=1; i<matrix.length; i++){
                arr[i][j] += arr[i-1][j];
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int bottomright = arr[row2][col2];
        int left = 0;
        int top = 0;
        int diagonal = 0;
        if(col1-1>=0) left = arr[row2][col1-1];
        if(row1-1>=0) top = arr[row1-1][col2];
        if(row1-1>=0 && col1-1>=0) diagonal = arr[row1-1][col1-1];
        return bottomright-left-top+diagonal;
    }
}