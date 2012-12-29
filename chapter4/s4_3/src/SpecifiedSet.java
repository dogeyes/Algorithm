/**
 * Created with IntelliJ IDEA.
 * User: daixing
 * Date: 12-12-29
 * Time: 下午9:04
 * To change this template use File | Settings | File Templates.
 */
public class SpecifiedSet {
    private UF uf;
    private MinPQ<Edge> pq;
    private EdgeWeightedGraph G;
    private Bag<Edge> edges;
    private double weight;
    public SpecifiedSet(EdgeWeightedGraph G, Iterable<Edge> edgeSet)
    {
        this.G = G;
        edges = new Bag<Edge>();
        uf = new UF(G.V());
        pq = new MinPQ<Edge>();
        for(Edge e: G.edges())
        {
            pq.insert(e);
        }
        for(Edge e: edgeSet)
        {
            edges.add(e);
            int v = e.either();
            int w = e.other(v);
            uf.union(v,w);
            weight += e.weight();
        }
        while (!pq.isEmpty() && edges.size() < G.V() - 1)
        {
            Edge e = pq.delMin();
            int v = e.either();
            int w = e.other(v);
            if(uf.connected(v, w))
                continue;
            uf.union(v, w);
            edges.add(e);
            weight += e.weight();
        }

    }
    public double weight()
    {
        return weight;
    }
    public Iterable<Edge> edges()
    {
        return edges;
    }
}
