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
    public MyGraph(MyGraph that)
    {
        this(that.V());
        E = that.E;
        adj = (Bag<Integer>[])new Bag[V];
        for(int i = 0; i < V; ++i)
        {
            adj[i] = new Bag<Integer>();
            for(int w: that.adj[i])
                adj[i].add(w);
        }
    }
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
        //if(v == w || hasEdge(v, w))
        //    return;
        E++;
        adj[v].add(w);
        adj[w].add(v);
    }
    public Iterable<Integer> adj(int v)
    {
        return adj[v];
    }
    public boolean hasEdge(int v, int w)
    {
        for(int i: adj(v))
            if(i == w)
                return true;
        return false;
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
        MyGraph graph2 = new MyGraph(graph);
        graph2.addEdge(0,graph2.V() - 1);
        StdOut.println(graph);
        StdOut.println("\n" + graph2);
        StdOut.println(graph2.hasEdge(4, 3));
        StdOut.println(graph2.hasEdge(7, 9));

    }
}
