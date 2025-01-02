class Solution {
    private final char[] VOWELS = { 'a', 'e', 'i', 'o', 'u' };

    public int[] vowelStrings(String[] words, int[][] queries) {
        int prefixArr[] = new int[words.length+1];
        for (int i = 0; i < words.length; i++) {
            prefixArr[i+1] = prefixArr[i];
            if (isValid(words[i])) {
                prefixArr[i+1]++;
            }
        }
        int res[]=new int[queries.length];
        for(int i=0;i<queries.length;i++){
            res[i]=prefixArr[queries[i][1]+1]-prefixArr[queries[i][0]];
        }
        return res;
    }

    private boolean isValid(String word) {
        boolean firstVowel = false;
        boolean lastVowel = false;
        for (char c : VOWELS) {
            if (c == word.charAt(0))
                firstVowel = true;
            if (c == word.charAt(word.length() - 1))
                lastVowel = true;
            if(firstVowel && lastVowel) return true;
        }
        return firstVowel && lastVowel;
    }
}