/**
 * Created with IntelliJ IDEA.
 * User: dexctor
 * Date: 13-1-2
 * Time: 上午8:45
 * To change this template use File | Settings | File Templates.
 */
public class TestEdgeWeightedDigraph {
    public static void main(String[] args)
    {
        EdgeWeightedDigraph G = new EdgeWeightedDigraph(new In("tinyEWD.txt"));
        StdOut.println(G);
    }
}
