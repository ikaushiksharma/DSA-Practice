class Solution {
    public final static int A='a';
    public boolean closeStrings(String word1, String word2) {
        if(word1.length()!=word2.length()) return false;
        int f1[]=new int[26];
        int f2[]=new int[26];
        for(char c:word1.toCharArray()) f1[c-A]++;
        for(char c:word2.toCharArray()) f2[c-A]++;
        for(int i=0;i<26;i++){
            if((f1[i]!=0 && f2[i]==0) || (f1[i]==0 && f2[i]!=0)) return false;
        }
        Arrays.sort(f1);
        Arrays.sort(f2);
        for(int i=0;i<26;i++){
            if(f1[i]!=f2[i]) return false;
        }
        return true;
    }
}