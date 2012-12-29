/**
 * Created with IntelliJ IDEA.
 * User: daixing
 * Date: 12-12-29
 * Time: 下午8:48
 * To change this template use File | Settings | File Templates.
 */
public class TestDenseGraphPrimMST
{
    public static void main(String[] args)
    {
        EdgeWeightedGraph G = new EdgeWeightedGraph(new In("mediumEWG.txt"));

        DenseGraphPrimMST mst = new DenseGraphPrimMST(G);

        StdOut.println(mst.weight());
        for(Edge e: mst.mst())
        {
            StdOut.print(e + " ");
        }
        StdOut.println();
    }
}
