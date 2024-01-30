class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack=new Stack<Integer>();
        int a,b;
        for(String s:tokens){
            if(s.equals("+")){
                stack.add(stack.pop()+stack.pop());
            }
            else if(s.equals("-")){
                b=stack.pop();
                a=stack.pop();
                stack.add(a-b);
            }
            else if(s.equals("*")){
                stack.add(stack.pop()*stack.pop());
            }
            else if(s.equals("/")){
                b=stack.pop();
                a=stack.pop();
                stack.add(a/b);
            }
            else{
                stack.add(Integer.parseInt(s));
            }
        }        
        return stack.pop();
    }
}