import javax.naming.event.NamingListener;

/**
 * Created with IntelliJ IDEA.
 * User: dexctor
 * Date: 12-11-26
 * Time: 下午1:13
 * To change this template use File | Settings | File Templates.
 */
public class SortCompare {
    public static double time(String alg, Comparable[] a)
    {
        double[] b = new double[a.length];
        for(int i = 0; i < a.length; ++ i)
            b[i] = (Double) a[i];
        Stopwatch timer = new Stopwatch();
        if(alg.equals("Insertion")) InsertionSort.sort(a);
        else if(alg.equals("Selection")) SelectionSort.sort(a);
        else if(alg.equals("Shell")) ShellSort.sort(a);
        else if(alg.equals("InsertionStd")) Insertion.sort(a);
        else if(alg.equals("p2_1_26")) p2_1_26.sort(b);
        else if(alg.equals("Merge")) MergeSort.sort(a);

        return timer.elapsedTime();
    }
    public static double timeRandomInput(String alg, int N, int T)
    {
        double total = 0.0;
        Double[] a = new Double[N];
        for(int t = 0; t < T; ++t)
        {
            for(int i = 0; i < N; ++i)
                a[i] = StdRandom.gaussian();
            total += time(alg, a);
        }
        return total;
    }
    public static void main(String[] args)
    {
        String alg1 = StdIn.readString();
        String alg2 = StdIn.readString();
        int N = StdIn.readInt();
        int T = StdIn.readInt();
        double t1 = timeRandomInput(alg1, N, T);
        double t2 = timeRandomInput(alg2, N, T);
        StdOut.printf("For %d random Doubles\n    %s is ", N, alg1 );
        StdOut.printf(" %.2f times faster than %s\n", t2/t1, alg2);
    }
}
