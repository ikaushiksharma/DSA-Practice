class Solution {
    public boolean hasAllCodes(String s, int k) {
        if(s.length()<k) return false;
        HashSet<String> set=new HashSet<>();
        int n=s.length();
        set.add(s.substring(0,k));
        for(int i=1;i<=n-k;i++){
             set.add(s.substring(i,i+k));
        }
        return set.size()==(int)Math.pow(2,k);
    }
}