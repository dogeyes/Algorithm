/**
 * Created with IntelliJ IDEA.
 * User: dexctor
 * Date: 12-12-21
 * Time: 下午4:11
 * To change this template use File | Settings | File Templates.
 */
public class MyRestrictSeperateChaningHashST<Key, Value>{
    private int M;
    private int lgM;
    private final int[] primes = {
        0,0,0,0,0,31,61,127,251,509,1021,2039,4093,8191,16381,32749,65521,
        131071, 262139, 524287, 1048573, 2097143, 4194301, 8388593, 16777213,
        33554393, 67108859,134217689
    };
    private int N;
    private final int avg;
    private int[] sizes;
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

    public MyRestrictSeperateChaningHashST(int M, int avg)
    {
        this.M = M;
        this.lgM = (int) Math.log(M);
        this.avg = avg;
        st = (Node<Key, Value>[]) new Node[M];
        sizes = new int[M];
    }

    public MyRestrictSeperateChaningHashST(int M)
    {
        this(M, 10);
    }
    private int hash(Key key)
    {
        int t = key.hashCode() & 0x7fffffff;
        if(lgM < 26) t = t % primes[lgM + 5];
        return t % M;
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
        st[h] = put(st[h], key, value, h);
        if(sizes[h] > avg)
            resize(M * 2);
    }
    private void resize(int size)
    {
        MyRestrictSeperateChaningHashST<Key, Value> newSt = new MyRestrictSeperateChaningHashST<Key, Value>(size, avg);
        for(int i = 0; i < M; ++i)
        {
            Node<Key, Value> x = st[i];
            while (x != null)
            {
                newSt.put(x.key, x.value);
                x = x.next;
            }
        }
        this.M = newSt.M;
        this.lgM = newSt.lgM;
        this.st = newSt.st;
        this.sizes = newSt.sizes;
    }
    private Node put(Node x, Key key, Value value, int h)
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
        sizes[h]++;
        return first;
    }


    public Iterable<Key> keys()
    {
        Queue<Key>  queue = new Queue<Key>();
        for(int i = 0; i < M; ++i)
        {
            Node<Key, Value> x = st[i];
            while (x != null)
            {
                queue.enqueue(x.key);
                x = x.next;
            }
        }
        return queue;
    }


    public void delete(Key key)
    {
        int h = hash(key);
        st[h] = delete(st[h], key, h);
    }
    private Node delete(Node x, Key key, int h)
    {
        if(x == null)
            return null;
        if(key.equals(x.key))
        {
            N--;
            sizes[h]--;
            return x.next;
        }
        else
            x.next = delete(x.next, key, h);
        return x;
    }
    public void deleteLarge(int k)
    {
        for(int i = 0; i < M; i ++)
        {
            st[i] = deleteLarge(st[i], k, i);
        }
    }
    private Node deleteLarge(Node x, int k, int h)
    {
        if(x == null)
            return null;
        if(x.n > k)
        {
            N--;
            sizes[h]--;
            return deleteLarge(x.next, k, h);
        }
        else
        {
            x.next = deleteLarge(x.next, k, h);
            return x;
        }
    }

    public void printSize()
    {
        for(int i = 0; i < M; ++i)
        {
            StdOut.print(sizes[i] + " ");
        }
        StdOut.println();
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
        MyRestrictSeperateChaningHashST<Integer, Integer> st = new MyRestrictSeperateChaningHashST<Integer, Integer>(30, 5);
        st.printSize();
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
        //st.deleteLarge(15);

        for(int i = 0; i < N; ++i)
        {
            StdOut.print(a[i] + ":" + st.get(a[i]) + " ");
        }
        StdOut.println();
        st.printSize();
    }
}
