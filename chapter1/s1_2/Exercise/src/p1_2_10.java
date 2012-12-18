/**
 * Created with IntelliJ IDEA.
 * User: dexctor
 * Date: 12-11-21
 * Time: 上午10:04
 * To change this template use File | Settings | File Templates.
 */
public class p1_2_10 {
    public static void main(String[] args)
    {
        VisualCounter counter = new VisualCounter("test", 100, 100);
        for(int i = 0; i < 90; ++i)
            counter.decrement();
    }

}
class VisualCounter
{
    private int count;
    private String name;
    private final int max;
    private final int N;
    private int times;
    public VisualCounter(String name, int max, int N)
    {
        this.name = name;
        this.max = max;
        this.N = N;
        StdDraw.setXscale(0, N);
        StdDraw.setYscale(-max, max);
        StdDraw.setPenRadius(0.0005);
    }
    public void increment()
    {
        count++;
        times++;
        StdDraw.point(times, count);

    }
    public void decrement()
    {
        count--;
        times++;
        StdDraw.point(times, count);
    }
    public int tally()
    {
        return count;
    }
    public String toString()
    {
        return name + ": " + count;
    }
}
