import java.awt.*;

/**
 * Created with IntelliJ IDEA.
 * User: dexctor
 * Date: 12-11-24
 * Time: 下午2:09
 * To change this template use File | Settings | File Templates.
 */
public class RingBuffer<Item> {
    private Item[] ringBuffer;
    private int N;
    private int first;
    private int last;
    public RingBuffer(int N)
    {
        ringBuffer = (Item[]) new Object[N];
        this.N = N;
    }
    public boolean isEmpty()
    {
        return first == last;
    }
    public boolean  isFull()
    {
        return (last + 1) % N == first;
    }
    public void enBuffer(Item item)
    {
        if(isFull())
            return;
        ringBuffer[last++] = item;
        last = last % N;
    }
    public Item deBuffer()
    {
        if(isEmpty())
            return null;
        Item tmp = ringBuffer[first];
        first = (first + 1) % N;
        return tmp;
    }
    public void print()
    {
       for(int i = first; i  !=  last; i = (i + 1) % N)
           StdOut.print(ringBuffer[i] + " ");
        StdOut.println();
    }
    public static void main(String[] args)
    {
        RingBuffer<Integer> ringBuffer = new RingBuffer<Integer>(20);
        for(int i = 0 ; i < 15 ; ++i)
        {
            ringBuffer.enBuffer(i);
        }
        ringBuffer.print();
        for(int i = 0; i < 10; ++i)
        {
            StdOut.print(ringBuffer.deBuffer() + " ");
        }
        StdOut.println();
        ringBuffer.print();
        for(int i = 0 ; i < 20 ; ++i)
        {
            ringBuffer.enBuffer(i);
        }
        ringBuffer.print();
    }
}
