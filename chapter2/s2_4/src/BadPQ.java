/**
 * Created with IntelliJ IDEA.
 * User: dexctor
 * Date: 12-12-10
 * Time: 上午11:00
 * To change this template use File | Settings | File Templates.
 */
public class BadPQ<Key extends Comparable<Key>> {
    private Key[] pq;
    private int N;
    public BadPQ(int maxN)
    {
        pq = (Key[]) new Comparable[maxN];
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
    private boolean less(int i, int j)
    {
        return pq[i].compareTo(pq[j]) < 0;
    }
    private void exch(int i, int j)
    {
        Key tmp = pq[i];
        pq[i] = pq[j];
        pq[j] = tmp;
    }

    public void insert(Key k)
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            {
        pq[++N] = k;
        int i = N;
        while(i > 1 && less(i, i - 1))
            exch(i, i-1);
    }
    public Key delMax()
    {
        return pq[N--];
    }
    public static void main(String[] args)
    {
        BadPQ<String> pq = new BadPQ<String>(100);
        while(!StdIn.isEmpty())
        {
            String i = StdIn.readString();
            if(i.equals("*"))
                StdOut.println(pq.delMax());
            else
                pq.insert(i);
        }
    }
}
