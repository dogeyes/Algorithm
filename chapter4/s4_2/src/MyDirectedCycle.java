/**
 * Created with IntelliJ IDEA.
 * User: dexctor
 * Date: 12-12-26
 * Time: 下午9:34
 * To change this template use File | Settings | File Templates.
 */
public class MyDirectedCycle {
    private MyDigraph G;
    private boolean[] marked;
    private int[] edgeTo;
    private boolean[] onStack;
    private Queue<Integer>  cycle;
    public MyDirectedCycle(MyDigraph G)
    {
        this.G = G;
        marked = new boolean[G.V()];
        onStack = new boolean[G.V()];
        edgeTo = new int[G.V()];
        for(int i = 0; i < G.V(); ++i)
        {
            if(!marked[i])
                dfs(i);
        }
    }
    private void dfs(int v)
    {
        marked[v] = true;
        onStack[v] = true;
        for(int w : G.adj(v))
        {
            if(hasCycle())
                return;
            if(!marked[w])
            {
                edgeTo[w] = v;
                dfs(w);
            }
            else if(onStack[w])
            {
                cycle = new Queue<Integer>();
                int x = v;
                while (x != w)
                {
                    cycle.enqueue(x);
                    x = edgeTo[x];
                }
                cycle.enqueue(w);
                cycle.enqueue(v);
                return;
            }
        }
        onStack[v] = false;

    }
    public boolean hasCycle()
    {
        return cycle != null;
    }
    public Iterable<Integer> cycle()
    {
        return cycle;
    }

}
