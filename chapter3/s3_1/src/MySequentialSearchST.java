import sun.security.krb5.internal.crypto.KeyUsage;

import javax.management.ValueExp;

/**
 * Created with IntelliJ IDEA.
 * User: dexctor
 * Date: 12-12-16
 * Time: 下午12:59
 * To change this template use File | Settings | File Templates.
 */
public class MySequentialSearchST<Key, Value> {
    private Node first;
    private Node lastest;
    private  int N;
    private class Node
    {
        Key key;
        Value value;
        Node next;
        public Node(Key k, Value v, Node n)
        {
            key = k;
            value = v;
            next = n;
        }
    }

    public Value get(Key key)
    {
        if(lastest!=null && key.equals(lastest.key))
            return lastest.value;
        for(Node x = first; x != null; x = x.next)
            if(x.key.equals(key))
            {
                lastest = x;
                return x.value;
            }
        return null;
    }
    public void put(Key key, Value value)
    {
        if(lastest!= null && key.equals(lastest.key))
        {
            lastest.value = value;
        }
        for(Node x = first; x != null; x = x.next)
            if(x.key.equals(key))
            {
                x.value = value;
                return;
            }
        first = new Node(key, value, first);
        N++;
    }
    public int size()
    {
        return N;
    }
    public void delete(Key key)
    {
        Node pre = first;
        Node x;
        for(x = first; x != null; pre = x, x = x.next)
            if(key.equals(x.key))
                break;
        if(x == null)
            return;
        if(key.equals(first.key))
            first = first.next;
        else
            pre.next = pre.next.next;
        N--;
    }
    public boolean contains(Key key)
    {
        return get(key) != null;
    }
    public Iterable<Key> keys()
    {
        Queue<Key> q = new Queue<Key>();
        for(Node x = first; x != null; x = x.next)
            q.enqueue(x.key);
        return q;
    }
    public static void main(String[] args)
    {
        int N = StdIn.readInt();
        MySequentialSearchST<String, Integer> st = new MySequentialSearchST<String, Integer>();
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
    }
}
