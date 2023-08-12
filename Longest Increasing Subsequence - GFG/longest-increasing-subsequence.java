//{ Driver Code Starts
import java.io.*;
import java.util.*; 

class GFG{
    public static void main(String args[]) throws IOException { 
        
        //taking input using Scanner class
        Scanner sc = new Scanner(System.in);
        
        //taking total testcases
        int t = sc.nextInt();
        while(t > 0){
            
            //taking size of array
            int n = sc.nextInt();
            int array[] = new int[n];
            
            //inserting elements in the array
            for (int i = 0; i < n; ++i)
            {
                array[i] = sc.nextInt();
            }
            
            //creating an object of class Solution
            Solution ob = new Solution();
            
            //calling longestSubsequence() method of class
            //Solution
            System.out.println(ob.longestSubsequence(n,array));
            t--;
        }
    } 
} 
// } Driver Code Ends




class Solution 
{
    //Function to find length of longest increasing subsequence.
    static int longestSubsequence(int size, int nums[])
    {
        // code her
        if(nums==null || size==0) return 0;
        int[] dp=new int[size];
        dp[0]=nums[0];
        int len=0;
        for(int i=0;i<nums.length;i++){
            if(dp[len]<nums[i]){
                dp[++len]=nums[i];
            }else{
                int ind=search(dp,len,nums[i]);
                dp[ind]=nums[i];
                
            }
        }
        return len+1;
    }
    private static int search(int[] dp,int len,int val){
        int start=0;
        while(start<=len){
            int mid=start+(len-start)/2;
            if(dp[mid]==val) return mid;
            else if(dp[mid]<val) start=mid+1;
            else len=mid-1;
        }
        return start;
    }
} 