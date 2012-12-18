import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: dexctor
 * Date: 12-12-9
 * Time: 下午6:50
 * To change this template use File | Settings | File Templates.
 */
public class NutsAndBolts {
    public static void pair(int[] nuts, int[] bolts)
    {
        pair(nuts, bolts, 0, nuts.length - 1);
    }

    private static void pair(int[] nuts, int[] bolts, int lo, int hi)
    {
        if(hi <= lo)
            return;

        int keyNut = nuts[lo];
        int j = partition(bolts, lo, hi, keyNut);
        int keyBolt = bolts[j];
        partition(nuts, lo, hi, keyBolt);
        pair(nuts, bolts, lo, j - 1);
        pair(nuts, bolts, j + 1, hi);
    }
    private static int partition(int[] a, int lo, int hi, int key)
    {
        int lt = lo;
        int gt = hi;
        int i = lo;
        while (i <= gt)
        {
            if(key < a[i])
                exch(a, lt++, i++);
            else if(key > a[i])
                exch(a, gt--, i);
            else i++;
        }
        return lt;
    }
    private static void exch(int[] a, int i, int j)
    {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
    private static void print(int[] a)
    {
        StdOut.println(Arrays.toString(a));
    }
    public static void  main(String[] args)
    {
        int N = 20;
        int[] nuts = new int[N];
        int[] bolts = new int[N];
        for(int i = 0; i < N;++i)
        {
            nuts[i] = i;
            bolts[i] = i;
        }
        StdRandom.shuffle(nuts);
        StdRandom.shuffle(bolts);

        print(nuts);
        print(bolts);

        pair(nuts, bolts);

        print(nuts);
        print(bolts);
    }
}
