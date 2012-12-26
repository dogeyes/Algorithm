/**
 * Created with IntelliJ IDEA.
 * User: dexctor
 * Date: 12-12-26
 * Time: 下午9:19
 * To change this template use File | Settings | File Templates.
 */
public class TestMyDigraph {
    public static void main(String[] args)
    {
        MyDigraph G = new MyDigraph(new In("tinyDG.txt"));

        StdOut.println(G);
    }
}
