class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0; i<numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        int indegree[] = new int[numCourses];
        for(int prereq[]: prerequisites) {
            int u = prereq[0];
            int v = prereq[1];
            graph.get(v).add(u);
            indegree[u]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i=0; i<numCourses; i++) {
            if(indegree[i] == 0) queue.offer(i); 
        }

        List<Integer> topo = new ArrayList<>();
        while(!queue.isEmpty()) {
            int node = queue.poll();
            topo.add(node);
            for(int neigh: graph.get(node)) {
                indegree[neigh]--;
                if(indegree[neigh] == 0) queue.offer(neigh);
            }
        }

        for(int i: topo) {
            System.out.print(i + ", ");
        }
        System.out.println();

        return topo.size() == numCourses;
    }
}
