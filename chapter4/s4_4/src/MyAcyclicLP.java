/**
 * Created with IntelliJ IDEA.
 * User: dexctor
 * Date: 13-1-2
 * Time: 上午9:26
 * To change this template use File | Settings | File Templates.
 */
public class MyAcyclicLP {
    private DirectedEdge[] edgeTo;
    private double[] disTo;
    private EdgeWeightedDigraph G;
    private int s;

    public MyAcyclicLP(EdgeWeightedDigraph G, int s)
    {
        this.G = G;
        this.s = s;
        edgeTo = new DirectedEdge[G.V()];
        disTo = new double[G.V()];
        for(int i = 0; i < G.V(); ++i)
            disTo[i] = Double.NEGATIVE_INFINITY;
        disTo[s] = 0.0;
        Topological top = new Topological(G);
        for(int v : top.order())
        {
            relax(v);
        }
    }
    private void relax(int v)
    {
        for(DirectedEdge e: G.adj(v))
        {
            int w = e.to();
            if(disTo[w] < disTo[v] + e.weight())
            {
                disTo[w] = disTo[v] + e.weight();
                edgeTo[w] = e;
            }
        }
    }
    public double distTo(int v)
    {
        return disTo[v];
    }
    public boolean hasPathTo(int v)
    {
        return disTo[v] != Double.NEGATIVE_INFINITY;
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
