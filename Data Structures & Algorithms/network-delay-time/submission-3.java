class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        int MAXI = Integer.MAX_VALUE / 2;
        int distance[] = new int[n];
        for(int i=0; i<n; i++) {
            distance[i] = MAXI;
        }

        List<List<int[]>> graph = new ArrayList<>();
        for(int i=0; i<n; i++) {
            graph.add(new ArrayList<>());
        }

        for(int edge[]: times) {
            int u = edge[0] - 1;
            int v = edge[1] - 1;
            int t = edge[2];

            graph.get(u).add(new int[]{v, t});
        }

        boolean visited[] = new boolean[n];
        k = k-1;
        PriorityQueue<int[]> q = new PriorityQueue<>((a,b)->a[1]-b[1]);
        q.offer(new int[] {k, 0});
        distance[k] = 0;
        int ans = 0;
        while(!q.isEmpty()) {
            int curr[] = q.poll();
            int node = curr[0]; 
            int time = curr[1];
            if(visited[node]) continue;
            visited[node] = true;
            ans = time;
            for(int neighbour[]: graph.get(node)) {
               int neighbourNode = neighbour[0];
               int neighbourTime = neighbour[1];

               if(!visited[neighbourNode]) {
                q.offer(new int[]{neighbourNode, time + neighbourTime});
               }
            }
        }

        boolean allVisited = true;
        for(boolean val: visited) {
            allVisited = allVisited & val;
        }

        if(!allVisited) return -1;
        return ans;
    }
}

class Node {
    int v;
    int t;

    Node(int v, int t) {
        this.v = v;
        this.t = t;
    }
}
