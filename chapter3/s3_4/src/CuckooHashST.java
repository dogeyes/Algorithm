/**
 * Created with IntelliJ IDEA.
 * User: dexctor
 * Date: 12-12-21
 * Time: 下午7:58
 * To change this template use File | Settings | File Templates.
 */
public class CuckooHashST<Key, Value> {
    private int M1;
    private int M2;
    private int N1;
    private int N2;
    private Key[] keys1;
    private Key[] keys2;
    private Value[] values1;
    private Value[] values2;
    private int state;
    public CuckooHashST(int M)
    {
        keys1 = (Key[]) new Object[M];
        keys2 = (Key[]) new Object[M];
        values1 = (Value[]) new Object[M];
        values2 = (Value[]) new Object[M];
        M1 = M;
        M2 = M;
        state = 1;
    }
    private int hash1(Key key)
    {
        return ((key.hashCode() * 31) & 0x7fffffff) % M1;
    }
    private int hash2(Key key)
    {
        return ((key.hashCode() * 31) & 0x7fffffff) % M2;
    }
    private void resize(int size)
    {
        CuckooHashST<Key,Value> newST = new CuckooHashST<Key, Value>(size);
        for(int i = 0; i < M1; ++i)
        {
            if(keys1[i] != null)
                newST.put(keys1[i], values1[i]);
            if(keys2[i] != null)
                newST.put(keys2[i], values2[i]);
        }
        M1 = newST.M1;
        M2 = newST.M2;
        keys1 = newST.keys1;
        keys2 = newST.keys2;
        values1 = newST.values1;
        values2 = newST.values2;
        state = newST.state;
    }
    public Value get(Key key)
    {
        int h;
        h = hash1(key);
        if(keys1[h]!= null && keys1[h].equals(key))
            return values1[h];
        h = hash2(key);
        if(keys2[h]!= null && keys2[h].equals(key))
            return values2[h];
        return null;
    }
    public void put(Key key, Value value)
    {
        int h;
        Key nextKey;
        Value nextValue;
        while (true)
        {
            if(state == 1)
            {
                h = hash1(key);
                nextKey = keys1[h];
                nextValue = values1[h];
                keys1[h] = key;
                values1[h] = value;
                state = 2;
                if(nextKey != null && nextKey.equals(key))
                    return;
                N1++;
                if(2 * N1 > M1)
                    resize(2 * M1);
                if(nextKey == null)
                    return;
            }else
            {
                h = hash2(key);
                nextKey = keys2[h];
                nextValue = values2[h];
                keys2[h] = key;
                values2[h] = value;
                state = 1;
                if(nextKey != null && nextKey.equals(key))
                    return;
                N2++;
                if(2 * N2 > M2)
                    resize(2 * M2);
                if(nextKey == null)
                    return;
            }
            key = nextKey;
            value = nextValue;
        }
    }
    public void delete(Key key)
    {
        int h;
        h = hash1(key);
        if(keys1[h]!= null && keys1[h].equals(key))
        {
            keys1[h] = null;
            values1[h] = null;
            return;
        }
        h = hash2(key);
        if(keys2[h]!= null && keys2[h].equals(key))
        {
            keys2[h] = null;
            values2[h] = null;
        }
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
        CuckooHashST<Integer, Integer> st = new CuckooHashST<Integer, Integer>(25);
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
        st.delete(10);
        StdOut.println(st.get(10));
        for(int i = 0; i < N; ++i)
        {
            StdOut.print(a[i] + ":" + st.get(a[i]) + " ");
        }
        StdOut.println();

        for(int i = 0; i < N; ++i)
        {
            StdOut.print(a[i] + ":" + st.get(a[i]) + " ");
        }
        StdOut.println();
    }
}
