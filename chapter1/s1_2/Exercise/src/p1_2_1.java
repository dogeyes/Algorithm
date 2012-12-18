import java.awt.*;

/**
 * Created with IntelliJ IDEA.
 * User: dexctor
 * Date: 12-11-20
 * Time: 上午10:41
 * To change this template use File | Settings | File Templates.
 */
public class p1_2_1 {
    public static void main(String[] args)
    {
        int N = StdIn.readInt();
        Point2D[] points = new Point2D[N];
        for(int i = 0; i < N; ++i)
        {
            Point2D point = new Point2D(StdRandom.uniform(), StdRandom.uniform());
            points[i] = point;
            StdDraw.setPenRadius(0.01);
            StdDraw.point(point.x(), point.y());
        }

        double min = Double.MAX_VALUE;
        int point1index = 0, point2index = 0;
        for(int i = 0; i <  N; ++i)
        {
            for(int j = i + 1; j < N; ++j)
            {
                if(points[i].distanceTo(points[j]) < min)
                {
                    min = points[i].distanceTo(points[j]);
                    point1index = i;
                    point2index = j;
                }
            }
        }
        StdDraw.setPenColor(Color.RED);
        StdDraw.point(points[point1index].x(), points[point1index].y());
        StdDraw.point(points[point2index].x(), points[point2index].y());

    }
}
