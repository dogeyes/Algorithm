import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: dexctor
 * Date: 12-11-20
 * Time: 上午10:12
 * To change this template use File | Settings | File Templates.
 */
public class StaticSETofInts {
    private int[] a;
    public StaticSETofInts(int[] keys)
    {
        int N = keys.length;
        a = new int[N];
        for(int i = 0; i < N; ++i)
            a[i] = keys[i];
        Arrays.sort(a);
    }

    public boolean contains(int key)
    {
        if(rank(key) == -1)
            return false;
        else
            return true;
    }
    private int rank(int key)
    {
        int lo = 0;
        int hi = a.length - 1;
        while(lo <= hi)
        {
            int mid  = (lo + hi) / 2;
            if(key > a[mid])
                lo = mid + 1;
            else if(key < a[mid])
                hi = mid - 1;
            else
                return mid;
        }
        return -1;
    }
    public static void main(String[] args)
    {
        int[] w = In.readInts("in.txt");
        StaticSETofInts set = new StaticSETofInts(w);
        while (!StdIn.isEmpty())
        {
            int key = StdIn.readInt();
            if(set.contains(key))
                StdOut.println(key);
        }
    }
}
