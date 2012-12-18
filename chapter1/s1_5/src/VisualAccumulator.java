/**
 * Created with IntelliJ IDEA.
 * User: daixing
 * Date: 12-11-25
 * Time: 下午11:41
 * To change this template use File | Settings | File Templates.
 */
public class VisualAccumulator {
    private int N;
    private double total;
    public VisualAccumulator(int trials, double max)
    {
        StdDraw.setXscale(0, trials);
        StdDraw.setYscale(0, max);
        StdDraw.setPenRadius(0.005);
    }
    public void addDateValue(double value)
    {
        total += value;
        N++;
        StdDraw.setPenColor(StdDraw.GRAY);
        StdDraw.point(N, value);
        StdDraw.setPenColor(StdDraw.RED);
        StdDraw.point(N, total / N);

    }
}
