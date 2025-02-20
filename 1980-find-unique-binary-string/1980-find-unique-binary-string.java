class Solution {
    public String findDifferentBinaryString(String[] nums) {
        HashSet<String> numSet=new HashSet<>();
        for(String s:nums){
            numSet.add(s);
        }
        int n=nums.length;
        int pow=(int)(Math.pow(2,n));
        for(int i=0;i<pow;i++){
            String sb=binaryOfLen(i,n);
            if(!numSet.contains(sb)) return sb;
        }
        return "-1";
    }
    private String binaryOfLen(int num,int len){
        StringBuilder sb=new StringBuilder();
        while(len-->0){
            sb.append(num%2);
            num/=2;
        }
        return sb.toString();
    }
}