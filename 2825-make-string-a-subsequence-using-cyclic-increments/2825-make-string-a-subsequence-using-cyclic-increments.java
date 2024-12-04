class Solution {
    private boolean canBeConverted(char a, char b){
        return (((a-'a')+27)%26)==(b-'a') || a==b;
    }
    public boolean canMakeSubsequence(String str1, String str2) {
        int k=0;
        int len=str2.length();
        for(char c:str1.toCharArray()){
            if(canBeConverted(c,str2.charAt(k)))k++;
            if(k==len) return true;
        }
        return false;
    }
}