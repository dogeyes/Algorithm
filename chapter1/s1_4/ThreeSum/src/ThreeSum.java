/**
 * Created with IntelliJ IDEA.
 * User: dexctor
 * Date: 12-11-25
 * Time: 下午1:26
 * To change this template use File | Settings | File Templates.
 */
public class ThreeSum {
    public static int count(int[] a)
    {
        int count = 0;
        for(int i  = 0;i < a.length; ++i)
            for(int j = i + 1; j  < a.length; ++j)
                for(int k = j + 1; k < a.length; ++k)
                    if(a[i] + a[j] + a[k] == 0)
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
