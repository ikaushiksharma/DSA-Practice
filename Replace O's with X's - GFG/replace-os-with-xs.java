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
            String a[] = in.readLine().trim().split(" ");
            int n = Integer.parseInt(a[0]);
            int m = Integer.parseInt(a[1]);
            char mat[][] = new char[n][m];
            for(int i=0; i<n; i++)
            {
                String S[] = in.readLine().trim().split(" ");
                for(int j=0; j<m; j++)
                {
                    mat[i][j] = S[j].charAt(0);
                }
            }
            
            Solution ob = new Solution();
            char[][] ans = ob.fill(n, m, mat);
            for(int i = 0;i < n;i++) {
                for(int j = 0;j < m;j++) {
                    System.out.print(ans[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static int dirX[]={1,-1,0,0};
    static int dirY[]={0,0,1,-1};
    static char[][] fill(int n, int m, char a[][]){
        // code here
        int vis[][]=new int[n][m];
        // top
        for(int i=0;i<m;i++){
            if(vis[0][i]==0 && a[0][i]=='O'){
                dfs(a,0,i,n,m,vis);
            }
        }
        // left
        for(int i=0;i<n;i++){
            if(vis[i][0]==0 && a[i][0]=='O'){
                dfs(a,i,0,n,m,vis);
            }
        }
        // right
        for(int i=0;i<n;i++){
            if(vis[i][m-1]==0 && a[i][m-1]=='O'){
                dfs(a,i,m-1,n,m,vis);
            }
        }
        // bottom
        for(int i=0;i<m;i++){
            if(vis[n-1][i]==0 && a[n-1][i]=='O'){
                dfs(a,n-1,i,n,m,vis);
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(vis[i][j]==1) a[i][j]='O';
                else a[i][j]='X';
            }
        }
        return a;
    }
    private static void dfs(char[][]a,int row,int col,int n,int m,int[][]vis){
        vis[row][col]=1;
        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                int nrow=row+dirX[i];
                int ncol=col+dirY[i];
                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && vis[nrow][ncol]==0 && a[nrow][ncol]=='O')
                    dfs(a,nrow,ncol,n,m,vis);
            }
        }
    }
}