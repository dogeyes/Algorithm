/**
 * Created with IntelliJ IDEA.
 * User: dexctor
 * Date: 12-12-27
 * Time: 下午9:31
 * To change this template use File | Settings | File Templates.
 */
public class ShortestAncestralPath {
    private int v;
    private int w;
    private int min;
    private int result;
    private MyDigraph G;
    public ShortestAncestralPath(MyDigraph G, int v, int w)
    {
        this.v = v;
        this.w = w;
        this.G = G;
        DirectedBFS dv = new DirectedBFS(G.reverse(),v);
        DirectedBFS dw = new DirectedBFS(G.reverse(),w);

        LCA lca = new LCA(G, v, w);
        StdOut.println("lca is " + lca.lca());
        min = G.V();

        for(int i : lca.ancestors())
        {
            if(dv.dis(i) + dw.dis(i) < min)
            {
                min = dv.dis(i) + dw.dis(i);
                result = i;
            }
        }
    }
    public int sap()
    {
        return result;
    }
    public static void main(String[] args)
    {
        MyDigraph G = new MyDigraph(new In("tinyDG6.txt"));
        StdOut.println(G);

        ShortestAncestralPath sap = new ShortestAncestralPath(G, 4 , 6);
        StdOut.println("sap is " + sap.sap());
    }
}
