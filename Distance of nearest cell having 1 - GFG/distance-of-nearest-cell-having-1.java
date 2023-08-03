//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int[][] grid = new int[n][m];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < m; j++){
                    grid[i][j] = Integer.parseInt(S[j]);
                }
            }
            Solution obj = new Solution();
            int[][] ans = obj.nearest(grid);
            for(int i = 0; i < ans.length; i++){
                for(int j = 0; j < ans[i].length; j++){
                    System.out.print(ans[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}
// } Driver Code Ends


class Solution{
    class Node {
        int x;
        int y;
        int dis; 
        Node(int x, int y, int dis) {
            this.x = x; 
            this.y = y; 
            this.dis = dis; 
        }
    }
    //Function to find distance of nearest 1 in the grid for each cell.
    public int[][] nearest(int[][] grid){
        int n=grid.length;
        int m=grid[0].length;
        boolean vis[][]=new boolean[n][m];
        int[][] dist=new int[n][m];
        Queue<Node> q=new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1 && vis[i][j]==false){
                    q.add(new Node(i,j,0));
                    vis[i][j]=true;
                }
            }
        }
        int dRow[]={1,-1,0,0};
        int dCol[]={0,0,1,-1};
        while(!q.isEmpty()){
            Node curr=q.poll();
            dist[curr.x][curr.y]=curr.dis;
            for(int i=0;i<4;i++){
                int row=curr.x+dRow[i];
                int col=curr.y+dCol[i];
                if(row>=0 && row<n && col>=0 && col<m && vis[row][col]==false){
                    vis[row][col]=true;
                    q.add(new Node(row,col,curr.dis+1));
                }
            }
        }
        return dist;
    }
}