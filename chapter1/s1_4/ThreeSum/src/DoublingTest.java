import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: dexctor
 * Date: 12-11-25
 * Time: 下午1:42
 * To change this template use File | Settings | File Templates.
 */
public class DoublingTest {
    public static double timeTrial(int N)
    {
        int MAX = 1000000;
        int[] a = new int[N];
        for(int i = 0; i < N; ++i)
            a[i] = StdRandom.uniform(-MAX, MAX);
        Stopwatch timer = new Stopwatch();
        int cnt = FastThreeSum.count(a);
        return timer.elapsedTime();
    }
    public static void main(String[] args)
    {
        StdDraw.setPenRadius(0.005);
        StdDraw.setXscale(0, Math.log(32000));
        StdDraw.setYscale(Math.log(0.01),Math.log(16));
        for(int N = 250; true; N+= N)
        {
            double time = timeTrial(N);
            StdOut.printf("%7d %5.1f\n", N, time);
            StdDraw.point(Math.log(N), Math.log(time));
        }
    }
}
