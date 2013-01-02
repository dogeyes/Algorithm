/**
 * Created with IntelliJ IDEA.
 * User: dexctor
 * Date: 13-1-2
 * Time: 下午8:30
 * To change this template use File | Settings | File Templates.
 */
public class LineGraph {
    private double[] weight;
    private int V;
    public LineGraph(In in)
    {
        V = in.readInt();
        weight = new double[V];
        for(int i = 0; i < V - 1; ++i)
        {
            double e = in.readDouble();
            weight[i + 1] = weight[i] + e;
        }
    }
    public double weight(int v, int w)
    {
        return Math.abs(weight[w] - weight[v]);
    }
    public int V()
    {
        return V;
    }
}
