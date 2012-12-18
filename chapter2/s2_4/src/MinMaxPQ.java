import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: dexctor
 * Date: 12-12-12
 * Time: 上午10:01
 * To change this template use File | Settings | File Templates.
 */
public class MinMaxPQ<Key extends Comparable<Key>> {
    private MinPQ<Key> minPQ;
    private MaxPQ<Key> maxPQ;
    private Key median;
    public MinMaxPQ()
    {
        minPQ = new MinPQ<Key>();
        maxPQ = new MaxPQ<Key>();
    }
    public void insert(Key item)
    {
        if(minPQ.size() == 0 && maxPQ.size() == 0)
        {
            median = item;
            minPQ.insert(item);
            maxPQ.insert(item);
            return;
        }
        if(item.compareTo(median) >= 0)
            maxPQ.insert(item);
        else
            minPQ.insert(item);
        if(maxPQ.size() == 1 && minPQ.size() > 1)
            reMin();
        else if(maxPQ.size() > 1 && minPQ.size() == 1)
            reMax();
    }
    public Key max()
    {
        return maxPQ.max();
    }
    public Key min()
    {
        return minPQ.min();
    }
    public Key delMax()
    {
        if(maxPQ.size() > 1)
            return maxPQ.delMax();
        if(minPQ.size() == 1)
        {
            minPQ.delMin();
            return maxPQ.delMax();
        }
        reMin();
        return maxPQ.delMax();
    }
    public Key delMin()
    {
        if(minPQ.size() > 1)
            return minPQ.delMin();
        if(maxPQ.size() == 1)
        {
            maxPQ.delMax();
            return minPQ.delMin();
        }
        reMax();
        return minPQ.delMin();
    }
    public int size()
    {
        return  minPQ.size() + maxPQ.size() == 0 ? 0:  minPQ.size() + maxPQ.size() - 1;
    }
    public boolean isEmpty()
    {
        return minPQ.isEmpty() && maxPQ.isEmpty();
    }
    private void reMin()
    {
        int N = (minPQ.size() - 1) / 2;
        maxPQ.delMax();
        Key[] a = (Key[]) new Comparable[N];
        for(int i = 0; i < N; ++i)
            a[i] = minPQ.delMin();
        median = minPQ.delMin();
        while (!minPQ.isEmpty())
            maxPQ.insert(minPQ.delMin());
        maxPQ.insert(median);
        minPQ.insert(median);
        for(int i = 0; i < N; ++i)
            minPQ.insert(a[i]);
    }
    private void reMax()
    {
        int N = (maxPQ.size() - 1) / 2;
        minPQ.delMin();
        Key[] a= (Key[]) new Comparable[N];
        for(int i = 0; i < N; ++i)
            a[i] = maxPQ.delMax();
        median = maxPQ.delMax();
        while (!maxPQ.isEmpty())
            minPQ.insert(maxPQ.delMax());
        maxPQ.insert(median);
        minPQ.insert(median);
        for(int i = 0; i < N; ++i)
            maxPQ.insert(a[i]);
    }
    public static void main(String[] args)
    {
        MinMaxPQ<Integer> pq = new MinMaxPQ<Integer>();
        int N = 10;
        Integer[] a = new Integer[N];
        for(int i = 0; i < N; ++i)
            a[i] = i;
        StdRandom.shuffle(a);
        StdOut.println(Arrays.toString(a));
        for(int i = 0; i < N; ++i)
            pq.insert(a[i]);
        while (!pq.isEmpty())
        {
            StdOut.println(pq.max() + " " + pq.min());
            pq.delMin();
        }
    }
}
