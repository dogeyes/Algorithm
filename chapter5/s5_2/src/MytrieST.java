/**
 * Created with IntelliJ IDEA.
 * User: dogeyes
 * Date: 13-1-5
 * Time: 下午7:44
 * To change this template use File | Settings | File Templates.
 */
public class MytrieST <Value> {
    private static int R = 256;
    private Node root;
    private class Node
    {
        Value val;
        Node[] next =(Node[]) new Object[R];
    }

    public Value get(String key)
    {
        Node x = get(root, key, 0);
        if(x == null)
            return null;
        return x.val;
    }
    private Node get(Node x, String key, int d)
    {
        if(x == null)
            return null;
        if(d == key.length())
            return x;
        char c = key.charAt(d);
        return get(x.next[c], key, d + 1);
    }
    public void put(String key, Value val)
    {
        root = put(root, key, val, 0);
    }
    private Node put(Node x, String key, Value val, int d)
    {
        if(x == null)
            x = new Node();
        if(d == key.length())
        {
            x.val = val;
            return x;
        }
        char c = key.charAt(d);
        x.next[c] = put(x.next[c], key, val, d + 1);
        return x;
    }

    public Iterable<String> keys()
    {
        return keysWithPrefix("");
    }
    public Iterable<String> keysWithPrefix(String pre)
    {
        Queue<String> q = new Queue<String>();
        collect(get(root, pre, 0), pre, q);
        return q;
    }
    private void collect(Node x, String pre, Queue<String> q)
    {
        if(x == null)
            return;
        if(x.val != null)
            q.equals(pre);
        for(char i =0 ; i < R; ++i)
        {
            if(x.next[i] != null)
                collect(x.next[i], pre + i, q);
        }
    }

    p
}
