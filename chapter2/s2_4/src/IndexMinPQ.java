/**
 * Created with IntelliJ IDEA.
 * User: dexctor
 * Date: 12-12-12
 * Time: 上午10:55
 * To change this template use File | Settings | File Templates.
 */
public class IndexMinPQ<Key extends Comparable<Key>> {
    private int N;
    private int[] pq; //priority queue
    private int[] qp;//qp[pq[i]] = i = pq[qp[i]]
    private Key[] keys;
    public IndexMinPQ(int maxN)
    {
        keys = (Key[])new Comparable[maxN + 1];
        pq = new int[maxN + 1];
        qp = new int[maxN + 1];
        for(int i = 0; i < maxN; ++i) qp[i] = -1;
    }
    public boolean isEmpty()
    {
        return N == 0;
    }
    public boolean constains(int k)
    {
        return qp[k] != -1;
    }
    public void insert(int k, Key key)
    {
        N++;
        qp[k] = N;
        pq[N] = k;
        keys[k] = key;
        swim(N);
    }
    public Key min()
    {
        return keys[pq[1]];
    }
    public int delMin()
    {
        int indexOfMin = pq[1];
        exch(1, N--);
        sink(1);
        keys[pq[N+1]] = null;
        qp[pq[N + 1]] = -1;
        return indexOfMin;
    }
    public int minIndex()
    {
        return pq[1];
    }
    public void change(int k, Key key)
    {
        keys[k] = key;
        swim(qp[k]);
        sink(qp[k]);
    }
    public void delete(int k)
    {
        exch(N--, qp[k]);
        swim(qp[k]);
        sink(qp[k]);
        qp[pq[N + 1]] = -1;
        keys[pq[N + 1]] = null;
    }
    private boolean less(int i, int j)
    {
        return keys[pq[i]].compareTo(keys[pq[j]]) < 0;
    }
    private void exch(int i, int j)
    {
        qp[pq[i]] = j;
        qp[pq[j]] = i;
        int tmp = pq[i];
        pq[i] = pq[j];
        pq[j] = tmp;
    }
    private void swim(int k)
    {
        while(k > 1 && less(k, k / 2))
        {
            exch(k, k / 2);
            k = k / 2;
        }
    }
    private void sink(int k)
    {
        while (k * 2 <= N)
        {
            int next = k * 2;
            if(next < N && less(next + 1, next)) next++;
            if(less(next, k))
                exch(next, k);
            k = next;
        }
    }

}
