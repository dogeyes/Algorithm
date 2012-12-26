/**
 * Created with IntelliJ IDEA.
 * User: dexctor
 * Date: 12-12-26
 * Time: 下午9:52
 * To change this template use File | Settings | File Templates.
 */
public class MyTopological {
    private MyDigraph G;
    private Iterable<Integer> order;

    public MyTopological(MyDigraph G)
    {
        this.G = G;
        MyDirectedCycle directedCycle = new MyDirectedCycle(G);
        if(!directedCycle.hasCycle())
        {
            MyDepthFirstOrder depthFirstOrder = new MyDepthFirstOrder(G);
            order = depthFirstOrder.reversePost();
        }
    }
    public boolean isDAG()
    {
      return order != null;
    }
    public Iterable<Integer> order()
    {
        return order;
    }
}
