import javax.naming.event.NamingListener;
import java.util.Arrays;
import java.util.Collections;

/**
 * Created with IntelliJ IDEA.
 * User: dexctor
 * Date: 12-11-15
 * Time: 上午9:59
 * To change this template use File | Settings | File Templates.
 */
public class Algs4Test6 {
    public static void main(String[] args)
    {
        int N = 30;
        double [] a = new double[30];
        for(int i = 0; i < N; ++i)
        {
            a[i] = StdRandom.uniform();
        }
        Arrays.sort(a);
        for(int i = 0; i < N; ++i)
        {
            double x = 1.0 * i / N;
            double y = a[i] / 2.0;
            double rw = 0.5 / N;
            double rh = a[i] / 2.0;
            StdDraw.filledRectangle(x, y, rw, rh);
        }
    }
}
