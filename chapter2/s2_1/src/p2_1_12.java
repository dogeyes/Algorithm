/**
 * Created with IntelliJ IDEA.
 * User: dexctor
 * Date: 12-11-26
 * Time: 下午1:47
 * To change this template use File | Settings | File Templates.
 */
public class p2_1_12 {
    public static double time(String alg, Comparable[] a)
    {
        Stopwatch timer = new Stopwatch();
        ShellSort.sort(a);
        return timer.elapsedTime();
    }
    public static double timeRandomInput(String alg, int N, int T)
    {
        double total = 0.0;
        Double[] a = new Double[N];
        for(int t = 0; t < T; ++t)
        {
            for(int i = 0; i < N; ++i)
                a[i] = StdRandom.uniform();
            total += time(alg, a);
        }
        return total / T;
    }
    public static void  main(String[] args)
    {
        for(int N = 100; true; N *= 10)
        {
            StdOut.println(timeRandomInput(null, N, 10));
        }
    }

}
