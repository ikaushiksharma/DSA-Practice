class Solution {
    public int numMagicSquaresInside(int[][] grid) {
        int count=0;
        int r=grid.length;
        int c=grid[0].length;
        for(int i=0;i<=r-3;i++){
            for(int j=0;j<=c-3;j++){
                if(isMagicGrid(grid,i,j)){
                    count++;
                }
            }
        }
        return count;
    }

    public boolean isMagicGrid(int[][]grid,int r,int c){
        //only no 1 to 9 and no duplicate
        HashSet<Integer> set=new HashSet<>();
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                int num=grid[r+i][c+j];
                if(num>9 || num<1 || set.contains(num)) return false;
                else set.add(num);
            }
        }
        //row sum col sum diagonal sum antidiagonal sum all should be equal
        int sum=grid[r][c]+grid[r][c+1]+grid[r][c+2];
        for(int i=0;i<3;i++){
            //row sum
            if(grid[r+i][c]+grid[r+i][c+1]+grid[r+i][c+2] !=sum) return false;
            //col sum
            if(grid[r][c+i]+grid[r+1][c+i]+grid[r+2][c+i] !=sum) return false;
            //diagonal sum
            if(grid[r][c]+grid[r+1][c+1]+grid[r+2][c+2] !=sum) return false;
            //antidiagnoal sum
            if(grid[r][c+2]+grid[r+1][c+1]+grid[r+2][c] !=sum) return false;
        }
        return true;
    }
}