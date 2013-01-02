/**
 * Created with IntelliJ IDEA.
 * User: daixing
 * Date: 12-12-29
 * Time: 下午9:11
 * To change this template use File | Settings | File Templates.
 */
public class TestSpecifiedSet {
    public static void main(String[] args)
    {
        EdgeWeightedGraph G = new EdgeWeightedGraph(new In("tinyEWG.txt"));
        StdOut.println(G);
        Bag<Edge> set = new Bag<Edge>();
        In in = new In("edgeSet.txt");
        while (!in.isEmpty())
        {
            int v = in.readInt();
            int w = in.readInt();
            double weight = in.readDouble();
            set.add(new Edge(v, w, weight));
        }
        SpecifiedSet specifiedSet = new SpecifiedSet(G, set);
        for(Edge e: specifiedSet.edges())
        {
            StdOut.print(e + " ");
        }
        StdOut.println();
        StdOut.println(specifiedSet.weight());
    }
}
