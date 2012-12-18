/**
 * Created with IntelliJ IDEA.
 * User: dexctor
 * Date: 12-11-20
 * Time: 上午10:51
 * To change this template use File | Settings | File Templates.
 */
public class p1_2_2 {
    public static void main(String[] args)
    {
        int N = StdIn.readInt();
        Interval1D[] intervals = new Interval1D[N];
        for(int i = 0; i < N; ++i)
        {
            double left = StdRandom.uniform();
            double right = StdRandom.uniform();
            if(left > right)
            {
                double tmp = left;
                left = right;
                right = tmp;
            }
            Interval1D inter = new Interval1D(left, right);
            intervals[i] = inter;
        }
        for(int i = 0; i < N; ++i)
        {
            for(int j = i + 1; j < N; ++j)
            {
                if(intervals[i].intersects(intervals[j]))
                    StdOut.println(i + " " + j);
            }
        }
    }
}
