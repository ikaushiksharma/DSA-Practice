class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res=new ArrayList<>();
        helper(res,0,0,n,"");
        return res;
    }
    private void helper(List<String> res,int open,int close,int n,String out){
        if(open==n && close==n){
            res.add(out);
            return;
        }
        if(open<n)helper(res,open+1,close,n,out+"(");

        if(close<open){
            helper(res,open,close+1,n,out+")");
        }
    }
}