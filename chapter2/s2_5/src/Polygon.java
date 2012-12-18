import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: dexctor
 * Date: 12-12-14
 * Time: 上午10:11
 * To change this template use File | Settings | File Templates.
 */
public class Polygon {
    public static void main(String[] args)
    {
        int N = StdIn.readInt();
        MyPoint2D[] ps = new MyPoint2D[N];
        for(int i = 0; i < N; ++i)
        {
            double theta = StdRandom.uniform() * 360;
            double x = Math.cos(theta);
            double y = Math.sin(theta);
            ps[i] = new MyPoint2D(x, y);
        }

        StdDraw.setPenRadius(0.005);
        StdDraw.setXscale(-1.2,1.2);
        StdDraw.setYscale(-1.2,1.2);
        for(int i = 0; i < N; ++i)
        {
            StdDraw.point(ps[i].x, ps[i].y);
        }
        Arrays.sort(ps, new MyPoint2D.yComp());
        MyPoint2D yMin = ps[0];
        Arrays.sort(ps, yMin.new polarAngleToPointComp(yMin));
        for(int i = 0; i < N; ++i)
        {
            StdDraw.line(ps[i].x, ps[i].y, ps[(i + 1) % N].x, ps[(i + 1) %N].y);
        }
    }
}
