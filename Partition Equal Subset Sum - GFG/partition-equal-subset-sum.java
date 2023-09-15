//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            String input_line[] = in.readLine().trim().split("\\s+");
            int arr[] = new int[N];
            for(int i = 0;i < N;i++)
                arr[i] = Integer.parseInt(input_line[i]);
            
            Solution ob = new Solution();
            int x = ob.equalPartition(N, arr);
            if(x == 1)
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution{
    static int equalPartition(int N, int arr[])
    {
        // code here
        int sum=Arrays.stream(arr).sum();
        int dp[][]=new int[N][sum+1];
        for(int i=0;i<N;i++) Arrays.fill(dp[i],-1);
        if((sum&1)==1) return 0;
        return helper(N-1,arr,sum/2,dp)?1:0;
    }
    private static boolean helper(int idx,int arr[],int target,int dp[][]){
        if(target==0) return true;
        if(idx<0) return false;
        if(dp[idx][target]!=-1) return dp[idx][target]==1;
        boolean notPick=helper(idx-1,arr,target,dp);
        boolean pick=false;
        if(arr[idx]<=target){
            pick=helper(idx-1,arr,target-arr[idx],dp);
        }
        if(pick||notPick){
            dp[idx][target]=1;
        }else{
            dp[idx][target]=0;
        }
        return dp[idx][target]==1;
    }
}