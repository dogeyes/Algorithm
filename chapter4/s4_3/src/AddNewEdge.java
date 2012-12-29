/**
 * Created with IntelliJ IDEA.
 * User: dexctor
 * Date: 12-12-29
 * Time: 下午3:05
 * To change this template use File | Settings | File Templates.
 */
public class AddNewEdge {
    public static void main(String[] args)
    {
        EdgeWeightedGraph G = new EdgeWeightedGraph(new In("tinyEWG.txt"));
        MyKruskalMST kruskalMST = new MyKruskalMST(G);
        Iterable<Edge> mst = kruskalMST.edges();
        EdgeWeightedGraph mstGraph = new EdgeWeightedGraph(G.V());
        for(Edge e: mst)
        {
            mstGraph.addEdge(e);
        }
        int v = StdIn.readInt();
        int w = StdIn.readInt();
        FindPath fp = new FindPath(mstGraph, v, w);
        Iterable<Edge> path = fp.path();
        for(Edge e: path)
        {
            StdOut.print(e + " ");
        }
        StdOut.println();
    }

}
class FindPath
{
    private EdgeWeightedGraph G;
    private Stack<Edge> path;
    private boolean[] marked;
    private int s;
    private int e;
    public FindPath(EdgeWeightedGraph G, int v, int w)
    {
        s = v;
        e = w;
        this.G = G;
        path = new Stack<Edge>();
        marked = new boolean[G.V()];
        dfs(s);
    }
    private boolean dfs(int v)
    {
        if(v == e)
            return true;
        marked[v] = true;
        for(Edge e: G.adj(v))
        {
            if(!marked[e.other(v)])
            {
                path.push(e);
                if(dfs(e.other(v)))
                    return true;
                path.pop();
            }
        }
        return false;
    }
    public Iterable<Edge> path()
    {
        return path;
    }
}
