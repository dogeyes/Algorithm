/**
 * Created with IntelliJ IDEA.
 * User: dexctor
 * Date: 13-1-2
 * Time: 下午7:22
 * To change this template use File | Settings | File Templates.
 */
public class MaxtrixSP {
    private EdgeWeightedMatrixDigraph G;
    private double[] disTo;
    private boolean[] marked;
    private int[] edgeTo;
    private int s;
    public MaxtrixSP(EdgeWeightedMatrixDigraph G, int s)
    {
        this.G = G;
        this.s = s;
        disTo = new double[G.V()];
        edgeTo = new int[G.V()];
        marked = new boolean[G.V()];
        for(int i = 0; i < G.V(); ++ i)
            disTo[i] = Double.POSITIVE_INFINITY;
        disTo[s] = 0.0;
        for(int i = 0; i < G.V(); ++i)
        {
            double min = Double.POSITIVE_INFINITY;
            int minInd = 0;
            for(int v = 0; v < G.V(); ++v)
            {
                if(!marked [v] && disTo[v] < min)
                {
                    min = disTo[v];
                    minInd = v;
                }
            }
            relax(minInd);
        }
    }
    private void relax(int v)
    {
        marked[v] = true;
        for(int w = 0; w < G.V(); ++w)
        {
            if(!marked[w] && disTo[w] > disTo[v] + G.weight(v, w))
            {
                disTo[w] = disTo[v] + G.weight(v, w);
                edgeTo[w] = v;
            }
        }
    }
    public boolean hasPathTo(int v)
    {
        return disTo[v] < Double.POSITIVE_INFINITY;
    }
    public Iterable<DirectedEdge> pathTo(int v)
    {
        Bag<DirectedEdge> path = new Bag<DirectedEdge>();
        while (v != s)
        {
            path.add(new DirectedEdge(edgeTo[v], v, G.weight(edgeTo[v], v)));
            v = edgeTo[v];
        }

        return path;
    }
    public double distTo(int v)
    {
        return disTo[v];
    }
}
