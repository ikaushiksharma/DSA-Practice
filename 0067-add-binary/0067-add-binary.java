class Solution {
    public String addBinary(String a, String b) {
        int carry=0;
        int i=a.length()-1;
        int j=b.length()-1;
        StringBuilder ans=new StringBuilder();
        int help;
        int sum=0;
        while(i>=0 || j>=0) {
            int num1=0;
            int num2=0;
            if(i>=0)
                num1=a.charAt(i)-'0';
            if(j>=0)
                num2=b.charAt(j)-'0';
            help=num1+num2+carry;
            carry=help/2;
            sum=help%2;
            if(j>=0) j--;
            if(i>=0) i--;
            ans.insert(0,sum);   
        }
        if(carry>0)
            ans.insert(0,carry);
        return ans.toString();
    }
}