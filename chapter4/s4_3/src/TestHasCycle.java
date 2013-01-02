/**
 * Created with IntelliJ IDEA.
 * User: daixing
 * Date: 12-12-29
 * Time: 下午9:52
 * To change this template use File | Settings | File Templates.
 */
public class TestHasCycle {
    public static void main(String[] args)
    {
        EdgeWeightedGraph G = new EdgeWeightedGraph(new In("tinyEWG.txt"));
        KruskalMST mst = new KruskalMST(G);
        EdgeWeightedGraph mstG = new EdgeWeightedGraph(G.V());
        for(Edge e: mst.edges())
        {
            mstG.addEdge(e);
        }
        Cycle cycle1 = new Cycle(G);
        StdOut.println(cycle1.hasCycle());
        Cycle cycle2 = new Cycle(mstG);
        StdOut.println(cycle2.hasCycle());
    }
}
