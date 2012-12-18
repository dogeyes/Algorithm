/**
 * Created with IntelliJ IDEA.
 * User: dexctor
 * Date: 12-11-20
 * Time: 上午10:04
 * To change this template use File | Settings | File Templates.
 */
public class Counter {
    private int count;
    private final String name;

    public Counter(String name)
    {
        this.name = name;
    }
    public void increment()
    {
        count++;
    }
    public int tally()
    {
        return count;
    }
    public String toString()
    {
        return count + " " + name;
    }

    public static void main(String[] args)
    {
        Counter heads = new Counter("heads");
        Counter tails = new Counter("tails");

        heads.increment();
        heads.increment();

        tails.increment();

        StdOut.println(heads);
        StdOut.println(tails);

    }
}
