/**
 * Created with IntelliJ IDEA.
 * User: dexctor
 * Date: 12-11-24
 * Time: 下午3:17
 * To change this template use File | Settings | File Templates.
 */
public class p1_3_45 {
    public static void main(String[] args)
    {
        int n = StdIn.readInt();
        int max = 0;
        int min = Integer.MAX_VALUE;
        for(int i = 0;i < n; ++i)
        {
            int now = StdIn.readInt();
            if(now < max && now > min)
            {
                StdOut.println("Impossible");
                return;
            }
            if(now > max)
                max = now;
            if(now < min)
                min = now;
        }
        StdOut.println("Possible");
    }
}
