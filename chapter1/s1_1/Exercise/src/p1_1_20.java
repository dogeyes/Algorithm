/**
 * Created with IntelliJ IDEA.
 * User: dexctor
 * Date: 12-11-15
 * Time: 下午12:12
 * To change this template use File | Settings | File Templates.
 */
public class p1_1_20 {
    public static double lnN(int n)
    {
        if(n == 1)
            return 0.0;
        return Math.log(n) + lnN(n - 1);
    }
    public static void  main(String[] args)
    {
        int n = StdIn.readInt();

        StdOut.println(lnN(n));
    }
}
