class Solution {
    public boolean isValid(String s) {
        Stack<Character> st=new Stack<>();
        for(char c:s.toCharArray()){
            st.push(c);
            checkIfPossible(st);
        }
        return st.isEmpty();
    }
    private void checkIfPossible(Stack<Character> st){
        if(st.isEmpty() || st.size()<3) return;
        char a,b,c;
        c=st.pop();
        b=st.pop();
        a=st.pop();
        if(c=='c' && b=='b' && a=='a') return;
        st.push(a);
        st.push(b);
        st.push(c);
    }
}