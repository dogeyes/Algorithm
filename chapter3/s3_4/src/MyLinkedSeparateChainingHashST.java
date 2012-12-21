import com.sun.xml.internal.fastinfoset.util.ValueArray;

/**
 * Created with IntelliJ IDEA.
 * User: dexctor
 * Date: 12-12-21
 * Time: 上午10:44
 * To change this template use File | Settings | File Templates.
 */
public class MyLinkedSeparateChainingHashST<Key, Value> {
    private int M;
    private int N;
    private class Node<Key, Value>
    {
        Key key;
        Value value;
        int n;
        Node next;
        public Node(Key key, Value value, Node next, int n)
        {
            this.key = key;
            this.value = value;
            this.next = next;
            this.n = n;
        }
    }
    private Node<Key,Value>[] st;
    public MyLinkedSeparateChainingHashST(int M)
    {
        this.M = M;
        st = (Node<Key, Value>[]) new Node[M];
    }
    private int hash(Key key)
    {
        return (key.hashCode() & 0x7ffffff) % M;
    }
    public Value get(Key key)
    {
        int h = hash(key);
        return get(st[h], key);
    }
    private Value get(Node<Key,Value> x, Key key)
    {
        while (x  != null)
        {
            if(x.key.equals(key))
                return x.value;
            x = x.next;
        }
        return null;
    }
    public int size()
    {
        return N;
    }
    public void put(Key key, Value value)
    {
        int h = hash(key);
        st[h] = put(st[h], key, value);
    }
    private Node put(Node x, Key key, Value value)
    {
        Node first = x;
        while (x != null)
        {
            if(x.key.equals(key))
            {
                x.value = value;
                x.n = size();
                return first;
            }
            x = x.next;
        }
        Node oldfirst = first;
        first = new Node(key, value, oldfirst, size());
        N++;
        return first;
    }
    public void delete(Key key)
    {
        int h = hash(key);
        st[h] = delete(st[h], key);
    }
    private Node delete(Node x, Key key)
    {
        if(x == null)
            return null;
        if(key.equals(x.key))
        {
            N--;
            return x.next;
        }
        else
            x.next = delete(x.next, key);
        return x;
    }
    public void deleteLarge(int k)
    {
        for(int i = 0; i < M; i ++)
        {
            st[i] = deleteLarge(st[i], k);
        }
    }
    private Node deleteLarge(Node x, int k)
    {
        if(x == null)
            return null;
        if(x.n > k)
        {
            N--;
            return deleteLarge(x.next, k);
        }
        else
        {
            x.next = deleteLarge(x.next, k);
            return x;
        }
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
        MyLinkedSeparateChainingHashST<Integer, Integer> st = new MyLinkedSeparateChainingHashST<Integer, Integer>(N / 2);
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
        for(int i = 0; i < N; ++i)
        {
            StdOut.print(a[i] + ":" + st.get(a[i]) + " ");
        }
        StdOut.println();
        st.deleteLarge(15);

        for(int i = 0; i < N; ++i)
        {
            StdOut.print(a[i] + ":" + st.get(a[i]) + " ");
        }
        StdOut.println();
    }

}
