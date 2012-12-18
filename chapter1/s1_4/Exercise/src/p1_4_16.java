import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: dexctor
 * Date: 12-11-25
 * Time: 下午3:43
 * To change this template use File | Settings | File Templates.
 */
public class p1_4_16 {
    public static double closestPair(int[] a)
    {
        Arrays.sort(a);
        double min = Math.abs(a[1] - a[0]);
        for(int i = 2; i < a.length; ++i)
            if(Math.abs(a[i] - a[i - 1]) < min)
                min = Math.abs(a[i] - a[i - 1]);
        return min;
    }
    public static int[] randomGenerate(int N)
    {
        int[] a = new int[N];
        for(int i = 0; i < N; ++i)
            a[i] = StdRandom.uniform(-1000* N, 1000* N);
        return a;
    }
    public static void main(String[] args)
    {
        int[] a = randomGenerate(100);
        StdOut.println(closestPair(a));
        StdOut.println(Arrays.toString(a));
    }
}
