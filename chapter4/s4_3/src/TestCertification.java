/**
 * Created with IntelliJ IDEA.
 * User: daixing
 * Date: 12-12-29
 * Time: 下午9:39
 * To change this template use File | Settings | File Templates.
 */
public class TestCertification {
    public static void main(String[] args)
    {
        EdgeWeightedGraph G = new EdgeWeightedGraph(new In("tinyEWG.txt"));
        MyKruskalMST mst = new MyKruskalMST(G);
        StdOut.println(G);
        Iterable<Edge> edges = mst.edges();
        Bag<Edge> newEdges = new Bag<Edge>();
        In in = new In("edgeSet.txt");
        while (!in.isEmpty())
        {
            Edge e = new Edge(in.readInt(), in.readInt(), in.readDouble());
            newEdges.add(e);
        }
        Certification certification = new Certification(G, mst.edges());
        StdOut.println(certification.isMST());
        Certification certification1 = new Certification(G, newEdges);
        StdOut.println(certification1.isMST());
    }
}
