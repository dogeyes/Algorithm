/**
 * Created with IntelliJ IDEA.
 * User: dexctor
 * Date: 12-12-24
 * Time: 下午10:04
 * To change this template use File | Settings | File Templates.
 */
public class MyCycle {
    private boolean[] marked;
    private boolean hasCycle;
    private MyGraph G;
    public MyCycle(MyGraph G)
    {
        this.G = G;
        marked = new boolean[G.V()];
        for(int i = 0; i < G.V(); ++i)
        {
            if(!marked[i])
            {
                dfs(i, i);
            }
        }
    }
    private void dfs(int v, int f)
    {
        marked[v] = true;
        for(int w: G.adj(v))
        {
            if(!marked[w])
                dfs(w, v);
            else
                if(w != f)
                {
                    hasCycle = true;
                }
        }
    }
    public boolean hasCycle()
    {
        return hasCycle;
    }
}
