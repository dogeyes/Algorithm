import java.util.Arrays;
import java.util.Collections;

/**
 * Created with IntelliJ IDEA.
 * User: dexctor
 * Date: 12-11-25
 * Time: 下午2:48
 * To change this template use File | Settings | File Templates.
 */
public class p1_4_10 {
    public static int binarySearch(int[] a, int key)
    {
        Arrays.sort(a);
        int lo = 0;
        int hi = a.length - 1;
        while(lo <= hi)
        {
            int mid = (lo + hi) / 2;
            if(a[mid] == key)
            {
                if(mid == lo || a[mid - 1] != key)
                    return mid;
                else
                    hi = mid - 1;
            }
            else if(key < a[mid])
                hi = mid - 1;
            else
                lo = mid + 1;
        }
        return -1;
    }
    public static void main(String[] args)
    {
        int[] a = new int[100];
        for(int i = 0; i < 100; ++i)
        {
            a[i] = StdRandom.uniform(0,10);
        }
        int index = binarySearch(a, 6);
        for(int i = 0; i < 100; ++i)
        {
            StdOut.print(a[i] + " ");
        }
        StdOut.println();
        if(index != 0)
            StdOut.print(a[index - 1] + " ");
        StdOut.print(a[index] + " " );
        if(index != a.length - 1)
            StdOut.println(a[index + 1]);
    }
}
