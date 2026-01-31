class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> charToIndex = new HashMap<>();
        int len = s.length();
        if (len == 0 || len == 1)
            return len;
        int res = 1;
        int st = 0;
        for (int e = 0; e < len; e++) {
            char curr = s.charAt(e);
            while (charToIndex.containsKey(curr)) {
                charToIndex.remove(s.charAt(st++));
            }
            charToIndex.put(curr, e);
            res = Math.max(res, e - st+1);
        }
        return res;

    }
}