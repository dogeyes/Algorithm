/**
 * Created with IntelliJ IDEA.
 * User: dexctor
 * Date: 12-12-29
 * Time: 上午10:04
 * To change this template use File | Settings | File Templates.
 */
public class MyPrimMST {
    private IndexMinPQ<Double> pq;
    private EdgeWeightedGraph G;
    private double[] disTo;
    private boolean[] marked;
    private int[] edgeTo;
    private double weight;
    private Bag<Edge> edges;
    public MyPrimMST(EdgeWeightedGraph G)
    {
        this.G = G;
        pq = new IndexMinPQ<Double>(G.V());
        disTo = new double[G.V()];
        edges = new Bag<Edge>();
        for(int i = 0; i < G.V(); ++i)
            disTo[i] = Double.POSITIVE_INFINITY;
        edgeTo = new int[G.V()];
        marked = new boolean[G.V()];
        disTo[0] = 0.0;
        visit(0);
        while (!pq.isEmpty())
        {
            int v = pq.delMin();
            weight += disTo[v];
            edges.add(new Edge(v, edgeTo[v], disTo[v]));
            visit(v);
        }
    }
    public void visit(int v)
    {
        marked[v] = true;
        for(Edge e: G.adj(v))
        {
            int w = e.other(v);
            if(marked[w])
                continue;
            if(disTo[w] > e.weight())
            {
                disTo[w] = e.weight();
                if(!pq.contains(w))
                {
                    pq.insert(w, e.weight());
                }
                else
                    pq.changeKey(w, e.weight());
                edgeTo[w] = v;
            }
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
