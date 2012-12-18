/**
 * Created with IntelliJ IDEA.
 * User: dexctor
 * Date: 12-11-15
 * Time: 上午9:38
 * To change this template use File | Settings | File Templates.
 */
public class Algs4Test3 {
    public static void main(String[] args)
    {
        double sum = 0.0;
        int cnt = 0;

        while (!StdIn.isEmpty())
        {
            sum += StdIn.readDouble();
            cnt++;
        }
        double avg  =  sum / cnt;
        StdOut.printf("Average is %.5f\n", avg);
    }
}
