/**
 * Created with IntelliJ IDEA.
 * User: dexctor
 * Date: 12-12-16
 * Time: 下午2:27
 * To change this template use File | Settings | File Templates.
 */
public class ArrayST<Key, Value> {
    private Key[] keys;
    private Value[] values;
    private int N;
    private  int maxN;
    public ArrayST(int maxN)
    {
        keys = (Key[])new Object[maxN];
        values = (Value[])new Object[maxN];
        this.maxN = maxN;
    }
    public int size()
    {
        return N;
    }
    public Value get(Key key)
    {
        int k = find(key);
        if ( k == -1)
            return null;
        return values[k];
    }
    public void put(Key key, Value val)
    {
        int k = find(key);
        if(k != -1)
        {
            values[k] = val;
            return;
        }
        keys[N] = key;
        values[N ++] = val;
    }
    private int find(Key key)
    {
        int i;
        for(i = 0; i < N; ++i)
        {
            if(keys[i].equals(key))
                break;
        }
        if(i == N)
            return -1;
        Key tmpk = keys[i];
        Value tmpv = values[i];
        for(int j = i; j > 0; --j)
        {
            keys[j] = keys[j - 1];
            values[j] = values[j - 1];
        }
        keys[0] = tmpk;
        values[0] = tmpv;
        return 0;
    }
    public boolean contains(Key key)
    {
        return get(key) != null;
    }
    public boolean isEmpty()
    {
        return N == 0;
    }
    public void delete(Key key)
    {
        int i;
        for(i = 0; i < N; ++i)
        {
            if(keys[i].equals(key))
                break;
        }
        if( i < N)
            N--;
        for(int j = i; j < N; ++j)
        {
            values[j] = values[j + 1];
            keys[j] = keys[j + 1];
        }
    }
    public Iterable<Key> keys()
    {
        Queue<Key> q = new Queue<Key>();
        for(int i = 0; i < N; ++i)
            q.enqueue(keys[i]);
        return q;
    }
    public static void main(String[] args)
    {
        int N = StdIn.readInt();
        ArrayST<String, Integer> st = new ArrayST<String, Integer>(N);
        for(int i = 0; i < N; ++i)
        {
            String s = StdIn.readString();
            st.put(s, i);
        }
        for(String s: st.keys())
        {
            StdOut.print(s + ":" + st.get(s) + " ");
        }
        StdOut.println();
        st.get("d");
        for(String s: st.keys())
        {
            StdOut.print(s + ":" + st.get(s) + " ");
        }
        StdOut.println();
    }
}
