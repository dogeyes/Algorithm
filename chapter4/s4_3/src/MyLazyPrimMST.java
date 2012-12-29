/**
 * Created with IntelliJ IDEA.
 * User: dexctor
 * Date: 12-12-29
 * Time: 上午9:42
 * To change this template use File | Settings | File Templates.
 */
public class MyLazyPrimMST {
    private EdgeWeightedGraph G;
    private Bag<Edge> edges;
    private MinPQ<Edge> pq;
    private boolean[] marked;
    private double weight;
    public MyLazyPrimMST(EdgeWeightedGraph G)
    {
        this.G = G;
        pq = new MinPQ<Edge>();
        edges = new Bag<Edge>();
        marked = new boolean[G.V()];
        mst();
    }
    private void mst()
    {
        visit(0);
        while (!pq.isEmpty())
        {
            Edge e = pq.delMin();
            int v = e.either();
            int w = e.other(v);
            if(marked[v] && marked[w])
                continue;
            edges.add(e);
            weight += e.weight();
            if(!marked[v])
            {
                visit(v);
            }
            if(!marked[w])
            {
                visit(w);
            }
        }
    }
    private void visit(int v)
    {
        marked[v] = true;
        for(Edge e:G.adj(v))
            if(!marked[e.other(v)])
                pq.insert(e);
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
