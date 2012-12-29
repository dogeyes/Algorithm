/**
 * Created with IntelliJ IDEA.
 * User: dexctor
 * Date: 12-12-29
 * Time: 上午10:20
 * To change this template use File | Settings | File Templates.
 */
public class TestPrimMST {
    public static void main(String[] args)
    {
        EdgeWeightedGraph G = new EdgeWeightedGraph(new In("tinyEWG1.txt"));
        StdOut.println(G);
        MyPrimMST mst = new MyPrimMST(G);
        for(Edge e : mst.edges())
        {
            StdOut.println(e);
        }
        StdOut.println(mst.weight());
    }
}
