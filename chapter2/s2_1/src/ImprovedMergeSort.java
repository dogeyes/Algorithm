import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: dexctor
 * Date: 12-11-28
 * Time: 上午10:49
 * To change this template use File | Settings | File Templates.
 */
public class ImprovedMergeSort {
    public static int count;
    public static void sort(Comparable[] a)
    {
        count = 0;
        Comparable[] aux = new Comparable[a.length];
        for(int i = 0; i < a.length; ++i)
            aux[i] = a[i];

        mergeSort(aux, 0, a.length - 1, a);
    }
    private static void mergeSort(Comparable[] a, int lo, int hi, Comparable[] aux)
    {
        if(lo >= hi)
            return;
        if(hi - lo < 15)
        {
            InsertionSort.sort(aux, lo, hi);
            return;
        }
        int mid = (lo + hi) / 2;
        mergeSort(aux, lo, mid, a);
        mergeSort(aux, mid + 1, hi, a);
        /*if(!less(a[mid], a[mid + 1]))
        {
            merge(a, lo, mid, hi, aux);
        }*/
        merge(a, lo, mid, hi, aux);
        count += 2;
    }
    private static void merge(Comparable[] a, int lo, int mid, int hi, Comparable[] aux)
    {
        //Comparable[] aux = new Comparable[hi - lo + 1]; //每次都开数组耗时很大，甚至会变成耗时的主要因素
        //for(int i = lo; i <= hi; ++i)
            //aux[i - lo] = a[i];
        int i = lo;
        int j = mid+1;
        for(int k = lo; k <= hi; ++k)
        {
            if(i > mid) aux[k] = a[j++];
            else if(j > hi) aux[k] = a[i++];
            else if(less(a[i], a[j])) aux[k] = a[i++];
            else aux[k] = a[j++];
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
        int N = StdIn.readInt();
        Integer[] a = new Integer[N];
        for(int i = 0; i < N; ++i)
            a[i] = i;
        StdRandom.shuffle(a);
        show(a);
        sort(a);
        assert isSorted(a);
        show(a);
    }
}
