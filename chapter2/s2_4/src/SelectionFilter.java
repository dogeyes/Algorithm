/**
 * Created with IntelliJ IDEA.
 * User: dexctor
 * Date: 12-12-10
 * Time: 下午8:12
 * To change this template use File | Settings | File Templates.
 */
public class SelectionFilter {
    private static class Point implements Comparable<Point>
    {
        final double x;
        final double y;
        final double z;
        final double r;
        public Point(double x, double y, double z)
        {
            this.x = x;
            this.y = y;
            this.z = z;
            r = Math.sqrt(x * x + y * y + z * z);
        }
        public int compareTo(Point other)
        {
            if(r < other.r)
                return -1;
            if(r > other.r)
                return 1;
            return 0;
        }
        public String toString()
        {
            return x + " " + y + " " + z;
        }
    }
    public static void main(String[] args)
    {
        int M = StdIn.readInt();
        MyMaxPQ<Point> pq = new MyMaxPQ<Point>(M + 1);
        double x,y,z;
        x = StdIn.readDouble();
        y = StdIn.readDouble();
        z = StdIn.readDouble();
        while (x != 0.0 || y != 0.0 || z != 0.0)
        {
            pq.insert(new Point(x, y, z));
            if(pq.size() == M + 1)
                pq.delMax();
            x = StdIn.readDouble();
            y = StdIn.readDouble();
            z = StdIn.readDouble();
        }
        while (!pq.isEmpty())
        {
            StdOut.println(pq.delMax());
        }
    }
}
