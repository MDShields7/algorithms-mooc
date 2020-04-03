
public class QuizQ1Attempt {
    private int[] id;
    private int[][] friendship;
    // Each entry in friendship is an array with two ids
    private Date[] log;
    
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
        for ( let i = 0 ; i < friendship.length; i++){
            connected(friendship[i][0], friendship[i][1]);
        }
    }
}