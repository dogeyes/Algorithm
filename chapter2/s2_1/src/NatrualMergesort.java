import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: dexctor
 * Date: 12-11-28
 * Time: 下午1:24
 * To change this template use File | Settings | File Templates.
 */
public class NatrualMergesort {
    public static void sort(Comparable[] a)
    {
        Comparable[] aux = new Comparable[a.length];
        int N = a.length;
        while(true)
        {
            int lo = 0;
            int mid = 0;
            int hi = 0;
            while(mid < N - 1 && less(a[mid], a[mid + 1]))
                mid++;
            if(mid == N - 1)
                return;
            while(true)
            {
                hi = mid + 1;
                while(hi < N - 1 && less(a[hi], a[mid + 1]))
                    hi++;
                if(hi > N - 1)
                    break;
                merge(a, lo, mid, hi, aux);
                lo = hi + 1;
                mid = lo;
                while(mid < N - 1 && less(a[mid], a[mid + 1]))
                    mid++;
                if(mid >= N - 1)
                    break;
            }
        }
    }
    private static void merge(Comparable[] a, int lo, int mid, int hi, Comparable[] aux)
    {
        //Comparable[] aux = new Comparable[hi - lo + 1]; //每次都开数组耗时很大，甚至会变成耗时的主要因素
        for(int i = lo; i <= hi; ++i)
            aux[i - lo] = a[i];
        int i = 0;
        int j = mid + 1 - lo;
        for(int k = lo; k <= hi; ++k)
        {
            if(i > mid - lo) { a[k] = aux[j++];}
            else if(j > hi - lo) { a[k] = aux[i++];}
            else if(less(aux[i], aux[j])) {a[k] = aux[i++];}
            else { a[k] = aux[j++];}
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
