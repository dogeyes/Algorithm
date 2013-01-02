/**
 * Created with IntelliJ IDEA.
 * User: dexctor
 * Date: 13-1-2
 * Time: 下午7:07
 * To change this template use File | Settings | File Templates.
 */
public class EdgeWeightedMatrixDigraph {
    private double[][] martix;
    private int V;
    private int E;
    public EdgeWeightedMatrixDigraph(int V)
    {
        this.V = V;
        martix = new double[V][V];
        for(int i = 0; i < V; ++i)
            for(int j = 0; j < V; ++j)
                martix[i][j] = Double.POSITIVE_INFINITY;
    }
    public EdgeWeightedMatrixDigraph(In in)
    {
        this(in.readInt());
        int E = in.readInt();
        for(int i = 0 ; i < E; ++i)
        {
            int v = in.readInt();
            int w = in.readInt();
            double weight = in.readDouble();
            addEdge(v, w, weight);
        }
    }
    private void addEdge(int v, int w, double weight)
    {
        E++;
        martix[v][w] = weight;
    }
    public double weight(int v, int w)
    {
        return martix[v][w];
    }
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        for(int v = 0; v < V; ++v)
        {
            sb.append(v + " :\n");
            for(int w = 0; w < V; ++w)
            {
                if(martix[v][w] < Double.POSITIVE_INFINITY)
                    sb.append("   " + v + "->" + w + " :" + weight(v, w) + "\n" );
            }
        }
        return sb.toString();
    }
    public int V()
    {
        return V;
    }
    public int E()
    {
        return E;
    }
}
