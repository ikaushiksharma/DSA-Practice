//{ Driver Code Starts
//Initial Template for Java



import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int x = Integer.parseInt(inputLine[1]);
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            int ans = new Solution().count(arr, n, x);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java



class Solution {
    int count(int[] arr, int n, int x) {
        // code here
        int cnt=lastOccurence(arr,0,n-1,x)-firstOccurence(arr,0,n-1,x)+1;
        return cnt==-1?0:cnt;
    }
    int firstOccurence(int arr[],int lo,int hi,int x){
         while(lo<=hi){
            int mid=lo+(hi-lo)/2;
            if(arr[mid]>=x) hi=mid-1;
            else lo=mid+1;
        }
        return lo;
    }
    int lastOccurence(int arr[],int lo,int hi,int x){
        while(lo<=hi){
            int mid=lo+(hi-lo)/2;
            if(arr[mid]<=x) lo=mid+1;
            else hi=mid-1;
        }
        return hi;
    }
}