import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: dexctor
 * Date: 12-11-26
 * Time: 下午8:19
 * To change this template use File | Settings | File Templates.
 */
public class MergeSort {
    //private static Comparable[] aux; // 多个程序使用MergeSort时会出现问题。
    public static int count;
    public static int sort(Comparable[] a)
    {
        count = 0;
        Comparable[] aux = new Comparable[a.length];

        return mergeSort(a, 0, a.length - 1, aux);
    }
    private static int mergeSort(Comparable[] a, int lo, int hi, Comparable[] aux)
    {
        int inversionCount = 0;
        if(lo >= hi)
            return 0;
        int mid = (lo + hi) / 2;
        inversionCount += mergeSort(a, lo, mid, aux);
        inversionCount += mergeSort(a, mid + 1, hi, aux);
        if(!less(a[mid], a[mid + 1]))
            inversionCount += merge(a, lo, mid, hi, aux);
        count += 2;
        return inversionCount;
    }
    private static int merge(Comparable[] a, int lo, int mid, int hi, Comparable[] aux)
    {
        int inversionCount = 0;
        //Comparable[] aux = new Comparable[hi - lo + 1]; //每次都开数组耗时很大，甚至会变成耗时的主要因素
        for(int i = lo; i <= hi; ++i)
            aux[i - lo] = a[i];
        count += (hi -lo + 1) * 2;
        int i = 0;
        int j = mid + 1 - lo;
        for(int k = lo; k <= hi; ++k)
        {
            if(i > mid - lo) { a[k] = aux[j++]; count += 2;}
            else if(j > hi - lo) { a[k] = aux[i++]; count += 2; inversionCount += hi - mid; }
            else if(less(aux[i], aux[j])) { a[k] = aux[i++]; count += 4; inversionCount += j - mid - 1 + lo;}
            else { a[k] = aux[j++]; count += 4;}
        }
        return inversionCount;
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
        StdOut.println(sort(ss));
        assert isSorted(ss);
        show(ss);
    }
}
