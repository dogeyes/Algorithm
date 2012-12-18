import java.util.Arrays;

public class ShellSort {
    public static void sort(Comparable[] a)
    {
        int N = a.length;
        int h = 1;
        while (h < N / 3) h = 3 * h + 1;
        while (h >= 1)
        {
            for(int i = h; i < N; ++i)
            {
                for(int j = i; j >= h && less(a[j], a[j - h]); j -= h)
                    exch(a, j, j - h);
            }
            h = h / 3;
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
