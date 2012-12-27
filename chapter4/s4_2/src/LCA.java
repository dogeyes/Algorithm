/**
 * Created with IntelliJ IDEA.
 * User: dexctor
 * Date: 12-12-27
 * Time: 下午3:53
 * To change this template use File | Settings | File Templates.
 */
public class LCA {
    private MyDigraph G;
    private int[] height;
    private Queue<Integer> ancestors;
    private MyTopological topological;
    private int v, w;
    private int result;
    public LCA(MyDigraph G, int v, int w)
    {
        this.v = v;
        this.w = w;
        this.G = G;
        height = new int[G.V()];
        for(int i =0 ; i < G.V(); ++i)
            height[i] = G.V();
        topological = new MyTopological(G);
        count();
    }
    public int lca()
    {
        return result;
    }
    private void count()
    {
        ancestors = new Queue<Integer>();
        for(int s: topological.order())
        {
            height[s] = 0;
            int state = dfs(s, v, w);
            break;
        }
        int max = 0;
        result = 0;
        for(int s: ancestors)
        {
            if(height[s] > max)
            {
                max = height[s];
                result = s;
            }
        }
    }
    private int dfs(int s, int v, int w)
    {
        if(s == v)
            return 1;
        if(s == w)
            return 2;
        boolean flag1 = false;
        boolean flag2 = false;
        for(int i : G.adj(s))
        {
            if(height[s] + 1 < height[i])
                height[i] = height[s] + 1;
            int state = dfs(i, v, w);
            if(state == 1)
                flag1 = true;
            if(state == 2)
                flag2 = true;
            if(state == 3)
            {
                flag1 = true;
                flag2 = true;
            }
        }
        if(flag1 && flag2)
        {
            ancestors.enqueue(s);
            return 3;
        }
        else if(flag1)
            return 1;
        else if(flag2)
            return 2;
        else
            return 0;
    }
    public Iterable<Integer> ancestors()
    {
        return ancestors;
    }
}
