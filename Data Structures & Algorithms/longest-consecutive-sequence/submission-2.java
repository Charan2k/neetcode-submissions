class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0) return 0;
        Set<Integer> set = new HashSet<>();
        for(int num: nums) {
            set.add(num);
        }

        int ans = 0;
        int n = nums.length;
        for(int i=0; i<n; i++) {
            if(!set.contains(nums[i])) continue;
            if(set.contains(nums[i]-1)) continue;

            int last = nums[i];
            int count = 0;
            while(set.contains(last)) {
                set.remove(last);
                count++;
                last = last+1;
            }

            ans = Math.max(ans, count);
        }
        return ans;
    }
}
