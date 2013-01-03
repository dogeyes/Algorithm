import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: dexctor
 * Date: 13-1-3
 * Time: 下午3:21
 * To change this template use File | Settings | File Templates.
 */
public class ArrayQuick3Way {
    public static void sort(int[][] a)
    {
        lenSort(a, 0, a.length - 1, 0);
    }
    private static void lenSort(int[][] a, int lo, int hi, int d)
    {
        if(hi <= lo)
            return;
        int lt = lo;
        int gt = hi;
        int v = a[lo].length;
        int i = lo + 1;
        while (i <= gt)
        {
            int t = a[i].length;
            if(t < v)
                exch(a, i++, lt++);
            else if(t > v)
                exch(a, gt--, i);
            else i++;
        }
        lenSort(a, lo, lt - 1, d);
        if(v != -1)
            sort(a, lt, gt, d);
        lenSort(a, gt + 1, hi, d);
    }
    private static void sort(int[][] a, int lo, int hi, int d)
    {
        if(hi <= lo)
            return;
        int lt = lo;
        int gt = hi;
        int v = valueAt(a[lo], d);
        int i = lo + 1;
        while (i <= gt)
        {
            int t = valueAt(a[i], d);
            if(t < v)
                exch(a, i++, lt++);
            else if(t > v)
                exch(a, gt--, i);
            else i++;
        }
        sort(a, lo, lt - 1, d);
        if(v != -1)
            sort(a, lt, gt, d + 1);
        sort(a, gt + 1, hi, d);
    }
    private static void exch(int[][] a, int i, int j)
    {
        int[] tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
    private static int valueAt(int[] a, int d)
    {
        if(d < a.length)
            return a[d];
        else
            return -1;
    }
    public static void main(String[] args)
    {
        In in = new In("array.txt");
        int N = in.readInt(); in.readLine();
        int[][] a = new int[N][];
        for(int i = 0; i < N; ++i)
        {
            String[] ss = in.readLine().split(" ");
            a[i] = new int[ss.length];
            for(int j = 0; j < ss.length; ++j)
                a[i][j] = Integer.parseInt(ss[j]);
            StdOut.println(Arrays.toString(a[i]));
        }
        sort(a);
        StdOut.println();
        for(int i = 0; i < N; ++i)
        {
            StdOut.println(Arrays.toString(a[i]));
        }
    }
}
