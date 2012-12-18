/**
 * Created with IntelliJ IDEA.
 * User: dexctor
 * Date: 12-12-16
 * Time: 下午2:41
 * To change this template use File | Settings | File Templates.
 */
public class OrderedSequentialSearchST<Key extends Comparable<Key>, Value> {
    private Node first;
    private int N;
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
    public boolean isEmpty()
    {
        return first == null;
    }
    public int size()
    {
        return N;
    }
    public Value get(Key key)
    {
        for(Node x = first; x != null; x = x.next)
            if(x.key.equals(key))
                return x.value;
        return null;
    }
    public void set(Key key, Value value)
    {
        Node pre = first;
        for(Node x = first; x != null && x.key.compareTo(key) < 0; pre = x, x = x.next)
        {
            if(x.key.equals(key))
            {
                x.value = value;
                return;
            }
        }
        if(pre == first)
            first = new Node(key, value, first);
        else
        {
            pre.next = new Node(key,  value,  pre.next);
        }
        N++;
    }
    public void delete(Key key)
    {
        Node pre = first;
        for(Node x = first; x != null && x.key.compareTo(key) < 0; pre = x, x = x.next)
        {
            if(x.key.equals(key))
                return;
        }
        if(key.equals(first.key))
            first = first.next;
        else
            pre.next = pre.next.next;
        N --;
    }
    public boolean contains(Key key)
    {
        return get(key) != null;
    }
    public Key min()
    {
        return first.key;
    }
    public Key max()
    {
        if(size() == 1)
            return first.key;
        Node x;
        for(x = first; x != null && x.next != null; x = x.next);

        return x.key;
    }
    public Iterable<Key> keys()
    {
        Queue<Key> q = new Queue<Key>();
        for(Node x = first; x != null; x= x.next)
            q.enqueue(x.key);
        return q;
    }
}
