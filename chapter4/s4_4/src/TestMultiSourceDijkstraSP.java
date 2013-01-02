/**
 * Created with IntelliJ IDEA.
 * User: dexctor
 * Date: 13-1-2
 * Time: 下午6:55
 * To change this template use File | Settings | File Templates.
 */
public class TestMultiSourceDijkstraSP {
    public static void main(String[] args)
    {
        EdgeWeightedDigraph G = new EdgeWeightedDigraph(new In("tinyEWD.txt"));
        StdOut.print();

        Bag<Integer> sources = new Bag<Integer>();
        In sin = new In("sources.txt");
        In tin = new In("t.txt");
        while (!sin.isEmpty())
        {
            int v = sin.readInt();
            sources.add(v);
        }
        MultiSourceDijkstraSP sp = new MultiSourceDijkstraSP(G, sources);
        for(int v = 0; v < G.V(); ++v)
        {
            StdOut.print(v + " " + sp.distTo(v) + "   : ");
            for(DirectedEdge e : sp.pathTo(v))
                StdOut.print(e + "   ");
            StdOut.println();
        }
        double min = Double.POSITIVE_INFINITY;
        while (!tin.isEmpty())
        {
            int t = tin.readInt();
            if(sp.distTo(t) < min)
                min = sp.distTo(t);
        }
        StdOut.println(min);
    }
}
