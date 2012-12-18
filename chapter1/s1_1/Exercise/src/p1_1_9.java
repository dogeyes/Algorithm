/**
 * Created with IntelliJ IDEA.
 * User: dexctor
 * Date: 12-11-15
 * Time: 上午10:48
 * To change this template use File | Settings | File Templates.
 */
public class p1_1_9 {
    public static void main(String[] args)
    {
        int N = StdIn.readInt();
        String s = "";
        for(int n = N; n > 0; n /= 2)
        {
            s = (n % 2) + s;
        }
        StdOut.println(s);
    }
}
