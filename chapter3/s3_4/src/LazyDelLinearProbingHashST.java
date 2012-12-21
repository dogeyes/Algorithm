/**
 * Created with IntelliJ IDEA.
 * User: dexctor
 * Date: 12-12-21
 * Time: 下午6:50
 * To change this template use File | Settings | File Templates.
 */
public class LazyDelLinearProbingHashST<Key, Value> {
    private int N;
    private int M;
    private int cap;
    private int count;
    private int opNum;
    private Key[] keys;
    private Value[] values;
    public LazyDelLinearProbingHashST(int M)
    {
        this.M = M;
        keys = (Key[]) new Object[M];
        values = (Value[]) new Object[M];
    }
    private int hash(Key key)
    {
        return (key.hashCode() & 0x7fffffff) % M;
    }
    private void resize(int size)
    {
        LazyDelLinearProbingHashST<Key, Value> newSt = new LazyDelLinearProbingHashST<Key, Value>(size);
        for(int i = 0; i < M; ++i)
            if(keys[i] != null)
                newSt.put(keys[i], values[i]);

        keys = newSt.keys;
        count += newSt.count;
        values = newSt.values;
        M = newSt.M;
        cap = newSt.cap;
    }
    public void put(Key key, Value value)
    {
        opNum++;
        if(cap >= M / 2) resize(2 * M);
        int h = hash(key);
        while (keys[h] != null)
        {
            count++;
            if(keys[h].equals(key))
            {
                values[h] = value;
                return;
            }
            h = (h + 1) % M;
        }
        count++;
        keys[h] = key;
        values[h] = value;
        N++;
        cap++;
    }
    public Value get(Key key)
    {
        opNum++;
        int h = hash(key);
        while (keys[h] != null)
        {
            count++;
            if(keys[h].equals(key))
                return values[h];
            h = (h + 1) % M;
        }
        count++;
        return null;
    }
    public boolean contains(Key key)
    {
        return get(key) != null;
    }
    public void delete(Key key)
    {
        opNum++;
        if(!contains(key)) return;
        int h = hash(key);
        while (keys[h] != null)
        {
            count++;
            if(keys[h].equals(key))
                values[h] = null;

            h = (h + 1) % M;
        }
        N--;
        if(cap > 0 && N == M / 8) resize(M / 2);
    }

    public double averageCost()
    {
        return (double)count / opNum;
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
        LazyDelLinearProbingHashST<Integer, Integer> st = new LazyDelLinearProbingHashST<Integer, Integer>(16);
        for(int i = 0; i < N; ++i)
        {
            st.put(a[i], a[i]);
        }
        StdOut.println(st.averageCost());
    }
}
