import sun.reflect.generics.tree.ArrayTypeSignature;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created with IntelliJ IDEA.
 * User: dexctor
 * Date: 12-12-13
 * Time: 下午9:30
 * To change this template use File | Settings | File Templates.
 */
public class MyPoint2D {
    public double x;
    public double y;
    public MyPoint2D(double x, double y)
    {
        this.x = x;
        this.y = y;
    }

    public String toString()
    {
        return "[" + x + ":" + y + "]";
    }
    public static class xComp implements Comparator<MyPoint2D>
    {
        public int compare(MyPoint2D p1, MyPoint2D p2)
        {
            if(p1.x < p2.x)
                return -1;
            if(p1.x > p2.x)
                return 1;
            return 0;
        }
    }
    public static class yComp implements Comparator<MyPoint2D>
    {
        public int compare(MyPoint2D p1, MyPoint2D p2)
        {
            if(p1.y < p2.y)
                return -1;
            if(p1.y > p2.y)
                return 1;
            return 0;
        }
    }
    public static class distanceComp implements Comparator<MyPoint2D>
    {
        public int compare(MyPoint2D p1, MyPoint2D p2)
        {
            double r1 = dis(p1.x, p1.y);
            double r2 = dis(p2.x, p2.y);
            if(r1 < r2)
                return -1;
            if(r1 > r2)
                return 1;
            return 0;
        }
        private double dis(double x, double y)
        {
            return Math.sqrt(x * x + y * y);
        }
    }
    public class distanceToPointComp implements Comparator<MyPoint2D>
    {
        private MyPoint2D point;
        public distanceToPointComp(MyPoint2D p)
        {
            point = p;
        }
        public int compare(MyPoint2D p1, MyPoint2D p2)
        {
            double r1 = dis(p1.x - point.x, p1.y - point.y);
            double r2 = dis(p2.x - point.x, p2.y - point.y);
            if(r1 < r2)
                return  -1;
            if(r1 > r2)
                return 1;
            return 0;
        }
        private double dis(double x, double y)
        {
            return Math.sqrt(x * x + y * y);
        }
    }public class polarAngleToPointComp implements Comparator<MyPoint2D>
    {
        private MyPoint2D point;
        public polarAngleToPointComp(MyPoint2D p)
        {
            point = p;
        }
        public int compare(MyPoint2D p1, MyPoint2D p2)
        {
            double ang1 =  angle(p1.x - point.x, p1.y -point.y);
            double ang2 =  angle(p2.x - point.x, p2.y -point.y);
            if(ang1 < ang2)
                return  -1;
            if(ang1 > ang2)
                return 1;
            return 0;
        }
        private double angle(double x, double y)
        {
            double angle = Math.atan2(y,x);
            if(angle < 0)
                angle += Math.PI;
            return angle;
        }
    }
    public static void main(String[] args)
    {
        int N = StdIn.readInt();
        MyPoint2D[] ps = new MyPoint2D[N];
        for(int i = 0; i < N; ++i)
        {
            double x = StdRandom.uniform();
            double y = StdRandom.uniform();
            MyPoint2D p = new MyPoint2D(x, y);
            ps[i] = p;
        }
        StdRandom.shuffle(ps);
        Arrays.sort(ps, new xComp());
        StdOut.println(Arrays.toString(ps));
        Arrays.sort(ps, new yComp());
        StdOut.println(Arrays.toString(ps));
        Arrays.sort(ps, new distanceComp());
        StdOut.println(Arrays.toString(ps));
        MyPoint2D pp = new MyPoint2D(10,10);
        Arrays.sort(ps, pp.new distanceToPointComp(pp));
        StdOut.println(Arrays.toString(ps));
    }
}
