import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: dexctor
 * Date: 12-11-25
 * Time: 下午1:48
 * To change this template use File | Settings | File Templates.
 */
public class FastThreeSum {
    public static int count(int[] a)
    {
        int count = 0;
        Arrays.sort(a);
        for(int i  = 0;i < a.length; ++i)
            for(int j = i + 1; j  < a.length; ++j)
                    if(Arrays.binarySearch(a,-a[i] - a[j]) > j)
                        count++;
        return count;
    }
    public static void main(String[] args)
    {
        String file = StdIn.readString();
        int[] a = In.readInts(file);
        Stopwatch timer = new Stopwatch();
        StdOut.println(count(a));
        StdOut.println(timer.elapsedTime());
    }
}
