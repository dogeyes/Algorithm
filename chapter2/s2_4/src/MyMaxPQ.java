/**
 * Created with IntelliJ IDEA.
 * User: dexctor
 * Date: 12-12-10
 * Time: 上午9:49
 * To change this template use File | Settings | File Templates.
 */
public class MyMaxPQ<Key extends Comparable<Key>> {
    private Key[] pq;
    private int N;
    private int maxN;
    private Key min;
    public MyMaxPQ(Key[] keys)
    {
        N = keys.length;
        maxN = N;
        pq = (Key[]) new Comparable[N + 1];
        min = keys[1];
        for(int i = 0; i < N; ++i)
        {
            pq[i + 1] = keys[i];
            if(less(pq[i + 1], min))
                min = pq[i + 1];
        }
        for(int i = N / 2; i >= 1; --i)
            sink(i);
    }
    public MyMaxPQ(int capacity)
    {
        maxN = capacity;
        pq = (Key[]) new Comparable[capacity + 1];
        N = 0;
    }
    public boolean isEmpty()
    {
        return N == 0;
    }
    public int size()
    {
        return N;
    }
    public void insert(Key key)
    {
        if(N == maxN - 1)
            resize(maxN * 2);
        if(N == 0 )
            min = key;
        else if(less(key, min))
            min = key;
        pq[++N] = key;
        swim(N);
    }
    public Key delMax()
    {
        if(N == maxN / 4)
            resize(maxN / 2);
        Key key = pq[1];
        exch(1, N--);
        pq[N + 1] = null;
        sink(1);
        return key;
    }
    public Key min()
    {
        return min;
    }
    private void exch(int i, int j)
    {
        Key tmp = pq[i];
        pq[i] = pq[j];
        pq[j] = tmp;
    }
    private boolean less(Key i, Key j)
    {
        return i.compareTo(j) < 0;
    }
    private boolean less(int i, int j)
    {
        return  pq[i].compareTo(pq[j]) < 0;
    }
    private void swim(int k) //bottom up
    {
        while(k > 1 && less(k / 2, k))
        {
            exch(k, k / 2);
            k = k / 2;
        }
    }
    private void sink(int k) //top down
    {
        while(k <= N / 2)
        {
            int next = k * 2;
            if(next < N && less(next, next + 1)) next = next + 1;
            if(!(less(k, next)))
                break;
            exch(k, next);
            k = next;
        }
    }
    private void resize(int newMaxN)
    {
        Key[] tmp = (Key[])new Comparable[newMaxN];
        for(int i = 0; i <= N; ++i)
            tmp[i] = pq[i];
        pq = tmp;
        maxN = newMaxN;
    }
    public static void main(String[] args)
    {
        Integer[] a = new Integer[10];
        for(int i = 0 ; i < 10; ++i)
            a[i] = i;
        StdRandom.shuffle(a);
        MyMaxPQ<Integer> pq = new MyMaxPQ<Integer>(a);
        while(!pq.isEmpty())
        {
            StdOut.println(pq.delMax());
        }
        for(int i = 0; i < 20; ++i)
            pq.insert(i);
        StdOut.println(pq.min());
    }
}
