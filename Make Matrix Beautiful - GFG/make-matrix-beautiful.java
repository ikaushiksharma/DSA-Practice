//{ Driver Code Starts
import java.io.*;
import java.util.*;


class IntMatrix
{
    public static int[][] input(BufferedReader br, int n, int m) throws IOException
    {
        int[][] mat = new int[n][];

        for(int i = 0; i < n; i++)
        {
            String[] s = br.readLine().trim().split(" ");
            mat[i] = new int[s.length];
            for(int j = 0; j < s.length; j++)
                mat[i][j] = Integer.parseInt(s[j]);
        }

        return mat;
    }

    public static void print(int[][] m)
    {
        for(var a : m)
        {
            for(int e : a)
                System.out.print(e + " ");
            System.out.println();
        }
    }

    public static void print(ArrayList<ArrayList<Integer>> m)
    {
        for(var a : m)
        {
            for(int e : a)
                System.out.print(e + " ");
            System.out.println();
        }
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int N;
            N = Integer.parseInt(br.readLine());
            
            
            int[][] matrix = IntMatrix.input(br, N, N);
            
            Solution obj = new Solution();
            int res = obj.findMinOperation(N, matrix);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends



class Solution {
    public static int findMinOperation(int N, int[][] matrix){
        int maxSum=0;
        int rows[]=new int[N];
        int cols[]=new int[N];
        for(int i=0;i<N;i++){
            int sum=0;
            for(int j=0;j<N;j++){
                rows[i]+=matrix[i][j];
                cols[i]+=matrix[j][i];
            }
            maxSum=Math.max(maxSum,rows[i]);
            maxSum=Math.max(maxSum,cols[i]);
        }
        int resR=0;
        int resC=0;
        for(int i=0;i<N;i++){
            resR+=maxSum-rows[i];
        }
        for(int i=0;i<N;i++){
            resC+=maxSum-cols[i];
        }
        return Math.max(resC,resR);
    }
}
        
