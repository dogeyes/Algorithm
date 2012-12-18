/**
 * Created with IntelliJ IDEA.
 * User: dexctor
 * Date: 12-11-15
 * Time: 上午10:42
 * To change this template use File | Settings | File Templates.
 */
public class p1_1_7 {
    public static void main(String[] args)
    {
        double t = 9.0;
        while (Math.abs(t - 9.0 / t) > 0.001)
        {
            t = (t + 9.0 / t) / 2;
        }
        StdOut.printf("%.5f\n", t);

        int sum = 0;
        for(int i = 1; i < 1000; ++i)
            for(int j = 0; j <  i ; ++j)
                sum++;
        StdOut.println(sum);

        sum = 0;
        for(int i = 1; i < 1000; i *= 2)
            for(int j = 0; j < 10; ++j)
            {
                sum++;
            }

        StdOut.println(sum);
    }
}
