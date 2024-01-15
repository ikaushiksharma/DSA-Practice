class Solution {
    public int minAddToMakeValid(String s) {
        Stack<Character> st = new Stack<>();
        int cnt = 0;
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                st.push(c);
            } else if (st.isEmpty())
                cnt++;
            else if (!st.isEmpty() && (c == '}' && st.peek() == '{') || (c == ')' && st.peek() == '(')
                    || (c == ']' && st.peek() == '['))
                st.pop();
            else
                cnt++;
        }
        return st.size() + cnt;
    }
}