import com.sun.management.OSMBeanFactory;

/**
 * Created with IntelliJ IDEA.
 * User: dexctor
 * Date: 12-11-24
 * Time: 下午12:57
 * To change this template use File | Settings | File Templates.
 */
public class RandomBag<Item> {
    private Item[] items;
    private int size;
    private int N;
    public Item at(int i)
    {
        return items[i];
    }
    public RandomBag()
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
    public void add(Item item)
    {
        if(N == size)
            resize(size * 2);
        N++;
        int change = StdRandom.uniform(0, N);
        items[N - 1] = items[change];
        items[change] = item;
    }
    public void print()
    {
        for(int i = 0 ; i < N; ++i)
        {
            StdOut.print(items[i] +" ");
        }
        StdOut.println();
    }
    public static void main(String[] args)
    {
        int[][] check = new int[10][10];
        for(int  j = 0 ; j < 1000000; ++j)
        {
            RandomBag<Integer> randomBag = new RandomBag<Integer>();
            for(int i = 0; i < 10; ++i)
            {
                randomBag.add(i);
            }
            for(int i = 0; i < 10; ++i)
            {
                int tmp = randomBag.at(i);
                check[tmp][i]++;
            }
        }
        for(int i = 0; i < 10; ++i)
        {
            for(int j = 0; j < 10; ++j)
                StdOut.print(check[i][j] +" ");
            StdOut.println();
        }

    }
}
