class Solution {
    public boolean exist(char[][] board, String word) {
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(word.charAt(0)==board[i][j] && doesExists(board,i,j,word,0)) return true;
            }
        }
        return false;
    }
    private boolean doesExists(char[][]board,int i,int j,String word,int wordIdx){
        if(wordIdx==word.length()) return true;
        if(i<0 || i>=board.length || j<0 || j>=board[0].length){
            return false;
        }
        char curChar=board[i][j];
        if(curChar=='$') return false;
        if(curChar!=word.charAt(wordIdx)) return false;
        board[i][j]='$';
        boolean isExist=doesExists(board,i+1,j,word,wordIdx+1) ||
                        doesExists(board,i-1,j,word,wordIdx+1) ||
                        doesExists(board,i,j+1,word,wordIdx+1) ||
                        doesExists(board,i,j-1,word,wordIdx+1);
        board[i][j]=curChar;
        return isExist;
    }
}