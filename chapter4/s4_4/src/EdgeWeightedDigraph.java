import com.sun.org.apache.xalan.internal.xsltc.dom.NodeIteratorBase;

/**
 * Created with IntelliJ IDEA.
 * User: dexctor
 * Date: 13-1-2
 * Time: 上午8:38
 * To change this template use File | Settings | File Templates.
 */
public class EdgeWeightedDigraph {
    private int V;
    private int E;
    private Bag<DirectedEdge>[] adj;

    public EdgeWeightedDigraph(int V)
    {
        this.V = V;
        adj = new Bag[V];
        for(int i = 0;i < V();++i)
        {
            adj[i] = new Bag<DirectedEdge>();
        }
    }
    public EdgeWeightedDigraph(In in)
    {
        this(in.readInt());
        int E = in.readInt();
        for(int i = 0;i < E;++i)
        {
            int v = in.readInt();
            int w = in.readInt();
            double weight = in.readDouble();
            addEdge(new DirectedEdge(v, w, weight));
        }
    }

    public int V()
    {
        return V;
    }
    public int E()
    {
        return E;
    }
    public void addEdge(DirectedEdge e)
    {
        int v = e.from();
        adj[v].add(e);
        E++;
    }
    public Iterable<DirectedEdge> adj(int v)
    {
        return adj[v];
    }
    public Iterable<DirectedEdge> edges()
    {
        Bag<DirectedEdge> edgeBag = new Bag<DirectedEdge>();
        for(int i = 0; i < V(); ++i)
        {
            for(DirectedEdge e : adj(i))
                edgeBag.add(e);
        }
        return edgeBag;
    }
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        for(int v = 0; v < V(); ++v)
        {
            sb.append(v + " : \n");
            for(DirectedEdge e: adj(v))
                sb.append("    "  + e + "\n");
        }
        return sb.toString();
    }
}
