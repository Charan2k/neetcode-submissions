class Solution {
    public int leastInterval(char[] tasks, int n) {
        int freq[] = new int[26];
        int maxi = 0;
        for(char task: tasks) {
            freq[task-'A']++;
            maxi = Math.max(maxi, freq[task-'A']);
        }

        int maxCount = 0;
        for(int count: freq) {
            if(count == maxi) maxCount++;
        }

        int time = (maxi - 1) * (n + 1) + maxCount;
        return Math.max(tasks.length, time);

    }
}
