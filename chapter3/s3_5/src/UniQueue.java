import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: dexctor
 * Date: 12-12-23
 * Time: 下午8:01
 * To change this template use File | Settings | File Templates.
 */
public class UniQueue<Item> {
    private MyHashSET<Item> set;
    private Queue<Item> queue;
    public UniQueue()
    {
        set = new MyHashSET<Item>();
        queue = new Queue<Item>();
    }
    public boolean isEmpty()
    {
        return set.isEmpty();
    }
    public int size()
    {
        return set.size();
    }
    public void enqueue(Item item)
    {
        if(!set.contains(item))
        {
            set.add(item);
            queue.enqueue(item);
        }
    }
    public Item dequeue()
    {
        Item item = queue.dequeue();
        set.delete(item);
        return item;
    }

    public static void main(String[] args)
    {
        UniQueue<Integer> queue = new UniQueue<Integer>();
        int N = StdIn.readInt();
        int[] a = new int[N];
        for(int i = 0; i < N; ++i)
        {
            a[i] = StdRandom.uniform(N);
            queue.enqueue(a[i]);
        }
        StdOut.println(Arrays.toString(a));
        while (!queue.isEmpty())
            StdOut.print(queue.dequeue() + " ");
        StdOut.println();
    }
}
