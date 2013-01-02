/**
 * Created with IntelliJ IDEA.
 * User: dexctor
 * Date: 13-1-2
 * Time: 下午7:32
 * To change this template use File | Settings | File Templates.
 */
public class TestMatrixSP {
    public static void main(String[] args)
    {
        EdgeWeightedMatrixDigraph G;
        G = new EdgeWeightedMatrixDigraph(new In("tinyEWD.txt"));
        int s = 0;
        MaxtrixSP sp = new MaxtrixSP(G, s);

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
