/**
 * Created with IntelliJ IDEA.
 * User: dexctor
 * Date: 12-11-15
 * Time: 上午10:53
 * To change this template use File | Settings | File Templates.
 */
public class p1_1_12 {
    public static void main(String[] args)
    {
        int[] a = new int[10];
        for(int i = 0; i < 10; ++i)
            a[i] = 9 - i;
        for(int i = 0; i < 10; ++i)
            a[i] = a[a[i]];
        for(int i: a)
            StdOut.print(i + " ");
    }
}
