import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: dexctor
 * Date: 12-12-9
 * Time: 下午7:11
 * To change this template use File | Settings | File Templates.
 */
public class BestCaseGenerator {

    public static int[] generator(int N)
    {
        int[] a = new int[N];
        for(int i = 0; i < N; ++i)
            a[i] = i;
        generator(a, 0, N - 1);
        return a;
    }
    private static void generator(int[] a, int lo, int hi)
    {
        if(hi <= lo)
            return;
        int mid = (lo + hi) / 2;
        int key = a[mid];
        for(int i = mid; i > lo; --i)
            a[i] = a[i - 1];
        a[lo] = key;
        generator(a, lo + 1, mid);
        generator(a, mid + 1, hi);
    }
    private static void show(int[] a)
    {
        StdOut.println(Arrays.toString(a));
    }
    public static void main(String[] args)
    {
        int[] a = generator(20);
        show(a);
    }

}
