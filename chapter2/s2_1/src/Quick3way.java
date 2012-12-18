import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: dexctor
 * Date: 12-12-9
 * Time: 下午6:05
 * To change this template use File | Settings | File Templates.
 */
public class Quick3way {
    public static void sort(Comparable[] a)
    {
        StdRandom.shuffle(a);
        sort(a, 0, a.length - 1);
    }
    private static void sort(Comparable[] a, int lo, int hi)
    {
        if(hi <= lo) return;
        int lt = lo;
        int gt = hi;
        int j = lo + 1;
        Comparable v = a[lo];
        while (j <= gt)
        {
            int cmp = a[j].compareTo(v);
            if(cmp == 0) j++;
            else if(cmp < 0) exch(a, lt++, j++);
            else if(cmp > 0) exch(a, gt--, j);
        }
        show(a);
        sort(a, lo, lt - 1);
        sort(a, gt + 1, hi);
    }
    private static boolean less(Comparable a, Comparable b)
    {
        return a.compareTo(b)  < 0;
    }
    private static void exch(Comparable[] a, int i, int j)
    {
        Comparable tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
    private static void show(Comparable[] a)
    {
        StdOut.println(Arrays.toString(a));
    }
    private static boolean isSorted(Comparable[] a)
    {
        for(int i = 1; i < a.length; ++i)
        {
            if(less(a[i], a[i - 1])) return false;
        }
        return true;
    }
    public static void main(String[] args)
    {
        String s = StdIn.readLine();
        String[] ss = s.split(" ");
        StdRandom.shuffle(ss);
        show(ss);
        sort(ss);
        assert isSorted(ss);
        show(ss);
    }
}
