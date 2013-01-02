import com.sun.org.apache.xalan.internal.res.XSLTErrorResources_pt_BR;

/**
 * Created with IntelliJ IDEA.
 * User: dexctor
 * Date: 13-1-2
 * Time: 上午10:49
 * To change this template use File | Settings | File Templates.
 */
public class MyArbitrage {
    public static void main(String[] args)
    {
        In in = new In("rates.txt");
        int V = in.readInt();
        String[] name = new String[V];
        EdgeWeightedDigraph G = new EdgeWeightedDigraph(V);
        for(int v = 0; v < V; ++v)
        {
            name[v] = in.readString();
            for(int w = 0; w < V; ++w)
            {
                double rate = in.readDouble();
                DirectedEdge e = new DirectedEdge(v, w, -Math.log(rate));
                G.addEdge(e);
            }
        }
        MyBellmanFordSP sp = new MyBellmanFordSP(G, 0);
        if(sp.hasNegativeCycle())
        {
            double stake = 1000.0;
            for(DirectedEdge e: sp.negativeCycle())
            {
                StdOut.printf("%10.5f %s ", stake, name[e.from()]);
                stake *= Math.exp(-e.weight());
                StdOut.printf(" = %10.5f %s\n", stake, name[e.to()]);
            }
        }
        else
            StdOut.println("No arbitrage opportunity");
    }
}
