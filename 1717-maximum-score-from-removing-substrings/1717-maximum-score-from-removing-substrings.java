class Solution {
    public int maximumGain(String s, int x, int y) {
        if (!s.contains("ab") && !s.contains("ba")) {
            return 0;
        }
        int baCase = 0;
        int abCase = 0;
        if (s.contains("ab")) {
            int idx = s.indexOf("ab");
            abCase = x + maximumGain(s.substring(0, idx) + s.substring(idx + 2),x,y);
        } 
        if(s.contains("ba")) {
            int idx = s.indexOf("ba");
            baCase = y + maximumGain(s.substring(0, idx) + s.substring(idx + 2),x,y);
        }
        return Math.max(abCase, baCase);
    }
}