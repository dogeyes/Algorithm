/**
 * Created with IntelliJ IDEA.
 * User: daixing
 * Date: 12-12-29
 * Time: 下午9:47
 * To change this template use File | Settings | File Templates.
 */
public class Cycle {
    private EdgeWeightedGraph G;
    private boolean[] marked;
    private int[] edgeTo;
    private boolean hasCycle;
    public Cycle(EdgeWeightedGraph G)
    {
        this.G = G;
        hasCycle = false;
        edgeTo = new int[G.V()];
        marked = new boolean[G.V()];
        for(int v = 0; v < G.V(); ++v)
        {
            if(!marked[v])
                dfs(v);
        }
    }
    private void dfs(int v)
    {
        marked[v] = true;
        for(Edge e: G.adj(v))
        {
            int w = e.other(v);
            if(!marked[w])
            {
                edgeTo[w] = v;
                dfs(w);
            }
            else if(edgeTo[v] != w)
                hasCycle = true;
        }
    }
    public boolean hasCycle()
    {
        return hasCycle;
    }
}

