class Solution {
    String operators[] = new String[]{"+", "-", "*", "/"};
    private boolean isOperator(String s) {
        for(String operator: operators) {
            if(s.equals(operator)) return true;
        }
        
        return false;
    }

    private int eval(int left, int right, String operator) {
        return switch(operator) {
            case "+" -> left + right;
            case "-" -> left - right;
            case "*" -> left * right;
            case "/" -> left / right;
            default -> 0;
        };
    }

    public int evalRPN(String[] tokens) {
        Stack<Integer> stk = new Stack<>();
        for(String s: tokens) {
            if(!isOperator(s)) {
                stk.push(Integer.parseInt(s));
                continue;
            }
            else {
                int rightOperand = stk.pop();
                int leftOperand = stk.pop();
                stk.push(eval(leftOperand, rightOperand, s));
            }
        }
        return stk.peek();
    }
}
