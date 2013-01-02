/**
 * Created with IntelliJ IDEA.
 * User: dexctor
 * Date: 13-1-2
 * Time: 下午7:19
 * To change this template use File | Settings | File Templates.
 */
public class TestMatrixDigraph {
    public static void main(String[] args)
    {
        EdgeWeightedMatrixDigraph G = new EdgeWeightedMatrixDigraph(new In("tinyEWD.txt"));
        StdOut.println(G);
    }
}
