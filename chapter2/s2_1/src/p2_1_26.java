import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: dexctor
 * Date: 12-11-26
 * Time: 下午7:35
 * To change this template use File | Settings | File Templates.
 */
public class p2_1_26 {
    public static void sort(double[] a)
    {
        int N = a.length;
        for(int i = 1;i < N; ++i)
        {
            double now = a[i];
            int j;
            for(j = i; j > 0 && less(now, a[j - 1]); --j)
                a[j] = a[j - 1];
            a[j] = now;
        }
    }
    private static boolean less(double a, double b)
    {
        return a < b;
    }
    private static void exch(double [] a, int i, int j)
    {
        double tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
    private static void show(double [] a)
    {
        StdOut.println(Arrays.toString(a));
    }
    private static boolean isSorted(double [] a)
    {
        for(int i = 1; i < a.length; ++i)
        {
            if(less(a[i], a[i - 1])) return false;
        }
        return true;
    }
}
