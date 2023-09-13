//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n = sc.nextInt();
                    int sum = sc.nextInt();
                    int arr[] = new int[n];
                    for(int i = 0;i<n;i++)
                    arr[i] = sc.nextInt();
                    
                    Solution ob = new Solution();
                    System.out.println(ob.perfectSum(arr,n,sum));
                }
        }
}    
// } Driver Code Ends


class Solution{
    private int mod=1000000007;
	public int perfectSum(int arr[],int n, int sum) 
	{ 
	    // Your code goes here
	    int dp[][]=new int[n][sum+1];
	    for(int i=0;i<n;i++)Arrays.fill(dp[i],-1);
	    return helper(arr,n-1,sum,dp);
	} 
	private int helper(int arr[],int idx,int sum,int dp[][]){
	    if(idx==0){
	        if(arr[0]==0 && sum==0) return 2;
	        if(sum==0 || sum==arr[0]) return 1;
	        return 0;
	    }
	    if(idx<0){
	        return 0;
	    }
        if(dp[idx][sum]!=-1) return dp[idx][sum];
	    int notPick=helper(arr,idx-1,sum,dp)%mod;
	    int pick=0;
	    if(sum>=arr[idx])
	        pick=helper(arr,idx-1,sum-arr[idx],dp)%mod;
	    return dp[idx][sum]=(pick+notPick)%mod;
	}
}