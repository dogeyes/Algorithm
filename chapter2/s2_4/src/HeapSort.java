import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: dexctor
 * Date: 12-12-10
 * Time: 上午10:27
 * To change this template use File | Settings | File Templates.
 */
public class HeapSort {

    public static void sort(Comparable[] a)//貌似a[0]排不进去了
    {
        int N = a.length - 1;
        for(int i = N / 2; i >= 1; --i)
            sink(a, i, N);
        StdOut.println(Arrays.toString(a));
        for(int i = 1; i < a.length; ++i)
        {
            exch(a, 1, N--);
            sink(a, 1, N);
        }
    }
    public static void sink(Comparable[] a, int k, int N)
    {
        while(2 * k <= N)
        {
            int next = 2 * k;
            if(next < N && less(a[next], a[next + 1])) next++;
            if(!less(a[k], a[next])) break;
            exch(a, k, next);
            k = next;
        }
    }
    private static boolean less(Comparable a, Comparable b)
    {
        return a.compareTo(b) < 0;
    }
    private static void exch(Comparable[] a, int i, int j)
    {
        Comparable tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
    public static void main(String[] args)
    {
        int N = StdIn.readInt();
        Integer[] a = new Integer[N];
        for(int i = 0; i < N; ++i)
            a[i] = i;
        StdRandom.shuffle(a);
        StdOut.println(Arrays.toString(a));
        sort(a);
        StdOut.println(Arrays.toString(a));
    }
}
