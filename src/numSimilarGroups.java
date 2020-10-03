class numSimilarGroups {
    UnionFind uf;
    public int numSimilarGroups(String[] A) {

        uf = new UnionFind(A.length);

        for(int i = 0; i <  A.length - 1; i++)
            for(int j = i+1; j < A.length; j++)
                if(isSimilar(A[i] , A[j]))
                {
                    uf.union(i, j);
                    if(uf.result == 1)
                        return 1;
                }
        return uf.result;
    }
    private class UnionFind{
        int [] parent;
        int result;
        public UnionFind(int n)
        {
            parent = new int[n];
            for(int i = 0; i < n; i++)
                parent[i] = i;
            result = n;
        }

        public void union(int i, int j)
        {
            int p1 = find(i);
            int p2 = find(j);
            if(p1 == p2)
                return;
            parent[p2] = p1;
            result--;
        }

        public int find(int x)
        {
            if(parent[x] == x)
                return x;
            parent[x] = find(parent[x]);
            return parent[x];
        }
    }
    boolean isSimilar(String a, String b)
    {
        int n = 0;
        for(int i = 0; i < a.length(); i++)
            if(a.charAt(i) != b.charAt(i) && ++n==3)
                return false;
        return true;
    }
}