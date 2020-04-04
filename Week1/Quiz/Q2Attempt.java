// The largest[] acts as a tree as well. But for a group of numbers all sharing the same root, they will all also share 1 numbers under their largest[#]. It basically forms another data stree with a depth of two. 1 layer is the root, the 2nd layer is every other number in that group.

class Q2Attempt {
    private int[] id;
    private int[][] timestamps;
    // Each entry in friendship is an array with two ids
    private int[] size;
    private int[] largest;
    private int count;

    public Q2Attempt(int N) {
        id = new int[N];
        for ( int i = 0; i < N; i++) {
            id[i] = i;
            size[i] = 1;
            largest[i] = i;
        }
    }

    public int count () {
        return count;
    }

    public int find( int i) {
        return largest[i];
    }

    private int root ( int i ) {
        while ( i != id[i] ) {
            // id[i] = id[id[i]];
            i = id[i];
        }
        return i;
    }
    public boolean connected ( int p, int q ){
        return root(p) == root(q);
    }
    public void union( int p, int q ){
        int rootP = root(p);
        int rootQ = root(q);
        if ( rootP == rootQ ){
            return;
        }
        if ( size[p] < size[q] ){
            id[p] = q;
            size[q] += size[q];
        } else  {
            id[q] = p;
            size[p] += size[q];
        }
        if ( largest[p] < largest[q]){
            largest[p] = largest[q];
        } else {
            largest[q] = largest[p];
        }
        count--;
    }
    public int checkConnections () {
        int i = 0; 
        while ( count > 1 ) {
            union( timestamps[i][0], timestamps[i][1]);
            i++;
        }
        int time = i-1;
        return time;
    }

    // public static void main (String[] args) {
    //     int N = StdIn.readInt();
    //     WeightQuickUnion uf = new WeightedQuickUnionUF(N);

    //     while( !StdIn.isEmpty()) {
    //         int p = StdIn.readInt();
    //         int q = StdIn.readInt();
    //         if ( uf.connected(p,q)) continue;
    //         uf.union(p,q);
    //         StdOut.println(p + " " + q);
    //     }
    //     StdOut.println( uf.count() + " component");
    // }
}
