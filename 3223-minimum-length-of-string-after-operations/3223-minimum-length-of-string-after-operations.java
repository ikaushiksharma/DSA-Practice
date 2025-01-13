class Solution {
    public int minimumLength(String s) {
        int freq[] = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }
        int res = 0;
        for (int i : freq) {
            if (i == 0)
                continue;
            if (i % 2 == 0)
                res += 2;
            else
                res += 1;
        }
        return res;
    }
}