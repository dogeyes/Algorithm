import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: dexctor
 * Date: 12-11-25
 * Time: 下午4:25
 * To change this template use File | Settings | File Templates.
 */
public class p1_4_20 {
    public static int bitonicSearch(int[] a, int key)
    {
        int lo = 0;
        int hi = a.length - 1;
        int mid = (lo + hi) / 2;
        while (mid != lo && mid != hi && (! (a[mid] > a[mid - 1] && a[mid] > a[mid + 1])))
        {
            mid = (lo + hi) / 2;
            if(a[mid] < a[mid + 1])
                lo = mid + 1;
            else
                if(a[mid] < a[mid - 1])
                    hi = mid - 1;
        }
        if(a[mid] == key)
            return mid;
        lo = 0;
        hi = mid - 1;
        while (lo <= hi)
        {
            int mid1 = (lo + hi) / 2;
            if(a[mid1] == key)
                return mid1;
            else if(key < a[mid1])
                hi = mid1 - 1;
            else if(key > a[mid1])
                lo = mid1 + 1;
        }
        lo = mid + 1;
        hi = a.length - 1;
        while (lo <= hi)
        {
            int mid1 = (lo + hi) / 2;
            if(a[mid1] == key)
                return mid1;
            else if(key > a[mid1])
                hi = mid1 - 1;
            else if(key < a[mid1])
                lo = mid1 + 1;
        }
        return  - 1;
    }
    public static void main(String[] args)
    {
        int[] a= new int[20];
        for(int i = 0; i < 10; ++i)
        {
            a[i] = i * 2 + 1;
        }
        for(int i = 10; i < 20; ++i)
        {
            a[i] = (20 - i) * 2;
        }
        StdOut.println(Arrays.toString(a));
        while (!StdIn.isEmpty())
        {
            int tmp = StdIn.readInt();
            StdOut.println(bitonicSearch(a, tmp));
        }
    }
}
