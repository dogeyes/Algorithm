import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: dexctor
 * Date: 12-11-26
 * Time: 下午8:37
 * To change this template use File | Settings | File Templates.
 */
public class BottomUpMergeSort {
    //private static Comparable[] aux;
    public static int count; //记录array access的次数
    public static void sort(Comparable[] a)
    {
        Comparable[] aux = new Comparable[a.length];
        count = 0;
        int N = a.length;
        for(int span = 1; span < N; span += span)
        {
            for(int lo = 0; lo < N - span; lo = lo + span * 2)
                merge(a, lo, lo + span - 1, Math.min(lo + span * 2 - 1, N - 1), aux);
        }
    }
    private static void merge(Comparable[] a, int lo, int mid, int hi, Comparable[] aux)
    {
        //Comparable[] aux = new Comparable[hi - lo + 1];   //这样实现不是很好，新建数组花费时间远多于合并的过程，使用外部aux

        for(int i = lo; i <= hi; ++i)
            aux[i - lo] = a[i];
        count += (hi - lo + 1) * 2;
        int i = 0;
        int j = mid + 1 - lo;
        for(int k = lo; k <= hi; ++k)
        {
            if(i > mid - lo) { a[k] = aux[j++];count += 2;}
            else if(j > hi - lo) {a[k] = aux[i++]; count += 2;}
            else if(less(aux[i], aux[j])) { a[k] = aux[i++]; count += 4;}
            else { a[k] = aux[j++]; count += 4;}
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
