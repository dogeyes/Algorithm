import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: dexctor
 * Date: 12-12-14
 * Time: 下午12:56
 * To change this template use File | Settings | File Templates.
 */
public class p2_5_27 {
    public static int[] sort(Comparable[] a)
    {
        int N = a.length;
        int[] index = new int[N];
        for(int i = 0; i < N; ++i)
            index[i] = i;
        for(int i = 1; i < N; ++i)
        {
            int j = i;
            while (j > 0 && less(a[index[j]], a[index[j - 1]]))
            {
                exch(index, j, j - 1);
                j--;
            }
        }
        return index;
    }
    private static void exch(int[] index, int i, int j)
    {
        int tmp = index[i];
        index[i] = index[j];
        index[j] = tmp;
    }
    private static boolean less(Comparable i, Comparable j)
    {
        return i.compareTo(j) < 0;
    }
    public static void main(String[] args)
    {
        int N = StdIn.readInt();
        Integer [] a = new Integer[N];
        for(int i = 0; i < N; ++i)
            a[i] = i;
        StdRandom.shuffle(a);
        StdOut.println(Arrays.toString(a));
        int [] index;
        index = sort(a);
        StdOut.println(Arrays.toString(index));
    }
}
