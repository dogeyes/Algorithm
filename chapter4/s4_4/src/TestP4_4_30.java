/**
 * Created with IntelliJ IDEA.
 * User: dexctor
 * Date: 13-1-2
 * Time: 下午8:07
 * To change this template use File | Settings | File Templates.
 */
public class TestP4_4_30 {
    public static void main(String[] args)
    {
        EdgeWeightedDigraph G;
        G = new EdgeWeightedDigraph(new In("tinyEWDn.txt"));
        int s = 0;
        p4_4_30 sp = new p4_4_30(G, s);

        if(!sp.hasNegativeCycle())
        {
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
        else
        {
            for(DirectedEdge e: sp.negativeCycle())
                StdOut.print(e +"  ");
            StdOut.println();
        }
        EdgeWeightedDigraph nonG = sp.nonNegativeGraph();
        StdOut.println(nonG);
        MyDijkstraSP sp1 = new MyDijkstraSP(nonG, s);
        for(int t = 0; t < nonG.V(); ++t)
        {
            StdOut.print(s + " to " + t);
            StdOut.printf(" (%4.2f): ", sp1.distTo(t));
            if(sp1.hasPathTo(t))
                for (DirectedEdge e: sp1.pathTo(t))
                    StdOut.print(e + "  ");
            StdOut.println();
        }
    }
}
