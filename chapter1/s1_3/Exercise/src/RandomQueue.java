import java.util.Iterator;

/**
 * Created with IntelliJ IDEA.
 * User: dexctor
 * Date: 12-11-24
 * Time: 下午1:20
 * To change this template use File | Settings | File Templates.
 */
public class RandomQueue<Item> implements Iterable<Item> {
    private Item[] items;
    private int size;
    private int N;
    public Item at(int i)
    {
        return items[i];
    }
    public RandomQueue()
    {
        items = (Item[]) new Object[1];
        size = 1;
    }
    private void resize(int n)
    {
        Item[] items = (Item[]) new  Object[n];
        for(int i = 0;i < N; ++i)
            items[i] = this.items[i];
        this.items = items;
        size = n;
    }
    public boolean isEmpty()
    {
        return  N == 0;
    }
    public int size()
    {
        return N;
    }
    public void enqueue(Item item)
    {
        if(N == size)
            resize(size * 2);
        items[N++] = item;
    }
    public Item dequeue()
    {
        int change = StdRandom.uniform(0, N);
        Item tmp = items[change];
        items[change] = items[--N];
        return tmp;
    }
    public Item sample()
    {
        int index = StdRandom.uniform(0, N);
        return items[index];
    }
    public Iterator<Item> iterator()
    {
        return new Iterator() {
            int n = 0;
            @Override
            public boolean hasNext() {
                return n < N;
            }

            @Override
            public Item next() {
                int change = StdRandom.uniform(n, N);
                Item tmp = items[change];
                items[change] = items[n];
                items[n] = tmp;
                n++;
                return tmp;
            }

            @Override
            public void remove() {
                //To change body of implemented methods use File | Settings | File Templates.
            }
        };
    }
    public static void main(String[] args)
    {
        int[][] check = new int[13][13];
        RandomQueue<Integer> randomQueue = new RandomQueue<Integer>();
        for(int i = 0; i < 13; ++i)
            randomQueue.enqueue(i);
        for(int  j = 0 ; j < 1000000; ++j)
        {
            Iterator<Integer> iterator = randomQueue.iterator();
            int count = 0;
            while(iterator.hasNext())
            {
                check[iterator.next()][count]++;
                count++;
            }
        }
        for(int i = 0; i < 13; ++i)
        {
            for(int j = 0; j < 13; ++j)
                StdOut.print((double)check[i][j] / (1000000.0 / 13) +" ");
            StdOut.println();
        }

    }
}
