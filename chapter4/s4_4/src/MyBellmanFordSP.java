public class MyBellmanFordSP {
    private double[] disTo;
    private DirectedEdge[] edgeTo;
    private boolean[] onQ;
    private Queue<Integer> queue;
    private int cost;
    private Iterable<DirectedEdge> cycle;
    private EdgeWeightedDigraph G;
    private int s;
    public MyBellmanFordSP(EdgeWeightedDigraph G, int s)
    {
        this.G = G;
        this.s = s;
        disTo = new double[G.V()];
        for(int i = 0; i < G.V(); ++i)
            disTo[i] = Double.POSITIVE_INFINITY;
        edgeTo = new DirectedEdge[G.V()];
        onQ = new boolean[G.V()];
        queue = new Queue<Integer>();
        disTo[s] = 0.0;
        queue.enqueue(s);
        onQ[s] = true;
        while (!queue.isEmpty() && !this.hasNegativeCycle())
        {
            int v = queue.dequeue();
            onQ[v] = false;
            if(edgeTo[v]== null ||  !onQ[edgeTo[v].from()])
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
}
