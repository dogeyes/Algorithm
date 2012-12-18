import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: dexctor
 * Date: 12-12-13
 * Time: 上午10:33
 * To change this template use File | Settings | File Templates.
 */
public class Select {
    public static <T extends Comparable<T>> T select(T[] items, int k)
    {
        //StdRandom.shuffle(items);
        return select(items, 0, items.length - 1, k);
    }
    private static <T extends Comparable<T>> T select(T[] items, int lo, int hi, int k)
    {
        if(hi == lo)
            return items[lo];
        int j = partition(items, lo, hi);
        if(k == j)
            return items[j];
        if(k < j)
            return select(items, lo, j - 1, k);
        if(k > j)
            return select(items, j + 1, hi, k);
        return null;
    }
    private static <T extends Comparable<T>> int partition(T[] items, int lo, int hi)
    {
        T v = items[lo];
        int i = lo;
        int j = hi + 1;

        while(i < j)
        {
            while(i < hi && items[++i].compareTo(v) < 0);
            while(items[--j].compareTo(v) > 0);
            if(i < j)
            {
                T tmp = items[i];
                items[i] = items[j];
                items[j] = tmp;
            }
        }
        T tmp = items[j];
        items[j] = items[lo];
        items[lo] = tmp;
        return j;
    }
    public static void main(String[] agrs)
    {
        int N = StdIn.readInt();
        Integer[] a = new Integer[N];
        for(int i = 0;i < N; ++i)
            a[i] = i;
        StdRandom.shuffle(a);
        StdOut.println(Arrays.toString(a));
        int k = select(a, N / 2);
        StdOut.println(Arrays.toString(a));
        StdOut.println(k);
    }
}
