/**
 * Created with IntelliJ IDEA.
 * User: dexctor
 * Date: 12-12-29
 * Time: 上午10:22
 * To change this template use File | Settings | File Templates.
 */
public class MyKruskalMST {
    private MinPQ<Edge> pq;
    private UF uf;
    private EdgeWeightedGraph G;
    private boolean[] marked;
    private double weight;
    private Bag<Edge> edges;
    public MyKruskalMST(EdgeWeightedGraph G)
    {
        this.G = G;
        marked = new boolean[G.V()];
        edges = new Bag<Edge>();
        pq = new MinPQ<Edge>();
        for(Edge e: G.edges())
            pq.insert(e);
        uf = new UF(G.V());
        while (!pq.isEmpty() && edges.size() < G.V() - 1)
        {
            Edge e = pq.delMin();
            int v = e.either();
            int w = e.other(v);
            if(uf.connected(w,v))
                continue;
            uf.union(w,v);
            edges.add(e);
            weight += e.weight();
        }
    }
    public Iterable<Edge> edges()
    {
        return edges;
    }
    public double weight()
    {
        return weight;
    }
}
