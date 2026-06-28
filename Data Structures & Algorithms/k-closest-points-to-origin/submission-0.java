class Solution {
    private long distance(int x, int y) {
        return x*x + y*y;
    }
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<PointVal> pq = new PriorityQueue<>();
        int n = points.length;

        for(int point[]: points) {
            pq.offer(new PointVal(point[0], point[1], distance(point[0], point[1])));
            if(pq.size() > k) {
                pq.poll();
            }
        }

        int ans[][] = new int[k][2];
        for(int i=k-1; i>=0; i--) {
            PointVal top = pq.poll();
            ans[i][0] = top.x;
            ans[i][1] = top.y;
        }

        return ans;
    }
}

class PointVal implements Comparable<PointVal>{
    int x;
    int y;
    long dist;

    PointVal(int x, int y, long dist) {
        this.x = x;
        this.y = y;
        this.dist = dist;
    }

    @Override
    public int compareTo(PointVal point) {
        return Long.compare(point.dist, this.dist);
    }
}
