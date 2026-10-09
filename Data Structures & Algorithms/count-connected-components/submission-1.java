class UnionFind{
    int[] parent;
    int[] rank;

    public UnionFind(int n){
        parent = new int[n];
        rank = new int[n];

        for(int i = 0; i < n; i++){
            parent[i] = i;
        }
    }

    public int find(int x){
        if(parent[x] != x){
            parent[x] = find(parent[x]);
        }

        return parent[x];
    }

    public boolean union(int a, int b){
        int rootA = find(a);
        int rootB = find(b);

        if(rootA == rootB){
            return false;
        }

        if(rank[rootA] < rank[rootB]){
            parent[rootA] = rootB;
        } else if (rank[rootB] < rank[rootA]){
            parent[rootB] = rootA;
        } else {
            parent[rootB] = rootA;
            rank[rootA]++;
        }
        return true;
    }
}

class Solution {
    public int countComponents(int n, int[][] edges) {
        UnionFind uf = new UnionFind(n);
        int count = n;

        for(int[] edge : edges){
            if(uf.union(edge[0], edge[1])){
                count--;
            }
        }

        return count;
    }
}
