import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: dexctor
 * Date: 12-12-9
 * Time: 下午8:06
 * To change this template use File | Settings | File Templates.
 */
public class Fast3way {
    public static void sort(Comparable[] a)
    {
        StdRandom.shuffle(a);
        sort(a, 0, a.length - 1);
    }
    private static void sort(Comparable[] a, int lo, int hi)
    {
        if(hi <= lo)
            return;
        int p = lo + 1;
        int i = lo + 1;
        int j = hi;
        int q = hi;
        Comparable v = a[lo];
        while(i < j)
        {
            while(i < j && !less(v, a[i]))
            {
                if(less(a[i], v))
                    ++i;
                else
                    exch(a, p++, i++);
            }
            while (j >= i && !less(a[j], v))
            {
                if(less(v, a[j]))
                    j--;
                else
                    exch(a, q--, j--);
            }
            if(i < j)
                exch(a, i++, j--);
        }
        reverse(a, lo, j);
        reverse(a, j + 1, hi);
        sort(a, lo, j - p + lo);
        sort(a, hi - q + j + 1, hi);
    }
    private static void reverse(Comparable[] a, int lo, int hi)
    {
        int mid = (lo + hi) / 2;
        for(int i =lo; i < mid; ++i)
            exch(a, i, hi + lo - i);
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
