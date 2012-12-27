import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: dexctor
 * Date: 12-12-27
 * Time: 下午4:01
 * To change this template use File | Settings | File Templates.
 */
public class TestLCA {
    public static void main(String[] args)
    {
        MyDigraph G = new MyDigraph(new In("tinyDG4.txt"));
        StdOut.println(G);
        LCA lca = new LCA(G, 9, 10);

        StdOut.print(lca.lca());
        StdOut.println();
        for(int i : lca.ancestors())
            StdOut.print(i + " ");
        StdOut.println();
    }
}
