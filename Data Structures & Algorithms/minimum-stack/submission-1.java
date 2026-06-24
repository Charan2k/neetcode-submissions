class MinStack {
    Stack<Pair> stk;

    public MinStack() {
        stk = new Stack<>();
    }
    
    public void push(int val) {
        int mini;
        if(!stk.isEmpty()) mini = Math.min(val, stk.peek().min);
        else mini = val;
        stk.push(new Pair(val, mini));

    }
    
    public void pop() {
        stk.pop();
    }
    
    public int top() {
        return stk.peek().val;
    }
    
    public int getMin() {
        return stk.peek().min;
    }
}
class Pair {
    int val;
    int min;
    Pair(int val, int min) {
        this.val = val;
        this.min = min;
    }
}