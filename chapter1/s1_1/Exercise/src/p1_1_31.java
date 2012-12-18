/**
 * Created with IntelliJ IDEA.
 * User: dexctor
 * Date: 12-11-15
 * Time: 下午1:11
 * To change this template use File | Settings | File Templates.
 */
class Point
{
    public Point(double x, double y)
    {
        this.x = x;
        this.y = y;
    }
    public double x;
    public double y;
}

public class p1_1_31 {

    public static void main(String[] args)
    {
        int N = StdIn.readInt();
        double p = StdIn.readDouble();
        Point[] points = new Point[N];
        StdDraw.setCanvasSize(1600,900);
        StdDraw.setPenRadius(0.0005);
        StdDraw.setXscale(-3.2, 3.2);
        StdDraw.setYscale(-1.8, 1.8);
        StdDraw.circle(0,0,1.5);
        for(int i = 0; i < N; ++i)
        {
            points[i] = new Point(1.5 * Math.cos(Math.PI / N * i * 2), 1.5 * Math.sin(Math.PI / N * i * 2));
            StdDraw.point(points[i].x, points[i].y);
        }

        for(int i = 0; i < N; ++i)
        {
            for(int j = i + 1; j < N; ++j)
            {
                if(StdRandom.bernoulli(p))
                    StdDraw.line(points[i].x, points[i].y, points[j].x, points[j].y);
            }
        }
    }
}
