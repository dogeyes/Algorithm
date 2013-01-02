/**
 * Created with IntelliJ IDEA.
 * User: dexctor
 * Date: 13-1-2
 * Time: 下午8:34
 * To change this template use File | Settings | File Templates.
 */
public class TestLineGraph {
    public static void main(String[] args)
    {
        LineGraph G = new LineGraph(new In("lineG.txt"));
        StdOut.println(G.weight(0, G.V() - 1));
    }
}
