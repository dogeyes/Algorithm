import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: dexctor
 * Date: 12-12-22
 * Time: 下午7:51
 * To change this template use File | Settings | File Templates.
 */
public class MultiLinearProbingHashST<Key, Value> {
    private int N;
    private int M;
    private int count;
    private int opNum;
    private Key[] keys;
    private Value[] values;
    public MultiLinearProbingHashST(int M)
    {
        this.M = M;
        keys = (Key[]) new Object[M];
        values = (Value[]) new Object[M];
    }
    private int hash(Key key)
    {
        return ((key.hashCode() * 31) & 0x7fffffff) % M;
    }
    private void resize(int size)
    {
        MultiLinearProbingHashST<Key, Value> newSt = new MultiLinearProbingHashST<Key, Value>(size);
        for(int i = 0; i < M; ++i)
            if(keys[i] != null)
                newSt.put(keys[i], values[i]);

        keys = newSt.keys;
        count += newSt.count;
        values = newSt.values;
        M = newSt.M;
    }
    public void put(Key key, Value value)
    {
        opNum++;
        if(N >= M / 2) resize(2 * M);
        int h = hash(key);
        while (keys[h] != null)
        {
            count++;
            h = (h + 1) % M;
        }
        count++;
        keys[h] = key;
        values[h] = value;
        N++;
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
                break;
            h = (h + 1) % M;
        }
        while (keys[h] != null)
        {
            count++;
            if(keys[h].equals(key))
            {
                keys[h] = null;
                values[h] = null;
                h = (h + 1) % M;
                continue;
            }
            Key keyToRedo = keys[h];
            Value valToRedo = values[h];
            keys[h] = null;
            values[h] = null;
            put(keyToRedo, valToRedo);
            h = (h + 1) % M;
        }
        N--;
        if(N > 0 && N == M / 8) resize(M / 2);
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
            a[i] = StdRandom.uniform(N);
        }
        StdRandom.shuffle(a);
        StdOut.println(Arrays.toString(a));
        MultiLinearProbingHashST<Integer, Integer> st = new MultiLinearProbingHashST<Integer, Integer>(16);
        for(int i = 0; i < N; ++i)
        {
            st.put(a[i], i);
        }

        for(int i = 0; i < N; ++i)
        {
            StdOut.print(a[i] + ":" + st.get(a[i]) + "  ");
        }
        StdOut.println();
        int num = StdIn.readInt();
        st.delete(num);

        for(int i = 0; i < N; ++i)
        {
            StdOut.print(a[i] + ":" + st.get(a[i]) + "  ");
        }
        StdOut.println();
    }
}
