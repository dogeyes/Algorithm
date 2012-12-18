/**
 * Created with IntelliJ IDEA.
 * User: dexctor
 * Date: 12-11-20
 * Time: 上午10:59
 * To change this template use File | Settings | File Templates.
 */
public class p1_2_3 {
    public static void main(String[] args)
    {
        int N = StdIn.readInt();
        double max = StdIn.readDouble();
        double min = StdIn.readDouble();
        Interval2D[] intervals = new Interval2D[N];
        for(int i = 0; i < N; ++i)
        {
            double xmin = StdRandom.uniform(min,max);
            double ymin = StdRandom.uniform(min,max);
            double xmax = StdRandom.uniform(min,max);
            double ymax = StdRandom.uniform(min,max);
            if(xmin > xmax)
            {
                double tmp = xmin;
                xmin = xmax;
                xmax = tmp;
            }
            if(ymin > ymax)
            {
                double tmp = ymax;
                ymax = ymin;
                ymin = tmp;
            }

            Interval2D inter = new Interval2D(new Interval1D(xmin, xmax), new Interval1D(ymin, ymax));
            intervals[i] = inter;
        }

        for(int i = 0; i < N; ++i)
        {
            for(int j = 0; j < N; ++j)
            {
                StdDraw.setXscale(min, max);
                StdDraw.setYscale(min, max);
                StdDraw.setPenRadius(0.001);
                intervals[i].draw();
            }
        }
    }
}
