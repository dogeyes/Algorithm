/**
 * Created with IntelliJ IDEA.
 * User: daixing
 * Date: 12-12-25
 * Time: 下午9:46
 * To change this template use File | Settings | File Templates.
 */
public class EdgeConnective {
    private MyGraph g;
    private boolean[] marked;
    private boolean edgeConnective = true;
    public EdgeConnective(MyGraph g)
    {
        this.g = g;
        marked = new boolean[g.V()];

        for(int v = 0; v < g.V(); ++v)
        {
            if(check(v))
                edgeConnective = false;
        }
    }
    private boolean check(int s)
    {
        for(int i = 0; i < g.V(); ++i)
            marked[i] = false;
        marked[s] = true;
        int flag = 0;
        for(int v : g.adj(s))
        {
            if(flag > 0)
            {
                flag++;
                if(!marked[v])
                    return true;
                continue;
            }
            dfs(v);
            flag++;
        }
        return flag == 1;
    }
    private void dfs(int v)
    {
        marked[v] = true;
        for(int w : g.adj(v))
        {
            if(!marked[w])
                dfs(w);
        }
    }
    public boolean isEdgeConnective()
    {
        return edgeConnective;
    }
    public static void main(String[] args)
    {
        MyGraph  graph = new MyGraph(new In("connect.txt"));
        StdOut.println(graph);

        EdgeConnective con = new EdgeConnective(graph);
        StdOut.println(con.isEdgeConnective());
    }
}
