class Solution {
    private int[] nextSmallerElement(int nums[], int n) {
        Stack<Pair> stk = new Stack<>();
        int ans[] = new int[n];

        for(int i=n-1; i>=0; i--) {
            while(!stk.isEmpty() && stk.peek().val >= nums[i]) {
                stk.pop();
            }

            if(!stk.isEmpty()) ans[i] = stk.peek().index;
            else ans[i] = -1;

            stk.push(new Pair(nums[i], i));
        }

        return ans;
    }

    private int[] previousSmallerElement(int nums[], int n) {
        Stack<Pair> stk = new Stack<>();
        int ans[] = new int[n];

        for(int i=0; i<n; i++) {
            while(!stk.isEmpty() && stk.peek().val >= nums[i]) {
                stk.pop();
            }

            if(!stk.isEmpty()) ans[i] = stk.peek().index;
            else ans[i] = -1;

            stk.push(new Pair(nums[i], i));
        }

        return ans;
    }

    private int[] nextGreaterElement(int nums[], int n) {
        return new int[1];
    }

    private int[] previousGreaterElement(int nums[], int n) {
        return new int[1];
    }

    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int nse[] = nextSmallerElement(heights, n);
        int pse[] = previousSmallerElement(heights, n);

        int maxi = 0;
        int ans = 0;
        for(int i=0; i<n; i++) {
            if(nse[i] == -1 && pse[i] == -1) ans = Math.max(ans, n*heights[i]);
            
            if(nse[i] == -1) ans = Math.max(ans, (n - pse[i] - 1) * heights[i]);
            else if(pse[i] == -1) ans = Math.max(ans, nse[i] * heights[i]);
            else ans = Math.max(ans, (nse[i] - pse[i] - 1) * heights[i]);

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
