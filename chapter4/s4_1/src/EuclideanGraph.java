import java.awt.*;

/**
 * Created with IntelliJ IDEA.
 * User: daixing
 * Date: 12-12-25
 * Time: 下午11:01
 * To change this template use File | Settings | File Templates.
 */
public class EuclideanGraph {
    private MyGraph g;
    private int V;
    private int range;
    public EuclideanGraph(MyGraph g)
    {
        this.g = g;
        V = g.V();
        range = (int)Math.ceil(Math.sqrt(V));
    }

    private int x(int v)
    {
        return v % range;
    }
    private int y(int v)
    {
        return v/ range;
    }
    public void show()
    {
        StdDraw.setXscale(-1, range);
        StdDraw.setYscale(-1, range);
        StdDraw.setPenColor(Color.GREEN);
        StdDraw.setPenRadius(0.05);
        for(int i = 0; i < V; ++i)
        {
            StdDraw.point(x(i), y(i));
        }
        StdDraw.setPenColor(Color.BLACK);
        StdDraw.setPenRadius(0.01);
        for(int i = 0; i < V; ++i)
        {
            for(int w : g.adj(i))
                StdDraw.line(x(w),y(w),x(i),y(i));
        }
    }
    public static void main(String[] args)
    {
        MyGraph  graph = new MyGraph(new In("connect.txt"));
        StdOut.println(graph);
        EuclideanGraph draw = new EuclideanGraph(graph);

        draw.show();

    }
}
