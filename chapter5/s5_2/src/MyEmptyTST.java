/**
 * Created with IntelliJ IDEA.
 * User: daixing
 * Date: 13-1-5
 * Time: 下午9:12
 * To change this template use File | Settings | File Templates.
 */
public class MyEmptyTST<Value> {
    private Node root;
    private int size;
    private class Node
    {
        Value val;
        char c;
        Node left, mid, right;
    }

    private char charAt(String s, int d)
    {
        if(d >= 0)
            return s.charAt(d);
        else
            return '\0';
    }

    public Value get(String key)
    {
        Node x = get(root, key, -1);
        if(x == null)
            return null;
        else
            return x.val;
    }
    private Node get(Node x, String key, int d)
    {
        if(x == null)
            return null;
        char c = charAt(key, d);
        if(c < x.c)
            return get(x.left, key, d);
        if(c > x.c)
            return get(x.right, key, d);
        if(d == key.length() - 1)
            return x;
        return get(x.mid, key, d + 1);
    }


    public void put(String key, Value val)
    {
        root = put(root, key, val, -1);
    }
    private Node put(Node x, String key, Value val, int d)
    {
        char c = charAt(key, d);
        if(x == null)
        {
            x = new Node();
            x.c = c;
            if(d == key.length() - 1)
                size++;
        }

        if(c < x.c)
            x.left = put(x.left, key, val, d);
        else if(c > x.c)
            x.right = put(x.right, key, val, d);
        else if(key.length() - 1 == d)
            x.val = val;
        else
            x.mid = put(x.mid, key, val, d + 1);
        return x;
    }
    public Iterable<String> keys()
    {
        Queue<String> q = new Queue<String>();
        collect(root, "", q);
        return q;
    }
    public Iterable<String> keysWithPrefix(String pre)
    {
        Queue<String> q = new Queue<String>();
        Node x = get(root, pre, -1);

        if(x.val != null)
            q.enqueue(pre);
        collect(x.mid, pre, q);
        return q;
    }
    private void collect(Node x, String pre, Queue<String> q)
    {
        if(x == null)
            return;
        if(x.val != null)
            q.enqueue(pre + x.c);

        collect(x.left, pre, q);
        collect(x.mid, pre + x.c, q);
        collect(x.right, pre, q);

    }

    public Iterable<String> keysThatMatch(String pat)
    {
        Queue<String> q = new Queue<String>();
        collect(root, "", pat, q);
        return q;
    }
    private void collect(Node x, String pre, String pat, Queue<String> q)
    {
        if(x == null)
            return;

        int length = pre.length();
        char c = charAt(pat, length);
        if(c == '.')
        {
            collect(x.left, pre, pat, q);
            collect(x.mid, pre + x.c, pat, q);
            collect(x.right, pre, pat, q);
            return;
        }
        if(c < x.c)
            collect(x.left, pre, pat, q);
        else if(c > x.c)
            collect(x.right, pre, pat, q);
        else if(length == pat.length() - 1)
            q.enqueue(pre + x.c);
        else
            collect(x.mid, pre + x.c, pat, q);
    }

    public String longestPrefixOf(String s)
    {
        int length = longestPrefixOf(root, s, -1, 0);
        return s.substring(0, length);
    }
    private int longestPrefixOf(Node x, String s, int d, int length)
    {
        if(x == null)
            return length;

        char c = charAt(s, d);
        if(c < x.c)
            return longestPrefixOf(x.left, s, d, length);
        else if(c > x.c)
            return longestPrefixOf(x.right, s, d, length);
        else if(x.val != null)
            length = d + 1;

        if(d == s.length() - 1)
            return length;

        return longestPrefixOf(x.mid, s, d + 1, length);
    }

    public void delete(String key)
    {
        root = delete(root, key, -1);
    }
    private Node delete(Node x, String key, int d)
    {
        if(x == null)
            return null;
        char c = charAt(key, d);
        if(c < x.c)
            x.left = delete(x.left, key, d);
        else if(c > x.c)
            x.right = delete(x.right, key, d);
        else
        {
            if(d == key.length() - 1)
            {
                x.val = null;
                size--;
            }
            else
                x.mid = delete(x.mid, key, d + 1);
        }
        if(x.val != null)
            return x;

        if(x.right == null && x.mid == null && x.left == null)
            return null;
        return x;
    }
    public boolean isEmpty()
    {
        return root == null;
    }

    public int size()
    {
        return size;
    }

}
