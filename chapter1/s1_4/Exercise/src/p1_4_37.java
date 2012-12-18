import javax.naming.event.NamingListener;

/**
 * Created with IntelliJ IDEA.
 * User: daixing
 * Date: 12-11-25
 * Time: 下午8:49
 * To change this template use File | Settings | File Templates.
 */
public class p1_4_37 {
    public static double nongenericTrial(int N)
    {
        FixedCapacityStackOfInt stack = new FixedCapacityStackOfInt(N);
        Stopwatch timer = new Stopwatch();
        for(int i = 0; i < N; ++i)
            stack.push(i);
        return timer.elapsedTime();
    }
    public static double genericTrial(int N)
    {
        FixedCapacityStack<Integer> stack = new FixedCapacityStack<Integer>(N);
        Stopwatch timer = new Stopwatch();
        for(int i = 0; i < N; ++i)
            stack.push(i);
        return timer.elapsedTime();
    }
    public static void main(String[] args)
    {
        int N =  250;
        for(;true; N += N)
        {
            StdOut.println(N + " " + nongenericTrial(N) / genericTrial(N));
        }
    }
}

class FixedCapacityStackOfInt
{
    private int[] a;
    private int N;
    public FixedCapacityStackOfInt(int N)
    {
        a = new int[N];
    }
    public boolean isEmpty()
    {
        return N == 0;
    }
    public int size()
    {
        return N;
    }
    public void push(int item )
    {
        a[N++] = item;
    }
    public int pop()
    {
        return a[--N];
    }
}
class FixedCapacityStack<Item>
{
    private Item[] a;
    private int N;
    public FixedCapacityStack(int N)
    {
        a = (Item[])new Object[N];
    }
    public boolean isEmpty()
    {
        return N == 0;
    }
    public int size()
    {
        return N;
    }
    public void push(Item item)
    {
        a[N++] = item;
    }
    public Item pop()
    {
        return a[--N];
    }
}