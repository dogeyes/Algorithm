/**
 * Created with IntelliJ IDEA.
 * User: dexctor
 * Date: 12-11-25
 * Time: 下午1:53
 * To change this template use File | Settings | File Templates.
 */
public class DoublingRatio {
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
    public static void main(String[] agrs)
    {
        double prev = timeTrial(125);
        for(int N = 250;true; N += N)
        {
            double time = timeTrial(N);
            StdOut.printf("%6d %7.1f ", N, time);
            StdOut.printf("%5.1f\n", time/prev);
            prev = time;
        }
    }
}
