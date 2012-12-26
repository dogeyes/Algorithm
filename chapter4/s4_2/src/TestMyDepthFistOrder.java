/**
 * Created with IntelliJ IDEA.
 * User: dexctor
 * Date: 12-12-26
 * Time: 下午9:59
 * To change this template use File | Settings | File Templates.
 */
public class TestMyDepthFistOrder {
    public static void main(String[] args)
    {
        MyDigraph G = new MyDigraph(new In("tinyDG1.txt"));
        StdOut.println(G);

        MyDepthFirstOrder depthFirstOrder = new MyDepthFirstOrder(G);

        for(int w: depthFirstOrder.pre())
            StdOut.print(w + " ");
        StdOut.println();
        for(int w: depthFirstOrder.post())
            StdOut.print(w + " ");
        StdOut.println();
        for(int w: depthFirstOrder.reversePost())
            StdOut.print(w + " ");
        StdOut.println();
    }
}
