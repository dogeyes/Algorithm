/**
 * Created with IntelliJ IDEA.
 * User: dexctor
 * Date: 12-12-29
 * Time: 下午2:24
 * To change this template use File | Settings | File Templates.
 */
public class MatrixEdgeWeightedGraph {
    private double[][] adj;
    private int V;
    private int E;
    public MatrixEdgeWeightedGraph(int V)
    {
        this.V = V;
        adj = new double[V][V];
        for(int i = 0; i < V; ++ i)
        {
            for(int j = 0; j < V; ++j)
                adj[i][j] = Double.POSITIVE_INFINITY;
        }
    }
    public MatrixEdgeWeightedGraph(In in)
    {
        this(in.readInt());
        int E = in.readInt();
        for(int i = 0; i < E; ++i)
        {
            int v = in.readInt();
            int w = in.readInt();
            double weight = in.readDouble();
            addEdge(v, w, weight);
        }
    }
    public void addEdge(int v, int w, double weight)
    {
        E++;
        adj[v][w] = weight;
        adj[w][v] = weight;
    }
    public  int V()
    {
        return V;
    }
    public int E()
    {
        return E;
    }
    public Iterable<Edge> adj(int v)
    {
        Bag<Edge> edges = new Bag<Edge>();
        for(int i = 0; i < V; ++i)
        {
            if(adj[v][i] < Double.POSITIVE_INFINITY)
                edges.add(new Edge(v, i, adj[v][i]));
        }
        return edges;
    }
    public Iterable<Edge> edges()
    {
        Bag<Edge> allEdge = new Bag<Edge>();
        for(int v = 0; v < V(); ++v)
        {
            for(int w = 0; w < V(); ++w)
                if(adj[v][w] < Double.POSITIVE_INFINITY)
                    allEdge.add(new Edge(v,w, adj[v][w]));
        }
        return allEdge;
    }
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        for(int v = 0; v < V(); ++v)
        {
            sb.append(v + " :\n");
            for(Edge e: adj(v))
                sb.append("    " + e + "\n");
        }
        return sb.toString();
    }
}
