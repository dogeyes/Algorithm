/**
 * Created with IntelliJ IDEA.
 * User: dexctor
 * Date: 12-11-26
 * Time: 下午7:51
 * To change this template use File | Settings | File Templates.
 */
public class DoublingTest {
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

        return timer.elapsedTime();
    }
    public static double timeRandomInput(String alg, int N, int T)
    {
        double total = 0.0;
        Double[] a = new Double[N];
        for(int t = 0; t < T; ++t)
        {
            for(int i = 0; i < N; ++i)
                a[i] =(double) StdRandom.poisson(10.0);
            total += time(alg, a);
        }
        return total;
    }
    public static void main(String[] args)
    {
        String alg = StdIn.readString();
        int N = StdIn.readInt();
        int T = StdIn.readInt();
        StdDraw.setPenRadius(0.005);
        double prev = timeRandomInput(alg, N, T);
        for(;true; N += N)
        {
            double time = timeRandomInput(alg, N, T);
            StdOut.println(N + " " + time + " " + time / prev);
            prev = time;
            StdDraw.setXscale(0, N);
            StdDraw.setYscale(0,time);
            StdDraw.point(N, time);
            try{
                Thread.sleep(3000);
            }catch (Exception e)
            {

            }
        }
    }
}
