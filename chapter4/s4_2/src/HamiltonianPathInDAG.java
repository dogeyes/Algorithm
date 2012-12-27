/**
 * Created with IntelliJ IDEA.
 * User: dexctor
 * Date: 12-12-27
 * Time: 下午4:46
 * To change this template use File | Settings | File Templates.
 */
public class HamiltonianPathInDAG {
    private MyDigraph G;
    MyTopological topological;
    private boolean hasHamiltonianPath;
    public HamiltonianPathInDAG(MyDigraph G)
    {
        this.G = G;
        topological = new MyTopological(G);
        hasHamiltonianPath = true;
        int pre = -1;
        for(int i: topological.order())
        {
            if(pre == -1)
            {
                pre = i;
                continue;
            }
            boolean flag = false;
            for(int v: G.adj(pre))
                if(v == i)
                {
                    flag = true;
                    break;
                }
            if(!flag)
            {
                hasHamiltonianPath = false;
                break;
            }
            pre = i;
        }
    }
    public boolean hasHamiltonianPath()
    {
        return hasHamiltonianPath;
    }
    public Iterable<Integer> hamiltonianPath()
    {
        return topological.order();
    }
}
