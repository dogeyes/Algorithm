/**
 * Created with IntelliJ IDEA.
 * User: dexctor
 * Date: 13-1-2
 * Time: 上午9:00
 * To change this template use File | Settings | File Templates.
 */
public class MultiSourceDijkstraSP {
    private EdgeWeightedDigraph G;
    private double[] disTo;
    private DirectedEdge[] edgeTo;
    private IndexMinPQ<Double> pq;
    private int source;
    public MultiSourceDijkstraSP(EdgeWeightedDigraph G, Iterable<Integer> sources)
    {
        this.G = G;
        disTo = new double[G.V()];
        edgeTo = new DirectedEdge[G.V()];
        pq = new IndexMinPQ<Double>(G.V());

        for(int i = 0; i < G.V(); ++i)
            disTo[i] = Double.POSITIVE_INFINITY;

        for(int i : sources)
        {
            disTo[i] = 0.0;
            pq.insert(i, disTo[i]);
        }
        while(!pq.isEmpty())
        {
            int v = pq.delMin();
            relax(v);
        }
    }
    public MultiSourceDijkstraSP(EdgeWeightedDigraph G, int s)
    {
        source = s;
        this.G = G;
        disTo = new double[G.V()];
        edgeTo = new DirectedEdge[G.V()];
        pq = new IndexMinPQ<Double>(G.V());

        for(int i = 0; i < G.V(); ++i)
            disTo[i] = Double.POSITIVE_INFINITY;
        disTo[source] = 0;
        pq.insert(source, disTo[source]);
        while(!pq.isEmpty())
        {
            int v = pq.delMin();
            relax(v);
        }
    }
    private void relax(int v)
    {
        for(DirectedEdge e: G.adj(v))
        {
            int w = e.to();
            if(disTo[w] > disTo[v] + e.weight())
            {
                disTo[w] = disTo[v] + e.weight();
                edgeTo[w] = e;
                if(!pq.contains(w))
                    pq.insert(w, disTo[w]);
                else
                    pq.changeKey(w, disTo[w]);
            }
        }
    }

    public double distTo(int v)
    {
        return disTo[v];
    }
    public boolean hasPathTo(int v)
    {
        return disTo[v] != Double.POSITIVE_INFINITY;
    }
    public Iterable<DirectedEdge> pathTo(int v)
    {
        Stack<DirectedEdge> stack = new Stack<DirectedEdge>();
        while (edgeTo[v] != null)
        {
            stack.push(edgeTo[v]);
            v = edgeTo[v].from();
        }
        return stack;
    }
}
