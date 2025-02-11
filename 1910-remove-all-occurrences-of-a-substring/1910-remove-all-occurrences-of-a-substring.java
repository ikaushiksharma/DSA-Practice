class Solution {
    public String removeOccurrences(String s, String part) {
        Stack<Character> st = new Stack<>();
        for (char c : s.toCharArray()) {
            st.push(c);
            removeOcc(st, part);
        }
        StringBuilder sb = new StringBuilder();
        while (!st.isEmpty())
            sb.append(st.pop());
        return sb.reverse().toString();
    }

    private void removeOcc(Stack<Character> st, String p) {
        int m = p.length();
        if (st.size() < m)
            return;
        String x = "";
        for (int j = m - 1; j >= 0; j--) {
            char ch = p.charAt(j);
            if (ch != st.peek()) {
                for (int k = 0; k < x.length(); k++) {
                    st.push(x.charAt(k));
                }
                break;
            } else {
                x = st.peek() + x;
                st.pop();
            }
        }

    }
}