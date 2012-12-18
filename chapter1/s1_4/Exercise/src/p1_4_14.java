import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: dexctor
 * Date: 12-11-25
 * Time: 下午3:25
 * To change this template use File | Settings | File Templates.
 */
public class p1_4_14 {
    public static int fourSum(int[ ] a)
    {
        int cnt = 0;
        Arrays.sort(a);
        for(int i = 0; i < a.length; ++i)
            for(int j = i + 1; j < a.length; ++j)
                for(int k = j + 1; k < a.length; ++k)
                     if(Arrays.binarySearch(a, - a[i] - a[j] - a[k]) > k)
                         cnt++;
        return cnt;
    }
    public static void main(String[] args)
    {
        int[] a = new int[100];
        for(int i = 0; i < 100; ++i)
            a[i] = StdRandom.uniform(-100, 100);
        StdOut.println(fourSum(a));
    }
}
