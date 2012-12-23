import java.util.Arrays;
import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * User: dexctor
 * Date: 12-12-23
 * Time: 下午7:04
 * To change this template use File | Settings | File Templates.
 */
public class LRUCache<Key> {
    private Node first;
    private Node last;
    HashMap<Key, Node> map;
    private class Node
    {
        Key key;
        Node next;
        Node previous;
        public Node(Key key, Node next, Node previous)
        {
            this.key = key;
            this.next = next;
            this.previous = previous;
        }
    }
    public LRUCache()
    {
        map = new HashMap<Key, Node>();
    }
    public void access(Key key)
    {
        if(!map.containsKey(key))
        {
            Node oldlast = last;
            last = new Node(key, null, oldlast);
            if(oldlast != null)
                oldlast.next = last;
            if(first == null)
                first = last;
            map.put(key, last);
        }
        else
        {
            Node p = map.get(key);
            if(p == last)
                return;
            if(p.previous != null)
                p.previous.next = p.next;
            if(p.next != null)
                p.next.previous = p.previous;
            last.next = p;
            p.previous = last;
            p.next = null;
            last = p;
        }
    }
    public Key delete()
    {
        Node p = last;
        last = p.previous;
        if(last != null)
            last.next = null;
        map.remove(p.key);
        if(last == null)
            first = null;
        return p.key;
    }
    public boolean isEmpty()
    {
        return first == null;
    }
    public static void main(String[] args)
    {
        int N = StdIn.readInt();
        int[] a = new int[N];
        LRUCache<Integer> cache = new LRUCache<Integer>();
        for(int i = 0; i < N; ++i)
        {
            a[i] = StdRandom.uniform(N);
            cache.access(a[i]);
        }
        StdOut.println(Arrays.toString(a));
        while (!cache.isEmpty())
        {
            StdOut.print(cache.delete() + " ");
        }
        StdOut.println(0);
    }
}
