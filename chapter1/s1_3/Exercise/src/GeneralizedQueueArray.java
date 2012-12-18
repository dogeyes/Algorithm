/**
 * Created with IntelliJ IDEA.
 * User: dexctor
 * Date: 12-11-24
 * Time: 下午1:57
 * To change this template use File | Settings | File Templates.
 */
public class GeneralizedQueueArray<Item> {
    private Item[] items;
    private int N;
    private int size;
    public GeneralizedQueueArray()
    {
        items = (Item[]) new Object[0];
    }

    private void resize(int n)
    {
        Item[] items = (Item[]) new Object[n];
        for(int i = 0; i < N; ++i)
            items[i] = this.items[i];
        this.items = items;
        size = n;
    }
    public boolean isEmpty()
    {
        return N == 0;
    }
    public void insert(Item item)
    {
        if(N == size)
            resize(size * 2 + 10);
        items[N++] = item;
    }
    public Item delete(int k)
    {
        int i;
        for(i = N - 1; k > 1 && i >= 0; --i, k--)
        {
        }
        if(i < 0)
            return null;
        Item tmp = items[i];
        N--;
        for(int j = i; j < N; ++j)
            items[j] = items[j + 1];
        if(N == size / 4)
            resize(size / 2);
        return tmp;
    }
    public void print()
    {
        for(int i = 0; i < N; ++i)
            StdOut.print(items[i] + " ");
        StdOut.println();
    }
    public static void main(String[] args)
    {
        GeneralizedQueueArray<Integer> queue = new GeneralizedQueueArray<Integer>();
        for(int i = 0; i < 20; ++i)
        {
            queue.insert(StdRandom.uniform(0, 10000));
        }
        queue.print();
        queue.delete(1);
        queue.print();
        queue.delete(5);
        queue.print();
    }
}
