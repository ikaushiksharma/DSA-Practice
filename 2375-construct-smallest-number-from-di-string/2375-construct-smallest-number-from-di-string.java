class Solution {
    public String smallestNumber(String pattern) {
        Stack<Integer> st = new Stack<Integer>();
        int len = pattern.length();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= len; i++) {
            st.push(i + 1);
            if (i < len && pattern.charAt(i) == 'I') {
                while (!st.isEmpty()) {
                    int t = st.pop();
                    sb.append((char) (t + '0'));
                }
            }
        }
        while (!st.isEmpty()) {
            int t = st.pop();
            sb.append((char) (t + '0'));
        }
        return sb.toString();
    }
}