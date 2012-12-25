/**
 * Created with IntelliJ IDEA.
 * User: dexctor
 * Date: 12-12-25
 * Time: 上午9:51
 * To change this template use File | Settings | File Templates.
 */
public class UFSearch {

    private MyGraph G;
    private final int s;
    private int[] uf;
    private int[] weight;
    public UFSearch(MyGraph G, int s)
    {
        this.G = G;
        this.s = s;
        uf = new int[G.V()];
        weight = new int[G.V()];
        for(int i = 0; i < G.V(); ++i)
        {
            uf[i] = i;
            weight[i] = 1;
        }
        for(int v = 0; v < G.V(); ++v)
            for(int w: G.adj(v))
                union(v,w);
    }
    private int find(int v)
    {
        if(uf[v] == v)
            return v;
        else
            uf[v] = find(uf[v]);
        return uf[v];
    }
    private void union(int v, int w)
    {
        int p1 = find(v);
        int p2 = find(w);
        uf[p1] = p2;
        weight[p2] += weight[p1];
    }
    private boolean connected(int v, int w)
    {
        return find(v) == find(w);
    }
    public int count()
    {
        return weight[find(s)];
    }
    public boolean marked(int v)
    {
        return  connected(v, s);
    }
}
