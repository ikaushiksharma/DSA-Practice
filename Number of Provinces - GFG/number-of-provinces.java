//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int V = Integer.parseInt(read.readLine());
            
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            
            for(int i=0; i<V; i++)
            {
                String S[] = read.readLine().split(" ");
                ArrayList<Integer> temp = new ArrayList<>();
                for(int j=0; j<V; j++)
                    temp.add(Integer.parseInt(S[j]));
                adj.add(temp);
            }

            Solution ob = new Solution();
            System.out.println(ob.numProvinces(adj,V));
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class DisjointSet{
    List<Integer> size=new ArrayList<>();
    List<Integer> parent=new ArrayList<>();
    public DisjointSet(int n){
        for(int i=0;i<n;i++){
            size.add(0);
            parent.add(i);
        }
    }
    public int findUPar(int node){
        if(node==parent.get(node)) return node;
        int uNode=findUPar(parent.get(node));
        parent.set(node,uNode);
        return uNode;
    }
    public void unionBySize(int u,int v){
        int pu=findUPar(u);
        int pv=findUPar(v);
        if(pu==pv) return;
        if(size.get(pu)<size.get(pv)){
            parent.set(pu,pv);
            size.set(pv,size.get(pu)+size.get(pv));
        }else{
            parent.set(pv,pu);
            size.set(pu,size.get(pu)+size.get(pv));
        }
    }
}
class Solution {
    static int numProvinces(ArrayList<ArrayList<Integer>> adj, int V) {
        DisjointSet ds=new DisjointSet(V);
        for(int i=0;i<V;i++){
            for(int j=0;j<V;j++){
                if(adj.get(i).get(j)==1) ds.unionBySize(i,j);
            }
        }
        int cnt=0;
        for(int i=0;i<V;i++){
            if(ds.parent.get(i)==i) cnt++;
        }
        return cnt;
    }
};