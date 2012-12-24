/**
 * Created with IntelliJ IDEA.
 * User: dexctor
 * Date: 12-12-24
 * Time: 下午9:20
 * To change this template use File | Settings | File Templates.
 */
public class MyPaths {
    private MyGraph G;
    private final int s;
    private int edgeTo[];
    private boolean marked[];
    public MyPaths(MyGraph G, int s)
    {
        this.s = s;
        this.G = G;
        edgeTo = new int[G.V()];
        marked = new boolean[G.V()];
        dfs(s);
    }
    private void dfs(int v)
    {
        marked[v] = true;
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
    public boolean hasPathTo(int v)
    {
        return marked(v);
    }
    public Iterable<Integer> pathTo(int v)
    {
        Stack<Integer> stack = new Stack<Integer>();
        for(;v != s; v = edgeTo[v])
            stack.push(v);
        stack.push(s);
        return stack;
    }

}
