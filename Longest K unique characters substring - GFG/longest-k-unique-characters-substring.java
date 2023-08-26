//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s = sc.next();
            int k = sc.nextInt();
            Solution obj = new Solution();
            System.out.println(obj.longestkSubstr(s, k));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public int longestkSubstr(String s, int k) {
        // code here
        int res=-1;
        int i=0;
        int cnt=0;
        HashMap<Character,Integer> mp=new HashMap<>();
        for(int j=0;j<s.length();j++){
            char c=s.charAt(j);
            mp.put(c,mp.getOrDefault(c,0)+1);
            cnt++;
            while(mp.size()>k){
                mp.put(s.charAt(i),mp.get(s.charAt(i))-1);
                if(mp.get(s.charAt(i))==0) mp.remove(s.charAt(i));
                i++;
                cnt--;
            }
            if(mp.size()==k){
                res=Math.max(cnt,res);
            }
            
        }
        return res;
    }
}