//{ Driver Code Starts
//Initial Template for Java
import java.util.*;
import java.io.*;
class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(read.readLine());
            Solution ob = new Solution();

            System.out.println(ob.nthFibonacci(n));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

//User function Template for Java
class Solution {
    static int mod=1000000007;
    static int nthFibonacci(int n){
        // code here
        int memo[]=new int[n+1];
        Arrays.fill(memo,-1);
        return helper(n,memo)%mod;
    }
    static int helper(int n,int memo[]){
        if(n==0 || n==1) return memo[n]=n;
        if(memo[n]!=-1) return memo[n]%mod;
        return memo[n]=helper(n-1,memo)%mod+helper(n-2,memo)%mod;
    }
}