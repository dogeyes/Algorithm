/**
 * Created with IntelliJ IDEA.
 * User: dexctor
 * Date: 12-11-15
 * Time: 上午9:55
 * To change this template use File | Settings | File Templates.
 */
public class Alg4Test5 {
    public static void main(String[] args)
    {
        int N = 100;
        StdDraw.setXscale(0, N);
        StdDraw.setYscale(0, N * N);
        StdDraw.setPenRadius(0.01);
        for(int i = 0 ; i  < N; ++i)
        {
            StdDraw.point(i, i);
            StdDraw.point(i, i * i);
            StdDraw.point(i, i * Math.log(i));
        }
    }
}
