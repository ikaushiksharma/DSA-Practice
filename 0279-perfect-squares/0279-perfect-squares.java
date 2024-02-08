class Solution {
    public int numSquares(int n) {
        if(isPerfectSquare(n)) return 1;
        for(int i=1;i*i<n;i++){
            if(isPerfectSquare(n-i*i)) return 2;
        }
        if(legendreFunction(n)) return 3;
        return 4;
    }
    private boolean isPerfectSquare(int n){
        int root=(int)(Math.floor(Math.sqrt(n)));
        return n==root*root;
    }
    private boolean legendreFunction(int n){
        while(n%4==0) n/=4;
        return n%8!=7;
    }
}