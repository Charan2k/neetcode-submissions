class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->b-a);
        for(int num: stones) {
            pq.add(num);
        }
        while(!pq.isEmpty()) {
            int top = pq.peek();
            if(top == 0) {
                return 0;
            }
            int first = pq.poll();
            int second = 0;
            if(!pq.isEmpty()) {
                second = pq.poll();
                pq.add(Math.abs(first-second));
            }
            else {
                return first;
            }

        }
        return 0;
    }
}
