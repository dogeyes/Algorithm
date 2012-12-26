/**
 * Created with IntelliJ IDEA.
 * User: dexctor
 * Date: 12-12-26
 * Time: 下午9:41
 * To change this template use File | Settings | File Templates.
 */
public class TestMyDirectedCycle {
    public static void main(String[] args)
    {
        MyDigraph G = new MyDigraph(new In("tinyDG1.txt"));
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
    }
}
