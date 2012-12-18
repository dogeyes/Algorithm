/**
 * Created with IntelliJ IDEA.
 * User: dexctor
 * Date: 12-12-16
 * Time: 下午1:04
 * To change this template use File | Settings | File Templates.
 */
public class MyBinarySearchST<Key extends Comparable<Key>, Value> {
    private Key[] keys;
    private Value[] values;
    private int N;
    private int maxN;
    private int lastest = -1;
    public MyBinarySearchST(int maxN)
    {
        keys = (Key[]) new Comparable[maxN];
        values = (Value[]) new Object[maxN];
        this.maxN = maxN;
    }

    public int size()
    {
        return N;
    }
    public Value get(Key key)
    {
        if(lastest != -1 && keys[lastest].equals(key))
            return values[lastest];
        int k = rank(key);
        if(k < N && keys[k].equals(key))
        {
            return values[k];
        }
        return null;
    }
    public boolean contains(Key key)
    {
        return !(get(key) == null);
    }
    public void put(Key key, Value val)
    {
        if(lastest != -1 && keys[lastest].equals(key))
        {
            values[lastest] = val;
            return;
        }
        int k = rank(key);
        if(k < N && keys[k].equals(key))
        {
            values[k] = val;
            return;
        }
        for(int i = N; i > k; --i)
        {
            keys[i] = keys[i - 1];
            values[i] = values[i - 1];
        }
        values[k] = val;
        keys[k] = key;
        N++;
    }
    public Key min()
    {
        return keys[0];
    }
    public void deleteMin()
    {
        delete(min());
    }
    public Key max()
    {
        return keys[N - 1];
    }
    public void deleteMax()
    {
        delete(max());
    }
    public Key select(int k)
    {
        return keys[k];
    }
    public Key ceiling(Key key)
    {
        int i = rank(key);
        return  keys[i];
    }
    public Key floor(Key key)
    {
        int i = rank(key);
        if(i < N && keys[i].equals(key))
            return key;
        else if(i == 0)
            return null;
        else
            return keys[i - 1];
    }
    public Key delete(Key key)
    {
        int i = rank(key);
        if(!keys[i].equals(key))
            return null;
        for(int j = i; j < N - 1; ++j)
        {
            keys[j] = keys[j + 1];
            values[j] = values[j + 1];
        }
        N--;
        keys[N] = null;
        values[N] = null;
        return key;
    }
    public Iterable<Key> keys()
    {
        return keys(min(), max());
    }
    public Iterable<Key> keys(Key lo, Key hi)
    {
        Queue<Key> q = new Queue<Key>();
        for(int i = rank(lo); i < rank(hi); ++i)
        {
            q.enqueue(keys[i]);
        }
        if(contains(hi))
            q.enqueue(keys[rank(hi)]);
        return q;
    }
    public int rank(Key key)
    {
        return rank(key, 0,N - 1);
    }
    private int rank(Key key, int lo, int hi)
    {
        while(lo <= hi)
        {
            int mid = (lo + hi) / 2;
            if(key.compareTo(keys[mid]) > 0)
                lo = mid + 1;
            else if(key.compareTo(keys[mid]) < 0)
                hi = mid - 1;
            else
                return mid;
        }
        return lo;
    }
    public static void main(String[] args)
    {
        int N = StdIn.readInt();
        MyBinarySearchST<String, Integer> st = new MyBinarySearchST<String, Integer>(100);
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
        StdOut.println("d " + st.get("d"));
        st.delete("d");
        for(String s: st.keys())
        {
            StdOut.print(s + ":" + st.get(s) + " ");
        }
        StdOut.println();
        st.delete("j");
        for(String s: st.keys())
        {
            StdOut.print(s + ":" + st.get(s) + " ");
        }
        StdOut.println();
        String sfloor = StdIn.readString();
        StdOut.println(st.floor(sfloor));
    }
}
