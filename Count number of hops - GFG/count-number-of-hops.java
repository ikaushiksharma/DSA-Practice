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
        dp[0]=1;
        for(int i=1;i<=n;i++){
            long  op1=0,op2=0,op3=0;
            if(i>=1) op1=dp[i-1];
            if(i>=2) op2=dp[i-2];
            if(i>=3) op3=dp[i-3];
            dp[i]=(op1+op2+op3)%mod;
        }
        return dp[n];
    }
}

