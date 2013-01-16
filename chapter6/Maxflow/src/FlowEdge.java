/**
 * Created with IntelliJ IDEA.
 * User: dogeyes
 * Date: 13-1-16
 * Time: 上午10:18
 * To change this template use File | Settings | File Templates.
 */
public class FlowEdge {
    private final int v;
    private final int w;
    private final double capacity;
    private double flow;

    public FlowEdge(int v, int w, double capacity)
    {
        this.v = v;
        this.w = w;
        this.capacity = capacity;
    }

    public int from() {return v;}
    public int to() { return w; }
    public double capacity() { return capacity; }
    public double flow() { return flow; }

    public int other(int vertex)
    {
        if(vertex == v)
            return w;
        if(vertex == w)
            return v;
        throw new RuntimeException();
    }

    public double residualCapacityTo(int vertex)
    {
        if(vertex == v)
            return flow;
        if(vertex == w)
            return capacity - flow;
        else
            throw new RuntimeException();
    }

    public void addResidualFlowTo(int vertex, double delta)
    {
        if(vertex == v)
            flow -= delta;
        if(vertex == w)
            flow += delta;
        else throw new RuntimeException();
    }

    public String toString()
    {
        return String.format("%d->%d %.2f %.2f", v, w, capacity, flow);
    }
}
