import java.awt.*;
import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: dexctor
 * Date: 12-12-27
 * Time: 下午7:09
 * To change this template use File | Settings | File Templates.
 */
public class DrawDigraph {
    private MyDigraph g;
    private int V;
    private int range;
    public DrawDigraph(MyDigraph g)
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

        StdDraw.setPenColor(Color.BLACK);
        StdDraw.setPenRadius(0.01);
        for(int i = 0; i < V; ++i)
        {
            for(int w : g.adj(i))
                StdDraw.line(x(w),y(w),x(i),y(i));
        }
        StdDraw.setPenRadius(0.05);
        for(int i = 0; i < V; ++i)
        {
            StdDraw.setPenColor(Color.GREEN);
            StdDraw.point(x(i), y(i));
            StdDraw.setPenColor(Color.RED);
            StdDraw.textLeft(x(i), y(i), i + " ");
        }
    }
    public static void main(String[] args)
    {
        MyDigraph G = new MyDigraph(new In("tinyDG1.txt"));
        StdOut.println(G);

        MyTopological topological = new MyTopological(G);
        if(topological.isDAG())
        {
            for(int w : topological.order())
            {
                StdOut.print(w + " ");
            }
            StdOut.println();
        }
        else
            StdOut.println("not DAG");

        DrawDigraph drawDigraph = new DrawDigraph(G);
        drawDigraph.show();
    }
}
