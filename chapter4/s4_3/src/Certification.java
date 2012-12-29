/**
 * Created with IntelliJ IDEA.
 * User: daixing
 * Date: 12-12-29
 * Time: 下午9:27
 * To change this template use File | Settings | File Templates.
 */
public class Certification {
    private EdgeWeightedGraph G;
    private Iterable<Edge> mst;
    private boolean[] marked;
    private int[] catalog;
    private int count;
    private boolean isMST;
    private EdgeWeightedGraph mstGraph;
    public Certification(EdgeWeightedGraph G, Iterable<Edge> mst)
    {
        this.G = G;
        this.mst = mst;
        marked = new boolean[G.V()];
        catalog = new int[G.V()];
        isMST = true;
        mstGraph = new EdgeWeightedGraph(G.V());

        for(Edge e: mst)
        {
            mstGraph.addEdge(e);
        }
        Cycle cycle = new Cycle(mstGraph);
        if(cycle.hasCycle())
            isMST  = false;

        if(mstGraph.E() != mstGraph.V() - 1)
            isMST = false;
        for(Edge e: mst)
        {
            int v = e.either();
            int w = e.other(v);
            for(int i = 0; i < G.V(); ++i)
                marked[i] = false;
            marked[v] = true;
            count = 1;
            dfs(w);
            count = 2;
            dfs(v);

            for(Edge i : G.edges())
            {
                int vi = i.either();
                int wi = i.other(vi);
                if(catalog[vi] != catalog[wi] && i.weight() < e.weight())
                    isMST = false;
            }
        }

    }
    private void dfs(int v)
    {
        marked[v] = true;
        catalog[v] = count;
        for(Edge e: mstGraph.adj(v))
        {
            int w = e.other(v);
            if(!marked[w])
                dfs(w);
        }
    }
    public boolean isMST()
    {
        return isMST;
    }
}
