/**
 * Created with IntelliJ IDEA.
 * User: dexctor
 * Date: 13-1-2
 * Time: 上午8:35
 * To change this template use File | Settings | File Templates.
 */
public class DirectedEdge implements Comparable<DirectedEdge> {
    private int v;
    private int w;
    private double weight;
    public DirectedEdge(int v, int w, double weight)
    {
        this.v = v;
        this.w = w;
        this.weight = weight;
    }
    public double weight()
    {
        return weight;
    }
    public int from()
    {
        return v;
    }
    public int to()
    {
        return w;
    }
    public String toString()
    {
        return v + "->" + w + ":" + weight;
    }
    public int compareTo(DirectedEdge other)
    {
        if(weight() < other.weight())
            return  - 1;
        if(weight() > other.weight())
            return 1;
        return 0;
    }
}
