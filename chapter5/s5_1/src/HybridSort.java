import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: dexctor
 * Date: 13-1-3
 * Time: 下午3:11
 * To change this template use File | Settings | File Templates.
 */
public class HybridSort {
    static String[] aux;
    static int cutoff;

    public static void sort(String[] a)
    {
        int N = a.length;
        aux = new String[N];
        cutoff = 3;
        MSDsort(a, 0, N - 1, 0);
    }

    private static void threeWaySort(String[] a, int lo, int hi, int d)
    {
        if(hi <= lo + cutoff)
        {
            insertionSort(a, lo, hi, d);
            return;
        }
        int lt = lo;
        int gt = hi;
        int v = charAt(a[lo], d);
        int i = lo + 1;
        while (i <= gt)
        {
            int t = charAt(a[i], d);
            if(t < v) exch(a, lt++, i++);
            else if(t > v) exch(a, gt--, i);
            else i++;
        }
        threeWaySort(a, lo, lt - 1, d);
        if(v != -1)
            threeWaySort(a, lt, gt, d + 1);
        threeWaySort(a, gt + 1, hi, d);
    }
    private static void MSDsort(String[] a, int lo, int hi, int w)
    {
        if(hi <= lo + cutoff )
        {
            threeWaySort(a, lo, hi, w);
            return;
        }
        int R = 256;
        int[] count = new int[R + 2];
        for(int i = lo; i <= hi; ++i)
            count[charAt(a[i], w) + 2]++;
        for(int i = 0; i < R + 1; ++i)
            count[i + 1] += count[i];
        for(int i = lo; i <= hi; ++i)
            aux[(count[charAt(a[i],w) + 1] ++) + lo] = a[i];
        for(int i = lo; i <= hi; ++i)
            a[i] = aux[i];
        for(int i = 0; i < R; ++i)
            MSDsort(a, lo + count[i], lo + count[i + 1] - 1, w + 1);
    }
    private static int charAt(String a, int w)
    {
        if(w < a.length())
            return a.charAt(w);
        else
            return -1;
    }
    public static void insertionSort(String[] a, int lo, int hi, int w)
    {
        for(int i = lo;  i <= hi; ++i)
        {
            for(int j = i; j > lo && a[j].substring(w).compareTo(a[j - 1].substring(w)) < 0; j--)
                exch(a, j, j - 1);
        }
    }
    private static void exch(String[] a, int i, int j)
    {
        String tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
    public static void main(String[] args)
    {
        In in = new In("shells.txt");
        int N = 14;
        String[] a = new String[N];
        for(int i = 0;i < N; ++i)
        {
            a[i] = in.readString();
        }
        sort(a);
        StdOut.println(Arrays.toString(a));

        StdRandom.shuffle(a);
        insertionSort(a, 0, N - 1, 0);
        StdOut.println(Arrays.toString(a));
    }
}
