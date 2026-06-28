class KthLargest {
    private PriorityQueue<Integer> pq;
    private int k;
    private int nums[];
    public KthLargest(int k, int[] nums) {
        pq = new PriorityQueue<>();
        this.k = k;
        for(int num: nums) {
            if(pq.size() >= k) {
                int top = pq.peek();
                if(num >= top) {
                    pq.poll();
                    pq.offer(num);
                }
            }
            else pq.offer(num);
        }

    }
    
    public int add(int val) {
        if(pq.size() >= k) {
            int top = pq.peek();
            if(val > top) {
                pq.poll();
                pq.offer(val);
            }
        }   
        else pq.offer(val);

        return pq.peek();
    }

}
