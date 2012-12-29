/**
 * Created with IntelliJ IDEA.
 * User: daixing
 * Date: 12-12-29
 * Time: 下午8:35
 * To change this template use File | Settings | File Templates.
 */
public class DenseGraphPrimMST {
    private EdgeWeightedGraph G;
    private Edge[] edgeTo;
    private double[] disTo;
    private Queue<Edge> mst;
    private boolean[] marked;
    private double weight;
    public DenseGraphPrimMST(EdgeWeightedGraph G)
    {
        this.G = G;
        disTo = new double[G.V()];
        edgeTo = new Edge[G.V()];
        mst = new Queue<Edge>();
        marked = new boolean[G.V()];
        for(int i = 0; i < G.V(); ++i)
            disTo[i] = Double.POSITIVE_INFINITY;

        disTo[0] = 0;
        visit(0);
        for(int i =1  ;i < G.V(); ++i)
        {
            int v = 0;
            double min = Double.POSITIVE_INFINITY;
            for(int j = 0; j < G.V(); ++j)
            {
                if(!marked[j] && disTo[j] < min)
                {
                    min = disTo[j];

                    v = j;
                }
            }
            mst.enqueue(edgeTo[v]);
            weight += disTo[v];
            visit(v);
        }

    }
    private void visit(int v)
    {
        marked[v] = true;
        for(Edge e: G.adj(v))
        {
            int w = e.other(v);
            if(!marked[w] && disTo[w] > e.weight())
            {
                disTo[w] = e.weight();
                edgeTo[w] = e;
            }
        }
    }
    public Iterable<Edge> mst()
    {
        return mst;
    }
    public double weight()
    {
        return weight;
    }
}
