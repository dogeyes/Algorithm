/**
 * Created with IntelliJ IDEA.
 * User: dexctor
 * Date: 12-11-15
 * Time: 上午10:55
 * To change this template use File | Settings | File Templates.
 */
public class p1_1_14 {
    public static void main(String[] args)
    {
        int N = StdIn.readInt();
        int lg1 = 0;
        int lg2 = 0;
        int mul = 1;
        while(mul < N)
        {
            lg1 =lg2;
            lg2++;
            mul *= 2;
        }
        StdOut.println(Math.pow(2, lg1) + " " + Math.pow(2, lg2));
    }
}
