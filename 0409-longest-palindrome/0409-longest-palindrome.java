class Solution {
    public int longestPalindrome(String s) {
        HashMap<Character,Integer> mp=new HashMap<>();
        for(int i=0;i<s.length();i++)
            mp.put(s.charAt(i),(mp.getOrDefault(s.charAt(i),0)+1));
        int ans=0;
        boolean isOdd=false;
        for(int cnt:mp.values()){
            if(cnt%2==0)
                ans+=cnt;
            else{
                isOdd=true;
                ans+=cnt-1;
            }
        }
        return isOdd?(ans+1):ans;
    }
}