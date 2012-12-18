import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: dexctor
 * Date: 12-12-3
 * Time: 下午6:59
 * To change this template use File | Settings | File Templates.
 */
public class IndirectSort {
    public static void sort(Comparable[] a)
    {
        int[] index = indirectSort(a, 0, a.length - 1);
        for(int i = 0; i < index.length; ++i)
            StdOut.print(index[i] + " ");
        StdOut.println( );
    }
    public static int[] indirectSort(Comparable[] a, int lo, int hi)
    {
        int[] index = new int[hi - lo + 1];
        if(lo > hi)
            return index;
        else if(lo == hi)
        {
            index[0] = lo;
            return index;
        }
        int mid = (lo + hi) / 2;
        int[] index1 = indirectSort(a, lo, mid);
        int[] index2 = indirectSort(a, mid + 1, hi);
        mergeIndex(index, index1, index2, a);
        return index;
    }
    public static void mergeIndex(int[] index, int[] index1, int[] index2, Comparable[] a)
    {
        int i = 0;
        int j = 0;
        for(int k = 0; k < index.length; ++k)
        {
            if(i >= index1.length)  index[k] = index2[j++];
            else if(j >= index2.length) index[k] = index1[i++];
            else if(less(a[index1[i]], a[index2[j]])) index[k] = index1[i++];
            else index[k] = index2[j++];
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
