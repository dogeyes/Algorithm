import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: dexctor
 * Date: 13-1-3
 * Time: 下午4:23
 * To change this template use File | Settings | File Templates.
 */
public class InPlaceKeyIndexedCounting {
    public static void main(String[] args)
    {
        In in = new In("num.txt");
        int n = in.readInt();
        int[] a = new int[n];
        int maxNum = 0;
        for(int i = 0; i < n; ++i)
        {
            a[i] = in.readInt();
            if(a[i] > maxNum)
                maxNum = a[i];
        }
        maxNum++;
        int[] count = new int[maxNum + 1];
        for(int i = 0; i < n; ++i)
            count[a[i]] ++;
        int i = 0;
        for(int j = 0; j < maxNum; ++j)
        {
            while (count[j]-- > 0)
                a[i++] = j;
        }

        StdOut.println(Arrays.toString(a));

    }
    private static void exch(int[] a, int i, int j)
    {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
}
