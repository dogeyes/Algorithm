/**
 * Created with IntelliJ IDEA.
 * User: dexctor
 * Date: 12-12-13
 * Time: 下午9:02
 * To change this template use File | Settings | File Templates.
 */
public class StableMaxPQ <Key extends Comparable<Key>> {
    private class Wrap implements Comparable<Wrap>
    {
        Key item;
        int index;
        public Wrap(Key item, int index)
        {
            this.item = item;
            this.index = index;
        }
        public int compareTo(Wrap that)
        {
            if(item.compareTo(that.item) != 0)
                return item.compareTo(that.item);
            else
                return - index + that.index;
        }
    }
    private MaxPQ<Wrap> pq;
    private int index;
    public StableMaxPQ()
    {
        pq = new MaxPQ<Wrap>();
    }
    public void insert(Key k)
    {
        Wrap w = new Wrap(k, index++);
        pq.insert(w);
    }
    public Key delMax()
    {
        Wrap w = pq.delMax();
        return w.item;
    }
    public boolean isEmpty()
    {
        return pq.isEmpty();
    }
    public int size()
    {
        return pq.size();
    }
    public static void main(String[] args)
    {
        int N = StdIn.readInt();
        StableMaxPQ<Box> pq = new StableMaxPQ<Box>();
        for(int i = 0; i < N; ++i)
        {
            int d = StdIn.readInt();
            Box b = new Box(d, i);
            pq.insert(b);
        }
        while(!pq.isEmpty())
        {
            StdOut.println(pq.delMax());
        }
    }
}

class Box implements Comparable<Box>
{
    private int data;
    private int index;
    public Box(int d, int i)
    {
        data = d;
        index = i;
    }
    public String toString()
    {
        return "[" + data + " " + index + "]";
    }
    public int compareTo(Box that)
    {
        return data - that.data;
    }
}
