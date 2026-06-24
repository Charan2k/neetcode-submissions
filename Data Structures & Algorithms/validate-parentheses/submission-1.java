class Solution {
    public boolean isValid(String s) {
        Stack<Character> stk = new Stack<>();

        for(char ch: s.toCharArray()) {
            if(ch == '(' || ch == '{' || ch == '[') {
                stk.push(ch);
            }
            else {
                if(stk.isEmpty()) return false;
                if(ch == ')') {
                    if(stk.peek() != '(') return false;
                    stk.pop();
                }
                else if(ch == '}') {
                    if(stk.peek() != '{') return false;
                    stk.pop();
                }
                else {
                    if(stk.peek() != '[') return false;
                    stk.pop();
                }
            }
        }

        return stk.isEmpty();
    }
}
