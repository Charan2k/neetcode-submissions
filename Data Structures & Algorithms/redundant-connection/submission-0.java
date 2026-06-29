class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        DSU dsu = new DSU(n);

        for(int edge[]: edges) {
            int u = edge[0];
            int v = edge[1];
            if(!dsu.union(u,v)) return new int[]{u,v};
        }

        return new int[]{-1,-1};
    }
}

class DSU {
    private int[] Parent, Size;
    public int comps; 

    public DSU(int n) {
        this.comps = n;
        Parent = new int[n + 1];
        Size = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            Parent[i] = i;
            Size[i] = 1;
        }
    }

    public int find(int node) {
        if (node != Parent[node]) {
            Parent[node] = find(Parent[node]);
        }
        return Parent[node];
    }

    public boolean union(int u, int v) {
        int pu = find(u);
        int pv = find(v);
        if (pu == pv) return false;
        if (Size[pu] >= Size[pv]) {
            Size[pu] += Size[pv];
            Parent[pv] = pu;
        } else {
            Size[pv] += Size[pu];
            Parent[pu] = pv;
        }
        comps--;
        return true;
    }
}
