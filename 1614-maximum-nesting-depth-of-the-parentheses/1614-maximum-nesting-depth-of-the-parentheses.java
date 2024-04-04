class Solution {
    public int maxDepth(String s) {
        int count=0,result=0;
        for(char ch:s.toCharArray()){
            if(ch=='(')
            {
                result=Math.max(result,++count);
            }
            if (ch==')')
                count--;
        }
        return result;
    }
}