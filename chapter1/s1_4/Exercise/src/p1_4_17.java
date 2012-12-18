import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: dexctor
 * Date: 12-11-25
 * Time: 下午3:50
 * To change this template use File | Settings | File Templates.
 */
public class p1_4_17 {
    public static int farthestPair(int[] a)
    {
        int max = a[0];
        int min = a[0];
        for(int i = 1; i < a.length; ++i)
            if(a[i] > max)
                max = a[i];
            else if(a[i] < min)
                min = a[i];
        return max - min;
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
        StdOut.println(farthestPair(a));
        Arrays.sort(a);
        StdOut.println(Arrays.toString(a));
    }
}
