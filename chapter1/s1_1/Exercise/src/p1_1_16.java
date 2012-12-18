/**
 * Created with IntelliJ IDEA.
 * User: dexctor
 * Date: 12-11-15
 * Time: 上午10:59
 * To change this template use File | Settings | File Templates.
 */
public class p1_1_16 {
    public static String exR1(int n)
    {
        if(n <= 0) return "";
        return exR1(n - 3) + n + exR1(n - 2) + n;
    }
    public static void main(String[] args)
    {
        StdOut.print(exR1(6));
    }
}
