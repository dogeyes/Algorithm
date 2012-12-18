import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: dexctor
 * Date: 12-11-26
 * Time: 下午2:12
 * To change this template use File | Settings | File Templates.
 */
public class VisualInsertionSort {
    public static void sort(Comparable[] a)
    {
        int N = a.length;
        for(int i = 1;i < N; ++i)
        {
            Comparable now = a[i];
            int j;
            for(j = i; j > 0 && less(now, a[j - 1]); --j)
                a[j] = a[j - 1];
            a[j] = now;
            show(a, j, j + 1, i);
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
    private static void show(Comparable[] a, int red, int grays, int graye)
    {
        int N = a.length;
        StdOut.println(Arrays.toString(a));
        StdDraw.clear();
        for(int i = 0; i < N; ++i)
        {
            double  x = i;
            double  y = 0;
            double width = 1;
            double height = (Double)a[i];
            if(i == red)
            {
                StdDraw.setPenColor(StdDraw.RED);
                StdDraw.filledRectangle(x, height / 2, width / 2, height / 2);
                StdDraw.setPenColor();
            }else if(i >= grays && i <= graye)
            {
                StdDraw.setPenColor(StdDraw.BLACK);
                StdDraw.filledRectangle(x, height / 2, width / 2, height / 2);
                StdDraw.setPenColor();
            }
            else
            {
                StdDraw.setPenColor(StdDraw.GRAY);
                StdDraw.filledRectangle(x, height / 2, width / 2, height / 2);
                StdDraw.setPenColor();
            }
        }
        Stopwatch timer = new Stopwatch();
        try
        {
            Thread.sleep(1000);
        }catch (Exception e)
        {

        }
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
        Double[] a = new Double[N];
        double max = Double.MIN_VALUE;
        double min = Double.MAX_VALUE;
        for(int i = 0; i < N; ++i)
        {
            a[i] = StdRandom.uniform();
            if(a[i] > max)
                max = a[i];
            if(a[i] < min)
                min = a[i];
        }
        StdDraw.setYscale(min, max);
        StdDraw.setXscale(0,N);
        StdDraw.setPenRadius(0.005);
        sort(a);
        assert isSorted(a);
        show(a, -1, -1, -1);
    }
}
