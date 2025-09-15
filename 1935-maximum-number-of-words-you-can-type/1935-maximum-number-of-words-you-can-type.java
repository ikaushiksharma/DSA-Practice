class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
        HashSet set=new HashSet<Character>();
        for(char c: brokenLetters.toCharArray()){
            set.add(c);
        }
        int count=0;
        for(String s: text.split(" ")){
            if(checkIfPossible(s,set)) count++;
        }
        return count;
    }
    private boolean checkIfPossible(String s, HashSet<Character> set){
        for(char c: s.toCharArray()){
            if(set.contains(c)) return false;
        }
        return true;
    }
}