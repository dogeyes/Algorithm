/**
 * Created with IntelliJ IDEA.
 * User: dogeyes
 * Date: 13-1-16
 * Time: 上午10:26
 * To change this template use File | Settings | File Templates.
 */
public class FlowNetwork {
    private Bag<FlowEdge>[] adj;
    private int V;
    private int W;

    public FlowNetwork(int v)
    {
        this.V = v;
        adj = new Bag[v];
        for(int i = 0; i < v; ++i)
            adj[i] = new Bag<FlowEdge>();
    }

    public FlowNetwork(In in)
    {
        this(in.readInt());
        int W = in.readInt();
        for(int i = 0; i < W; ++i)
        {
            int v = in.readInt();
            int w = in.readInt();
            double cap = in.readDouble();
            addEdge(v,w, cap);
        }
    }

    public void addEdge(int v, int w, double capacity)
    {
        adj[v].add(new FlowEdge(v, w, capacity));
        W++;
    }
    public int V()
    {
        return V;
    }
    public int W()
    {
        return W;
    }
    public Iterable<FlowEdge> adj(int v)
    {
        return adj[v];
    }

    public String toString()
    {
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < V(); ++i)
        {
            sb.append(i + ": \n");
            for(FlowEdge e: adj(i)){
                sb.append("    " + e  + "\n");
            }
        }
        return sb.toString();
    }
}
