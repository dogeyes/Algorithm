/**
 * Created with IntelliJ IDEA.
 * User: dexctor
 * Date: 12-12-29
 * Time: 上午9:05
 * To change this template use File | Settings | File Templates.
 */
public class EdgeWeightedGraph {
    private int V;
    private int E;
    private Bag<Edge>[] adj;
    public EdgeWeightedGraph(int V)
    {
        this.V = V;
        adj = new Bag[V];
        for(int i = 0; i < V(); ++i)
        {
            adj[i] = new Bag<Edge>();
        }
    }
    public EdgeWeightedGraph(In in)
    {
        this(in.readInt());
        int E = in.readInt();
        for(int i = 0; i < E; ++i)
        {
            int v = in.readInt();
            int w = in.readInt();
            double weight = in.readDouble();
            addEdge(new Edge(v, w, weight));
        }
    }
    public void addEdge(Edge e)
    {
        int v = e.either();
        int w = e.other(v);
        adj[v].add(e);
        adj[w].add(e);
        E++;
    }
    public Iterable<Edge> adj(int v)
    {
        return adj[v];
    }
    public int V()
    {
        return V;
    }
    public int E()
    {
        return E;
    }
    public Iterable<Edge> edges()
    {
        Bag<Edge> edges = new Bag<Edge>();
        for(int i = 0; i < V(); ++i)
        {
            for(Edge e: adj(i))
            {
                if(i < e.other(i))
                    edges.add(e);
            }
        }
        return edges;
    }
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < V(); ++i)
        {
            sb.append(i + ": \n");
            for(Edge e: adj(i))
                sb.append("     " + e + "\n");
        }
        return sb.toString();
    }
}
