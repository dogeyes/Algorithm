/**
 * Created with IntelliJ IDEA.
 * User: daixing
 * Date: 12-11-15
 * Time: 下午10:53
 * To change this template use File | Settings | File Templates.
 */
public class p1_1_32 {
    public static void main(String[] args)
    {
        int l = 0;
        int r = 1;
        int N = StdIn.readInt();
        int num = 10000;
        int[] a = new int[N];

        for(int i = 0; i < num; i ++)
        {
            a[(int)(StdRandom.uniform() * N)]++;
        }

        double w = 1.0 / N;
        for(int i = 0; i < N; ++i)
        {
            double h = (double)a[i] / num;
            double x = (double)i / N + w /2;
            double y = h / 2;
            StdDraw.filledRectangle(x, y, w / 2, h / 2);
        }
    }
}
