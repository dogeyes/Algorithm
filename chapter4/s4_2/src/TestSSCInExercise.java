/**
 * Created with IntelliJ IDEA.
 * User: dexctor
 * Date: 12-12-27
 * Time: 下午4:21
 * To change this template use File | Settings | File Templates.
 */
public class TestSSCInExercise {
    public static void main(String[] args)
    {
        MyDigraph G = new MyDigraph(new In("tinyDG.txt"));
        StdOut.println(G);

        SSCInExercise ssc = new SSCInExercise(G, 0);
        for(int i : ssc.ssc())
            StdOut.print(i + " ");
        StdOut.println();
        boolean[] marked = new boolean[G.V()];
        int count = 0;
        for(int i = 0; i < G.V(); ++i)
        {
            if(!marked[i])
            {
                ssc = new SSCInExercise(G, i);
                for(int v : ssc.ssc())
                {
                    marked[v] = true;
                    StdOut.print(v + " ");
                }
                StdOut.println();
            }
        }
    }
}
