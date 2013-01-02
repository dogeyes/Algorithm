/**
 * Created with IntelliJ IDEA.
 * User: dexctor
 * Date: 13-1-2
 * Time: 下午1:44
 * To change this template use File | Settings | File Templates.
 */
public class MyTopological {
    private Iterable<Integer> order;
    private boolean hasOrder;
    private EdgeWeightedCycleFinder cycleFinder;
    public MyTopological(EdgeWeightedDigraph G)
    {
        cycleFinder = new EdgeWeightedCycleFinder(G);
        if(!cycleFinder.hasCycle())
        {
            hasOrder = true;
            MyDepthFirstOrder depthFirstOrder = new MyDepthFirstOrder(G);
            order = depthFirstOrder.reversePost();
        }
    }
    public boolean hasOrder()
    {
        return hasOrder;
    }
    public Iterable<Integer> order()
    {
        return order;
    }
}
