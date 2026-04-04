package DSAPractice.DisJointSetUnion;

public class DSU {
    public int [] rank;
    public int [] parent;
    public DSU(int n) {
        rank = new int[n];
        parent = new int[n];
        for(int i = 0; i < n; i++) {
            rank[i] = 0;
            parent[i] = i;
        }
    }
    public int find(int x) {
        if(x != parent[x]) {
            return find(parent[x]);
        }
        return x;
    }
    public Boolean findUnion(int x, int y) {
       int u =  find(x);
       int v =  find(y);
       if(v != y || u == v) return false;
       if(rank[u] >= rank[v]) {
           parent[v] = u;
           rank[u]++;
       }else {
           parent[u] = v;
           rank[v]++;
       }
       return true;
    }
}
