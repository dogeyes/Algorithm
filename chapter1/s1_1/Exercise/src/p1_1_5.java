/**
 * Created with IntelliJ IDEA.
 * User: dexctor
 * Date: 12-11-15
 * Time: 上午10:38
 * To change this template use File | Settings | File Templates.
 */
public class p1_1_5 {
    public static boolean foo(double x, double y)
    {
        if(x < 1 && x > 0 && y < 1 && y > 0)
            return true;
        else
            return false;
    }
    public static void main(String[] args)
    {
        double x = StdRandom.uniform() * 2.0;
        double y = StdRandom.uniform() * 2.0;

        StdOut.println(foo(x, y));
    }
}
