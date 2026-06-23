class Solution {
    public int characterReplacement(String s, int k) {
        int n = s.length();
        int ans = 0;
        for(char ch = 'A'; ch <= 'Z'; ch++) {
            int tempK = k;
            int left = 0;
            int curr = 0;
            for(int right = 0; right < n; right++) {
                if(s.charAt(right) != ch) tempK--;
                while(tempK < 0) {
                    if(s.charAt(left) != ch) tempK++;
                    left++;
                }
                curr = Math.max(curr, right-left+1);
            }

            ans = Math.max(ans, curr);
        }

        return ans;
    }
}
