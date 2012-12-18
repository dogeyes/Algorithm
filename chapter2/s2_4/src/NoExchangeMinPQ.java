/**
 * Created with IntelliJ IDEA.
 * User: dexctor
 * Date: 12-12-10
 * Time: 下午7:21
 * To change this template use File | Settings | File Templates.
 */
public class NoExchangeMinPQ<Key extends Comparable<Key>>{
    private Key[] pq;
    private int N;
    private int maxN;
    public NoExchangeMinPQ(Key[] keys)
    {
        N = keys.length;
        maxN = N;
        pq = (Key[]) new Comparable[N + 1];
        for(int i = 0; i < N; ++i)
            pq[i + 1] = keys[i];
        for(int i = N / 2; i >= 1; --i)
            sink(i);
    }
    public NoExchangeMinPQ(int capacity)
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
        pq[++N] = key;
        swim(N);
    }
    public Key delMin()
    {
        if(N == maxN / 4)
            resize(maxN / 2);
        Key key = pq[1];
        exch(1, N--);
        pq[N + 1] = null;
        sink(1);
        return key;
    }
    private void exch(int i, int j)
    {
        Key tmp = pq[i];
        pq[i] = pq[j];
        pq[j] = tmp;
    }
    private boolean less(Key i, Key j)
    {
        return  i.compareTo(j) <  0;
    }
    private void swim(int k) //bottom up
    {
        Key tmp = pq[k];
        while(k > 1 && less(tmp, pq[k / 2]))
        {
            pq[k] = pq[k / 2];
            k = k / 2;
        }
        pq[k] = tmp;
    }
    private void sink(int k) //top down
    {
        Key tmp = pq[k];
        while(k <= N / 2)
        {
            int next = k * 2;
            if(next < N && less(pq[next + 1], pq[next])) next = next + 1;
            if(!(less(pq[next], tmp)))
                break;
            pq[k] = pq[next];
            k = next;
        }
        pq[k] = tmp;
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
        NoExchangeMinPQ<Integer> pq = new NoExchangeMinPQ<Integer>(a);
        while(!pq.isEmpty())
        {
            StdOut.println(pq.delMin());
        }
        for(int i = 0; i < 20; ++i)
            pq.insert(i);
    }
}
