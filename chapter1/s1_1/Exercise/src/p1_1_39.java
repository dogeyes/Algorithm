import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: daixing
 * Date: 12-11-16
 * Time: 上午12:02
 * To change this template use File | Settings | File Templates.
 */
public class p1_1_39 {
    public static void main(String[] args)
    {
        int N = 1000000;
        int[] a = new int[N];
        int[] b = new int[N];
        for(int i = 0; i < N; ++i)
        {
            a[i] = StdRandom.uniform(100000, 1000000);
            b[i] = StdRandom.uniform(100000, 1000000);
        }
        Arrays.sort(a);
        Arrays.sort(b);
        int sum = 0;
        for(int i = 0; i < N; ++i)
        {
            if(Arrays.binarySearch(b, a[i]) >= 0)
                sum ++;
        }
        StdOut.println(sum);
    }
}
