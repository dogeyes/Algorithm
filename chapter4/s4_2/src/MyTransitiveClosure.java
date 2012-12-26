/**
 * Created with IntelliJ IDEA.
 * User: dexctor
 * Date: 12-12-26
 * Time: 下午10:25
 * To change this template use File | Settings | File Templates.
 */
public class MyTransitiveClosure {
    private MyDirectedDFS[] map;
    public MyTransitiveClosure(MyDigraph G)
    {
        map = new MyDirectedDFS[G.V()];
        for(int i = 0; i < G.V(); ++i)
            map[i] = new MyDirectedDFS(G,i);
    }
    public boolean reachable(int v, int w)
    {
        return map[v].marked(w);
    }
}
