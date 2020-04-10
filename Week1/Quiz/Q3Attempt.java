
public class Q3Attempt {
    private int[] id;
    private int[] prev;

    public Q3Attempt(int N) {
        id = new int[N];
        for ( int i = 0; i < N; i++ ) {
            if ( i == N ) {
                id[i] = i;
            }
            if ( i < N ) {
                id[i] = i + 1;
            }
            if ( i == 0 ) {
                prev[i] = i;
            }
            if ( i > N ) {
                prev[i] = i - 1;
            }
        }
    }

    // How do arrays or lists work in java?...
    public void remove(int x) {
        int xMinus = x - 1;
        int xPlus = x + 1;
        if ( id[x] == null) {
            return;
        }
        if ( id[x] == x ) {
            id[xMinus] = xMinus;
        }
        if ( prev[x] == 0 ) {
            prev[xPlus] = xPlus;
        }
        
    }

    private int next(int x) {
        return id[x];
    }

    // private int root ( int i ) {
    //     while ( i != id[i] ) {
    //         // id[i] = id[id[i]];
    //         i = id[i];
    //     }
    //     return i;
    // }

    // public void union( int p, int q ){
    
    // }
}