class Solution {
    private int N = 10001;
    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;
        Map<Integer,Integer> map = new HashMap<>();
        for(int num: nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        for(int key: map.keySet()) {
            pq.offer(new Pair(key, map.get(key)));
            if(pq.size() > k) {
                pq.poll();
            }
        }

        int ans[] = new int[k];
        int index = 0;
        while(index < k) {
            ans[index++] = pq.poll().val;
        }

        return ans;
    }
}

class Pair implements Comparable<Pair>{
    int val; int freq;

    public Pair(int val, int freq) {
        this.val = val;
        this.freq = freq;
    }

    @Override
    public int compareTo(Pair other) {
        return this.freq - other.freq;
    }
}
