
public class Q3Attempt {
    private int nextRoot;
    private int prevRoot;
    // n equals root index

    private int[] next;
    private int[] prev;
    // n equals x + n (1 equals x + 1)
    // -1 equals removed
    // 0 equals self

    public Q3Attempt(int N) {
        nextRoot = N-1;
        prevRoot = 0;
        for ( int i = 0; i < N; i++ ) {
            if ( i == N ) {
                next[i] = 0;
            }
            if ( i < N ) {
                next[i] = 1;
            }
            if ( i == 0 ) {
                prev[i] = 0;
            }
            if ( i > N ) {
                prev[i] = 1;
            }
        }
    }

    // Array indexes are marked -1 on removal
    public void remove(int x) {
        if ( next[x] == -1 || prev[x] == -1 ) {
            return;
        } else if ( prevRoot == nextRoot ) {
            return;
        } else if ( next[x] == nextRoot ) {
            // the last successor item in list
            next[ x - prev[x] ] = 0;
            next[x] = -1;
        } else if ( prev[x] == prevRoot ) {
            // the last successor item in list
            prev[ x + next[x] ] = 0;
            prev[x] = -1;
        } else {
            int nextX = next[x];
            int prevX = prev[x];
            next[ x - prevX ] += nextX;
            prev[ x + nextX ] += prevX;
            next[x] = -1;
            prev[x] = -1;
        }
        prevRoot = prevRoot + next[x];
        nextRoot = nextRoot - prev[x];
    }
}

// EXAMPLE
// S =   { 0, 1, 2, 3}
// next    1, 1, 1, 0
// prev    0, 1, 1, 1
// nextroot = 3
// prevroot = 0
//   REMOVE S[1]
// nextX = 1, prevX = 1
// S =   { 0, 1, 2, 3}
// next    2,-1, 1, 0
// prev    0,-1, 2, 1
//   REMOVE S[2]
// S =   { 0, 1, 2, 3}
// nextX = 1, prevX = 2
// next    3,-1,-1, 0
// prev    0,-1,-1, 3   
//   REMOVE S[3]
// S =   { 0, 1, 2, 3}
// nextX = 0, prevX = 3
// next    3,-1,-1, 0
// prev    0,-1,-1, 3  