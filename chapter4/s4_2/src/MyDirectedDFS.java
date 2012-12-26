/**
 * Created with IntelliJ IDEA.
 * User: dexctor
 * Date: 12-12-26
 * Time: 下午9:26
 * To change this template use File | Settings | File Templates.
 */
public class MyDirectedDFS {
    private boolean[] marked;
    private MyDigraph G;
    public MyDirectedDFS(MyDigraph G, int s)
    {
        this.G = G;
        marked =  new boolean[G.V()];
        dfs(s);
    }
    public MyDirectedDFS(MyDigraph G, Iterable<Integer> sources)
    {
        this.G = G;
        marked =  new boolean[G.V()];
        for(int i = 0; i < G.V(); ++i)
        {
            if(!marked[i])
                dfs(i);
        }
    }
    private void dfs(int v)
    {
        marked[v] = true;
        for(int w:G.adj(v))
            if(!marked[w])
                dfs(w);
    }
    public boolean marked(int v)
    {
        return marked[v];
    }
}
