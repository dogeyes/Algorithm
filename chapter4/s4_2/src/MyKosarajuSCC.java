/**
 * Created with IntelliJ IDEA.
 * User: dexctor
 * Date: 12-12-26
 * Time: 下午10:16
 * To change this template use File | Settings | File Templates.
 */
public class MyKosarajuSCC {
    private MyDigraph G;
    private boolean[] marked;
    private int[] ind;
    private int count;
    public MyKosarajuSCC(MyDigraph G)
    {
        this.G = G;
        marked = new boolean[G.V()];
        ind = new int[G.V()];
        MyDepthFirstOrder depthFirstOrder = new MyDepthFirstOrder(G.reverse());
        for(int w : depthFirstOrder.reversePost())
        {
            if(!marked[w])
            {
                dfs(w);
                count++;
            }

        }
    }
    private void dfs(int v)
    {
        marked[v] = true;
        ind[v] = count;
        for(int w: G.adj(v))
        {
            if(!marked[w])
                dfs(w);
        }
    }
    public boolean stronglyConnected(int v, int w)
    {
        return ind[v] == ind[w];
    }
    public int id(int v)
    {
        return ind[v];
    }
    public int count()
    {
        return count;
    }

}
