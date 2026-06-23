class Solution {
    public int lengthOfLongestSubstring(String s) {
        int map[] = new int[257];
        int n = s.length();
        int left = 0;
        int ans = 0;
        for(int right = 0; right < n; right++) {
            char ch = s.charAt(right);
            map[ch]++;

            while(map[ch] >= 2) {
                map[s.charAt(left)]--;
                left++;
            }

            ans = Math.max(ans, right-left+1);
        }

        return ans;
    }
}
