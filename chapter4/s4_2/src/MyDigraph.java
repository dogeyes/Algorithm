/**
 * Created with IntelliJ IDEA.
 * User: dexctor
 * Date: 12-12-26
 * Time: 下午9:09
 * To change this template use File | Settings | File Templates.
 */
public class MyDigraph {
    private int V;
    private int E;
    private Bag<Integer>[] graph;
    public MyDigraph(MyDigraph other)
    {
        V = other.V;
        E = other.E;
        graph = new Bag[V];
        for(int i = 0; i < V; ++i)
        {
            graph[i] = new Bag<Integer>();
            for(int w: other.adj(i))
                graph[i].add(w);
        }
    }
    public MyDigraph(int v)
    {
        this.V = v;
        graph = (Bag<Integer>[])new Bag[v];
        for(int i = 0; i < v; ++i)
            graph[i] = new Bag<Integer>();
    }
    public MyDigraph(In in)
    {
        this(in.readInt());
        int E = in.readInt();
        for(int i = 0; i < E; ++i)
        {
            int v = in.readInt();
            int w = in.readInt();

            addEdge(v, w);
        }
    }
    public void addEdge(int v, int w)
    {
        //if(v == w || hasEdge(v, w))
        //    return;
        E++;
        graph[v].add(w);
    }
    public boolean hasEdge(int v, int w)
    {
        for(int i : adj(v))
            if(i == w)
                return true;
        return false;
    }
    public Iterable<Integer>  adj(int v)
    {
        return graph[v];
    }
    public MyDigraph reverse()
    {
        MyDigraph reverseGraph = new MyDigraph(V);
        for(int v = 0; v < V; ++v)
        {
            for(int w: adj(v))
                reverseGraph.addEdge(w, v);
        }
        return reverseGraph;
    }
    public int E()
    {
        return E;
    }
    public int V()
    {
        return V;
    }
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        for(int v = 0; v < V(); ++v)
        {
            sb.append(v + ":\n");
            for(int w : adj(v))
                sb.append("   " + w + "\n");

        }
        return sb.toString();
    }

}
