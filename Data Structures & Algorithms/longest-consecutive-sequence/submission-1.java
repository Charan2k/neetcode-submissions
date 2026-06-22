class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0) return 0;
        Set<Integer> set = new HashSet<>();
        for(int num: nums) {
            set.add(num);
        }
        List<Integer> list = new ArrayList<>(set);
        Collections.sort(list);
        int n = list.size();
        int count = 1;
        int ans = 0;
        for(int i=1; i<n; i++) {
            if(list.get(i) == list.get(i-1) + 1) count++;
            else {
                ans = Math.max(ans, count);
                count = 1;
            }
        }

        ans = Math.max(ans, count);
        return ans;
    }
}
