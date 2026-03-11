class Solution {
    public int bitwiseComplement(int num) {
        if(num==0)return 1;
        int n=0;
        while(n<num) n=(n<<1)|1;
        return n-num;
    }
}