/**
 * Created with IntelliJ IDEA.
 * User: dexctor
 * Date: 12-12-29
 * Time: 上午9:00
 * To change this template use File | Settings | File Templates.
 */
public class Edge implements Comparable<Edge> {
    private int v;
    private int w;
    private double weight;
    public Edge(int v, int w, double weight)
    {
        this.v = v;
        this.w = w;
        this.weight = weight;
    }
    public int either()
    {
        return v;
    }
    public int other(int p)
    {
        if(this.v == p)
            return w;
        else if(this.w == p)
            return this.v;
        else
            throw new RuntimeException();
    }
    public double weight()
    {
        return weight;
    }
    public int compareTo(Edge that)
    {
        if(weight < that.weight)
            return -1;
        if(weight > that.weight)
            return 1;
        return 0;
    }
    public String toString()
    {
        return String.format("%d-%d:%.2f", v, w, weight);
    }
}
