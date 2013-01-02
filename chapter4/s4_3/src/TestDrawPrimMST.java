/**
 * Created with IntelliJ IDEA.
 * User: daixing
 * Date: 12-12-29
 * Time: 下午8:25
 * To change this template use File | Settings | File Templates.
 */
public class TestDrawPrimMST {
     public static void main(String[] args)
    {
        EdgeWeightedGraph G = new EdgeWeightedGraph(new In("tinyEWD.txt"));
        DrawPrimMST primMST = new DrawPrimMST(G);

    }
}
