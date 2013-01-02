/**
 * Created with IntelliJ IDEA.
 * User: dexctor
 * Date: 13-1-2
 * Time: 下午7:59
 * To change this template use File | Settings | File Templates.
 */
public class p4_4_30 {
    private double[] disTo;
    private DirectedEdge[] edgeTo;
    private boolean[] onQ;
    private Queue<Integer> queue;
    private int cost;
    private Iterable<DirectedEdge> cycle;
    private double[] pi;
    private EdgeWeightedDigraph G;
    private int s;
    public p4_4_30(EdgeWeightedDigraph G, int s)
    {
        this.G = G;
        this.s = s;
        disTo = new double[G.V()];
        for(int i = 0; i < G.V(); ++i)
            disTo[i] = Double.POSITIVE_INFINITY;
        edgeTo = new DirectedEdge[G.V()];
        onQ = new boolean[G.V()];
        pi = new double[G.V()];
        for(int i = 0; i < G.V(); ++i)
            pi[i] = 0;
        queue = new Queue<Integer>();
        disTo[s] = 0.0;
        queue.enqueue(s);
        onQ[s] = true;
        while (!queue.isEmpty() && !this.hasNegativeCycle())
        {
            int v = queue.dequeue();
            relax(v);
            onQ[v] = false;
        }
    }
    private void relax(int v)
    {
        if(v == 7)
            StdOut.println(7);
        for(DirectedEdge e: G.adj(v))
        {
            int w = e.to();

           if(pi[w] < pi[v] - e.weight())
           {
               pi[w] = pi[v] - e.weight();
               if(!onQ[w])
               {
                   onQ[w] = true;
                   queue.enqueue(w);
               }
           }

            if(disTo[w] > disTo[v] + e.weight())
            {

                disTo[w] = disTo[v] + e.weight();
                edgeTo[w] = e;
                if(!onQ[w])
                {
                    onQ[w] = true;
                    queue.enqueue(w);
                }
            }
            if(cost++ % G.V() == 0)
                findNegativeCycle();
        }
    }
    private void findNegativeCycle()
    {
        int V = edgeTo.length;
        EdgeWeightedDigraph spt = new EdgeWeightedDigraph(V);
        for(int v = 0; v < V; ++v)
        {
            if(edgeTo[v] != null)
                spt.addEdge(edgeTo[v]);
        }
        EdgeWeightedDirectedCycle cf = new EdgeWeightedDirectedCycle(spt);

        cycle = cf.cycle();
    }
    public boolean hasNegativeCycle()
    {
        return cycle != null;
    }
    public Iterable<DirectedEdge> negativeCycle()
    {
        return cycle;
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
    public EdgeWeightedDigraph nonNegativeGraph()
    {
        EdgeWeightedDigraph reG = new EdgeWeightedDigraph(G.V());
        for(DirectedEdge e: G.edges())
            reG.addEdge(new DirectedEdge(e.from(), e.to(), e.weight() + pi[e.to()] - pi[e.from()]));

        return reG;
    }
}
