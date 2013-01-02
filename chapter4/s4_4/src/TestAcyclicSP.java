/**
 * Created with IntelliJ IDEA.
 * User: dexctor
 * Date: 13-1-2
 * Time: 上午9:33
 * To change this template use File | Settings | File Templates.
 */
public class TestAcyclicSP {
    public static void main(String[] args)
    {
        EdgeWeightedDigraph G;
        G = new EdgeWeightedDigraph(new In("tinyEWDAG.txt"));
        int s = 5;
        MyAcyclicSP sp = new MyAcyclicSP(G, s);

        for(int t = 0; t < G.V(); ++t)
        {
            StdOut.print(s + " to " + t);
            StdOut.printf(" (%4.2f): ", sp.distTo(t));
            if(sp.hasPathTo(t))
                for (DirectedEdge e: sp.pathTo(t))
                    StdOut.print(e + "  ");
            StdOut.println();
        }
    }
}
