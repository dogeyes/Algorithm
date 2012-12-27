/**
 * Created with IntelliJ IDEA.
 * User: dexctor
 * Date: 12-12-26
 * Time: 下午9:19
 * To change this template use File | Settings | File Templates.
 */
public class TestMyDigraph {
    public static void main(String[] args)
    {
        MyDigraph G = new MyDigraph(new In("tinyDG.txt"));
        MyDigraph G2 = new MyDigraph(G);
        G2.addEdge(0, G2.V() - 1);
        StdOut.println(G);
        StdOut.println(G2);
        MyDegrees degrees = new MyDegrees(G);
        for(int i =0; i < G.V(); ++i)
        {
            StdOut.print(degrees.indegree(i) + ":" + degrees.outdegree(i) + " ");
        }
        StdOut.println();
        for(int i : degrees.soucrces())
            StdOut.print(i + " ");
        StdOut.println();
        for(int i : degrees.sinks())
            StdOut.print(i + " ");
    }
}
