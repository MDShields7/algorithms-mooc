
public class QuizQ1Attempt {
    private int[] id;
    private int[][] friendship;
    // Each entry in friendship is an array with two ids
    private String[] log;
    // There is no Dates data type according to error thrown, so string was used.
    // For each item in friendship array, there will be a string in log array that corresponds.
    
    public QuizQ1Attempt(int N) {
        id = new int[N];
        for ( int i = 0; i < N; i++) id[i] = i;
    }
    private int root ( int i ) {
        while ( i != id[i] ) {
        id[i] = id[id[i]];
        i = id[i];
        }
        return i;
    }
    public boolean connected ( int p, int q ){
        return root(p) == root(q);
    }
    public void unionFriends(){
        // Assumes friendship array is sorted
        for ( int i = 0 ; i < friendship.length; i++){
            connected(friendship[i][0], friendship[i][1]);
        }
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