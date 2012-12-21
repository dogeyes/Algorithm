/**
 * Created with IntelliJ IDEA.
 * User: dexctor
 * Date: 12-12-21
 * Time: 上午9:22
 * To change this template use File | Settings | File Templates.
 */
public class MySeperateChaningHashST<Key, Value> {
    private int M;
    private int N;
    private SequentialSearchST<Key, Value>[] st;
    public MySeperateChaningHashST(int M)
    {
        this.M = M;
        st = (SequentialSearchST<Key, Value>[])new SequentialSearchST[M];
        for(int i = 0; i < M; ++i)
            st[i] = new SequentialSearchST<Key, Value>();
    }
    public MySeperateChaningHashST()
    {
        this(997);
    }
    private int hash(Key key)
    {
        return (key.hashCode() & 0x7fffffff) % M;
    }
    public Value get(Key key)
    {
        return st[hash(key)].get(key);
    }
    public void put(Key key, Value value)
    {
        int h = hash(key);
        if(!st[h].contains(key))
            N++;
        st[h].put(key, value);
    }

    public void delete(Key key)
    {
        int h = hash(key);
        if(st[h].contains(key))
            N--;
        st[h].delete(key);
    }

    public static void main(String[] args)
    {
        int N = StdIn.readInt();
        Integer[] a = new Integer[N];
        for(int i = 0; i < N; ++i)
        {
            a[i] = i;
        }
        StdRandom.shuffle(a);
        MySeperateChaningHashST<Integer, Integer> st = new MySeperateChaningHashST<Integer, Integer>(N / 2);
        for(int i = 0; i < N; ++i)
        {
            st.put(a[i], a[i]);
        }
        for(int i = 0; i < N; ++i)
        {
            StdOut.print(a[i] + ":" + st.get(a[i]) + " ");
        }
        StdOut.println();
        StdOut.println(st.get(100));
    }
}
