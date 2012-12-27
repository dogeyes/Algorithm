/**
 * Created with IntelliJ IDEA.
 * User: dexctor
 * Date: 12-12-27
 * Time: 下午2:48
 * To change this template use File | Settings | File Templates.
 */
public class TestDirectedEulerianCycle {
    public static void main(String[] args)
    {
        MyDigraph G = new MyDigraph(new In("tinyDG3.txt"));
        StdOut.println(G);

        MyDirectedCycle directedCycle = new MyDirectedCycle(G);

        if(directedCycle.hasCycle())
        {
            for(int w: directedCycle.cycle())
            {
                StdOut.print(w + " ");
            }
            StdOut.println();
        }
        else
            StdOut.println("no cycle");
        DirectedEulerianCycle directedEulerianCycle = new DirectedEulerianCycle(G);
        Iterable<Integer> eulerCycle = directedEulerianCycle.eulerianCycle();
        for(int i: eulerCycle)
        {
            StdOut.print(i + " ");
        }
        StdOut.println();
    }
}
