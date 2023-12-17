class Solution {
    public List<String> letterCombinations(String digits) {
        String digitletter[] = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        List<String> res=new ArrayList<>();
        if(digits.length()==0) return res;
        helper(digits,digitletter,0,digits.length(),res,new StringBuilder());
        return res;
    }
    private void helper(String digits,String arr[],int idx,int n,List<String>res,StringBuilder out){
        if(idx==n){
            res.add(out.toString());
            return;
        }
        int val=digits.charAt(idx)-'0';
        String value=arr[val];
        for(int i=0;i<value.length();i++){
            out.append(value.charAt(i));
            helper(digits,arr,idx+1,n,res,out);
            out.deleteCharAt(out.length()-1);
        }
    }
}