//{ Driver Code Starts
import java.io.*;
import java.util.*;

class RodCutting {

    public static void main(String args[])throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        
        int t = Integer.parseInt(in.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(in.readLine().trim());
            String s[]=in.readLine().trim().split(" ");
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(s[i]);

            Solution ob = new Solution();
            out.println(ob.cutRod(arr, n));
        }
        out.close();
    }
}

// } Driver Code Ends


class Solution{
    public int cutRod(int price[], int n) {
        //code here
        int dp[][]=new int[price.length][n+1];
        for(int i=0;i<price.length;i++) Arrays.fill(dp[i],-1);
        return helper(price,price.length-1,n,dp);
    }
    private int helper(int arr[],int idx,int n,int dp[][]){
        if(idx==0) return n*arr[0];
        if(dp[idx][n]!=-1) return dp[idx][n];
        int notTake=helper(arr,idx-1,n,dp);
        int take=Integer.MIN_VALUE;
        int rodLen=idx+1;
        if(rodLen<=n){
            take=arr[idx]+helper(arr,idx,n-rodLen,dp);
        }
        return dp[idx][n]=Math.max(take,notTake);
    }
}