import java.awt.*;

/**
 * Created with IntelliJ IDEA.
 * User: daixing
 * Date: 12-12-29
 * Time: 下午8:19
 * To change this template use File | Settings | File Templates.
 */
public class DrawPrimMST {
    private IndexMinPQ<Double> pq;
    private EdgeWeightedGraph G;
    private double[] disTo;
    private boolean[] marked;
    private int[] edgeTo;
    private double weight;
    private Bag<Edge> edges;
    private int range;
    public DrawPrimMST(EdgeWeightedGraph G)
    {
        this.G = G;
        range = (int)Math.ceil(Math.sqrt(G.V()));
        pq = new IndexMinPQ<Double>(G.V());
        disTo = new double[G.V()];
        edges = new Bag<Edge>();
        for(int i = 0; i < G.V(); ++i)
            disTo[i] = Double.POSITIVE_INFINITY;
        edgeTo = new int[G.V()];
        marked = new boolean[G.V()];
        disTo[0] = 0.0;
        StdDraw.setXscale(-1, range);
        StdDraw.setYscale(-1, range);
        StdDraw.setPenRadius(0.05);
        for(int i = 0; i < G.V(); ++i)
        {
            StdDraw.setPenColor(Color.GREEN);
            StdDraw.point(x(i), y(i));
            StdDraw.setPenColor(Color.RED);
            StdDraw.textLeft(x(i), y(i), i + " ");
        }
        visit(0);
        while (!pq.isEmpty())
        {
            int v = pq.delMin();
            weight += disTo[v];
            draw(v, edgeTo[v]);
            edges.add(new Edge(v, edgeTo[v], disTo[v]));

            visit(v);
        }
    }
    private void draw(int v, int w)
    {
        StdDraw.setPenColor(Color.BLACK);
        StdDraw.setPenRadius(0.01);
        StdDraw.line(x(w),y(w),x(v),y(v));
        try {
            Thread.sleep(10000);
        }
        catch (Exception e)
        {

        }
    }
    private int x(int v)
    {
        return v % range;
    }
    private int y(int v)
    {
        return v/ range;
    }
    public void visit(int v)
    {
        marked[v] = true;
        for(Edge e: G.adj(v))
        {
            int w = e.other(v);
            if(marked[w])
                continue;
            if(disTo[w] > e.weight())
            {
                disTo[w] = e.weight();
                if(!pq.contains(w))
                {
                    pq.insert(w, e.weight());
                }
                else
                    pq.changeKey(w, e.weight());
                edgeTo[w] = v;
            }
        }
    }
    public Iterable<Edge> edges()
    {
        return edges;
    }
    public double weight()
    {
        return weight;
    }
}
