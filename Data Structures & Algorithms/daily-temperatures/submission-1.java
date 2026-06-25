class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int ans[] = new int[n];
        Stack<Pair> stk = new Stack<>();
        for(int i=n-1; i>=0; i--) {
            while(!stk.isEmpty() && stk.peek().val <= temperatures[i]) {
                stk.pop();
            }

            if(!stk.isEmpty()) ans[i] = stk.peek().index - i;
            else {
                ans[i] = 0;
            }

            stk.push(new Pair(temperatures[i], i));
        }

        return ans;
    }
}

class Pair {
    int val;
    int index;

    Pair(int val, int index) {
        this.val = val;
        this.index = index;
    }
}
