//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class GFG implements Runnable {
    public void run() {
        try {
            BufferedReader in;
            PrintWriter out;
            in = new BufferedReader(new InputStreamReader(System.in));
            out = new PrintWriter(System.out);
            int t = Integer.parseInt(in.readLine());

            while (t-- > 0) {
                int n = Integer.parseInt(in.readLine().trim());

                Solution g = new Solution();
                out.println(g.countWays(n));
            }
            out.close();
        } catch (Exception e) {
            ;
        }
    }

    public static void main(String args[]) throws IOException {
        new Thread(null, new GFG(), "whatever", 1 << 26).start();
    }
}
// } Driver Code Ends


//User function Template for Java


class Solution
{
    static int mod=1000000007;
    //Function to count the number of ways in which frog can reach the top.
    static long countWays(int n)
    {
        long dp[]=new long[n+1];
        Arrays.fill(dp,-1);
        return helper(n,dp);
    }
    static long helper(int n,long dp[]){
        if(n==0) return 1;
        if(dp[n]!=-1) return dp[n];
        long  op1=0,op2=0,op3=0;
        if(n>=1) op1=helper(n-1,dp);
        if(n>=2) op2=helper(n-2,dp);
        if(n>=3) op3=helper(n-3,dp);
        return dp[n]=(op1+op2+op3)%mod;
    }
    
}

