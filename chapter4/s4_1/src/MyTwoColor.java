/**
 * Created with IntelliJ IDEA.
 * User: dexctor
 * Date: 12-12-24
 * Time: 下午10:15
 * To change this template use File | Settings | File Templates.
 */
public class MyTwoColor {
    private boolean[] marked;
    private boolean[] color;
    private MyGraph G;
    private boolean isTwoColorable = true;
    public MyTwoColor(MyGraph G)
    {
        this.G = G;
        marked = new boolean[G.V()];
        color = new boolean[G.V()];
        dfs(0);
    }
    private void dfs(int v)
    {
        marked[v] = true;
        for(int w : G.adj(v))
        {
            if(!marked[w])
            {
                color[w] = !color[v];
                dfs(w);
            }
            else if(color[v] == color[w])
                isTwoColorable = false;
        }
    }
    public boolean isTwoColorable()
    {
        return isTwoColorable;
    }
}
