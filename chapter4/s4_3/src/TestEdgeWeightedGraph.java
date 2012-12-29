/**
 * Created with IntelliJ IDEA.
 * User: dexctor
 * Date: 12-12-29
 * Time: 上午9:22
 * To change this template use File | Settings | File Templates.
 */
public class TestEdgeWeightedGraph {
    public static void main(String[] args)
    {
        EdgeWeightedGraph G = new EdgeWeightedGraph(new In("tinyEWG.txt"));
        StdOut.println(G);
    }
}
