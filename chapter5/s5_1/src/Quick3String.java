import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: dexctor
 * Date: 13-1-3
 * Time: 下午1:52
 * To change this template use File | Settings | File Templates.
 */
public class Quick3String {

    private static int cutoff;

    public static void sort(String[] a)
    {
        cutoff = 0;
        sort(a, 0, a.length - 1, 0);
    }
    private static void sort(String[] a, int lo, int hi, int d)
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
        sort(a, lo, lt - 1, d);
        if(v != -1)
            sort(a, lt, gt, d + 1);
        sort(a, gt + 1, hi, d);
    }

    private static int charAt(String a, int d)
    {
        if(d < a.length())
            return a.charAt(d);
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
        In in = new In("shells1.txt");
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
