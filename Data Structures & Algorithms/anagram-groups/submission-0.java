class Solution {
    private boolean equal(String s, String t) {
        char str[] = s.toCharArray();
        char ttr[] = t.toCharArray();

        Arrays.sort(str); Arrays.sort(ttr);

        return new String(str).equals(new String(ttr));
    }
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        int n = strs.length;

        boolean visited[] = new boolean[n];
        for(int i=0; i<n; i++) {
            if(visited[i]) continue;

            visited[i] = true;
            List<String> curr = new ArrayList<>();
            curr.add(strs[i]);

            for(int j=i+1; j<n; j++) {
                if(equal(strs[i], strs[j])){
                    visited[j] = true;
                    curr.add(strs[j]);
                }
            }

            ans.add(curr);
        }

        return ans;
    }
}
