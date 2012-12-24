/**
 * Created with IntelliJ IDEA.
 * User: dexctor
 * Date: 12-12-24
 * Time: 下午9:13
 * To change this template use File | Settings | File Templates.
 */
public class MyDepthFirstSearch {
    private MyGraph G;
    private final int s;
    private boolean marked[];
    private int edgeTo[];
    private int count;
    public MyDepthFirstSearch(MyGraph G, int s)
    {
        this.G = G;
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        this.s = s;
        dfs(s);
    }
    private void dfs(int v)
    {
        marked[v] = true;
        count++;
        for(int w : G.adj(v))
        {
            if(!marked(w))
            {
                edgeTo[w] = v;
                dfs(w);
            }
        }
    }
    public boolean marked(int v)
    {
        return marked[v];
    }
    public int count()
    {
        return count;
    }

}
