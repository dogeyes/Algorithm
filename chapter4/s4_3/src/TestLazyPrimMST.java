/**
 * Created with IntelliJ IDEA.
 * User: dexctor
 * Date: 12-12-29
 * Time: 上午9:54
 * To change this template use File | Settings | File Templates.
 */
public class TestLazyPrimMST {
    public static void main(String[] args)
    {
        EdgeWeightedGraph G = new EdgeWeightedGraph(new In("mediumEWG.txt"));
        StdOut.println(G);
        MyLazyPrimMST mst = new MyLazyPrimMST(G);
        for(Edge e : mst.edges())
        {
            StdOut.println(e);
        }
        StdOut.println(mst.weight());
    }
}
