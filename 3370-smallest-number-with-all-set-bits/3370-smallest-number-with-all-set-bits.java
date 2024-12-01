class Solution {
    public int smallestNumber(int n) {
        int val=1;
        while(n>=val){
            val*=2;
        }
        return val-1;
    }
}