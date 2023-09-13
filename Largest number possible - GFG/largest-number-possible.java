//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String a[] = in.readLine().trim().split("\\s+");
            int N = Integer.parseInt(a[0]);
            int S = Integer.parseInt(a[1]);
            
            Solution ob = new Solution();
            System.out.println(ob.findLargest(N, S));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static String findLargest(int N, int sum){
        // code here
        if((N>1 && sum==0) || N*9<sum) return String.valueOf("-1");
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<N;i++){
            if(sum<9){
                sb.append(sum+"");
                sum=0;
            }
            else{
                sb.append(String.valueOf(9));
                sum-=9;
            }
        }
        return sb.toString();
    }
}