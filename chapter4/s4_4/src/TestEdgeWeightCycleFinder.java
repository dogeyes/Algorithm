/**
 * Created with IntelliJ IDEA.
 * User: dexctor
 * Date: 13-1-2
 * Time: 下午1:36
 * To change this template use File | Settings | File Templates.
 */
public class TestEdgeWeightCycleFinder {
    public static void main(String[] args)
    {
        EdgeWeightedDigraph G = new EdgeWeightedDigraph(new In("tinyEWD1.txt"));
        StdOut.println(G);
        EdgeWeightedCycleFinder cycleFinder = new EdgeWeightedCycleFinder(G);
        if(cycleFinder.hasCycle())
        {
            for(DirectedEdge e: cycleFinder.cycle())
                StdOut.print(e + " ");
            StdOut.println();
        }
        else
            StdOut.println("No cycle");
    }
}
