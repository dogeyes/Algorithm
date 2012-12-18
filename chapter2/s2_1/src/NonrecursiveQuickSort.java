import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: dexctor
 * Date: 12-12-9
 * Time: 下午7:50
 * To change this template use File | Settings | File Templates.
 */
public class NonrecursiveQuickSort {
    static private class Range
    {
        public Range(int lo, int hi)
        {
            this.lo = lo;
            this.hi = hi;
        }
        int lo;
        int hi;
    }
    public static void sort(Comparable[] a)
    {
        Stack<Range> stack = new Stack<Range>();
        Range now = new Range(0, a.length - 1);
        stack.push(now);
        while(!stack.isEmpty())
        {
            now = stack.pop();
            int lo = now.lo;
            int hi = now.hi;
            if(hi <= lo)
                continue;
            int i = parition(a, now.lo, now.hi);
            stack.push(new Range(i + 1, now.hi));
            stack.push(new Range(now.lo, i - 1));
        }
    }
    private static int parition(Comparable[] a, int lo, int hi)
    {
        int i = lo;
        int j = hi + 1;
        Comparable v = a[lo];
        while(i < j)
        {
            while(i < hi && less(a[++i], v));

            while(less(v, a[--j]));
            if(i < j)
                exch(a, i, j);
        }
        exch(a, lo, j);
        return j;
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
