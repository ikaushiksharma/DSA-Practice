class Solution {
    public boolean isPalindrome(String s) {
        int i=0;
        int j=s.length()-1;
        while(i<j){
            char a=s.charAt(i);
            char b=s.charAt(j);
            if(!Character.isLetterOrDigit(a)){
                i++;
                continue;
            }
            else if(!Character.isLetterOrDigit(b)){
                j--;
                continue;
            }
            else if(!isValid(a,b)) return false;
            i++;
            j--;
        }
        return true;
    }
    private boolean isValid(char a,char b){
        return Character.toLowerCase(a)==Character.toLowerCase(b);
    }
}