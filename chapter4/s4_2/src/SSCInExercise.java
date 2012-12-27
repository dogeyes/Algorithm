/**
 * Created with IntelliJ IDEA.
 * User: dexctor
 * Date: 12-12-27
 * Time: 下午4:14
 * To change this template use File | Settings | File Templates.
 */
public class SSCInExercise {
    private MyDigraph G;
    private MyDigraph reG;
    private Bag<Integer> components;
    private MyDirectedDFS directedDFS;
    private MyDirectedDFS reDirectedDFS;
    public SSCInExercise(MyDigraph G, int v)
    {
        this.G = G;
        reG = G.reverse();
        directedDFS = new MyDirectedDFS(G, v);
        reDirectedDFS = new MyDirectedDFS(reG, v);
        components = new Bag<Integer>();
        for(int i = 0; i < G.V(); ++i)
        {
            if(directedDFS.marked(i) && reDirectedDFS.marked(i))
                components.add(i);
        }
    }
    public Iterable<Integer> ssc()
    {
        return components;
    }
}
