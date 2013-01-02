/**
 * Created with IntelliJ IDEA.
 * User: dexctor
 * Date: 13-1-2
 * Time: 下午9:45
 * To change this template use File | Settings | File Templates.
 */
public class LazyDijkstraSP {
    private EdgeWeightedDigraph G;
    private double[] disTo;
    private DirectedEdge[] edgeTo;
    private MinPQ<Pack> pq;
    private boolean[] marked;
    private int source;
    private class Pack implements Comparable<Pack>
    {
        double disTo;
        int p;
        public Pack(int p, double disTo)
        {
            this.p = p;
            this.disTo = disTo;
        }
        public int compareTo(Pack other)
        {
            if(disTo > other.disTo)
                return  1;
            if(disTo < other.disTo)
                return - 1;
            return 0;
        }

    }
    public LazyDijkstraSP(EdgeWeightedDigraph G, int s)
    {
        source = s;
        this.G = G;
        disTo = new double[G.V()];
        edgeTo = new DirectedEdge[G.V()];
        marked = new boolean[G.V()];
        pq = new MinPQ<Pack>();

        for(int i = 0; i < G.V(); ++i)
            disTo[i] = Double.POSITIVE_INFINITY;
        disTo[source] = 0;
        pq.insert(new Pack(source, distTo(source)));
        while(!pq.isEmpty())
        {
            Pack v = pq.delMin();
            if(!marked[v.p])
            {
                relax(v.p);
                marked[v.p] = true;
            }
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
                pq.insert(new Pack(w,distTo(w)));
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
