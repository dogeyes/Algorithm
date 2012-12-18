import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: dexctor
 * Date: 12-11-28
 * Time: 上午10:15
 * To change this template use File | Settings | File Templates.
 */
public class FastMergeSort {
    //private static Comparable[] aux; // 多个程序使用MergeSort时会出现问题。
    public static int count;
    public static void sort(Comparable[] a)
    {
        count = 0;
        Comparable[] aux = new Comparable[a.length];
        mergeSort(a, 0, a.length - 1, aux);
    }
    private static void mergeSort(Comparable[] a, int lo, int hi, Comparable[] aux)
    {
        if(lo >= hi)
            return;
        int mid = (lo + hi) / 2;
        mergeSort(a, lo, mid, aux);
        mergeSort(a, mid + 1, hi, aux);
        if(!less(a[mid], a[mid + 1]))
            merge(a, lo, mid, hi, aux);
        count += 2;
    }
    private static void merge(Comparable[] a, int lo, int mid, int hi, Comparable[] aux)
    {
        for(int i = lo; i <= mid; ++i)
            aux[i] = a[i];
        for(int i = hi; i > mid; --i)
            aux[i] = a[hi - i + mid + 1];
        int i = lo;
        int j = hi;
        for(int k = lo; k <= hi; ++k)
        {
            if(less(aux[i], aux[j])) a[k] = aux[i++];
            else  a[k] = aux[j--];
        }
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
