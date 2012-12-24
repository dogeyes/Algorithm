/**
 * Created with IntelliJ IDEA.
 * User: dexctor
 * Date: 12-12-24
 * Time: 下午8:42
 * To change this template use File | Settings | File Templates.
 */
public class MyGraph {
    private int V;
    private int E;
    private Bag<Integer>[] adj;
    public MyGraph(int V)
    {
        this.E = 0;
        this.V = V;
        adj =(Bag<Integer>[]) new Bag[V];
        for(int i = 0; i < V; ++i)
            adj[i] = new Bag<Integer>();
    }
    public MyGraph(In in)
    {
        this(in.readInt());
        int E = in.readInt();
        for(int i = 0; i < E; ++i)
        {
            int s = in.readInt();
            int e = in.readInt();
            addEdge(s, e);
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
    public void addEdge(int v, int w)
    {
        E++;
        adj[v].add(w);
        adj[w].add(v);
    }
    public Iterable<Integer> adj(int v)
    {
        return adj[v];
    }
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append(V() + " vertices, " + E() + " edges\n");
        for(int i = 0; i < V(); ++i)
        {
            sb.append(i + ": ");
            for(int j : adj(i))
            {
                sb.append(j + " ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public static void main(String[] args)
    {
        MyGraph  graph = new MyGraph(new In(args[0]));
        StdOut.println(graph);
    }
}
