/**
 * Created with IntelliJ IDEA.
 * User: dexctor
 * Date: 12-12-24
 * Time: 下午10:12
 * To change this template use File | Settings | File Templates.
 */
public class TestCycle {
    public static void main(String[] args)
    {
        MyGraph G = new MyGraph(new In(args[0]));
        MyCycle cycle = new MyCycle(G);
        StdOut.println(cycle.hasCycle());
    }
}
