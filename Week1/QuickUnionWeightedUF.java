

public class QuickUnionWeightedUF  {
    private int[] id;
    private int[] size;
    private int count;
    
    public QuickUnionWeightedUF(int N) {
        count = N;
        id = new int[N];
        size = new int[N];
        for ( int i = 0; i < N; i++) {
            id[i] = i;
            size[i] = 1;
        }

    }
    
    public int count() {
        return count;
    }

    private int root ( int i ) {
        while ( i != id[i] ) {
            i = id[i];
        }
    return i;
    }

    public boolean connected ( int p, int q ) {
        return root(p) == root(q);
    }
    
    public void union ( int p, int q ) {
        int rootP = root(p);
        int rootQ = root(q);
        if ( rootP == rootQ ) return ;
        if ( size[p] < size[q]) {
            id[p] = q;
            size[q] += size[p];
        } else {
            id[q] = p;
            size[p] += size[q];
        }
        count--;
    }

    public static void main (String[] args) {
        int N = StdIn.readInt();
        WeightQuickUnion uf = new WeightedQuickUnionUF(N);

        while( !StdIn.isEmpty()) {
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            if ( uf.connected(p,q)) continue;
            uf.union(p,q);
            StdOut.println(p + " " + q);
        }
        StdOut.println( uf.count() + " component");
    }
}

// A Full Version found at https://github.com/gokmax/Algorithms/blob/master/union-Find/WeightedQuickUnionUF.java