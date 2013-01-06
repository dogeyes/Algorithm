import java.util.Iterator;

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
    private static class Node
    {
        Object val;
        Node[] next =(Node[]) new Node[R];
        int N;
    }

    public int size()
    {
        return size(root);
    }
    public Value get(String key)
    {
        Node x = get(root, key, 0);
        if(x == null)
            return null;
        return (Value)x.val;
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
    private int size(Node x)
    {
        if(x == null)
            return 0;
        else
            return x.N;
    }
    public void put(String key, Value val)
    {
        root = put(root, key, val, 0);
    }
    private Node put(Node x, String key, Value val, int d)
    {
        if(x == null)
        {
            x = new Node();
            if(d == key.length())
            {
                x.val = val;
                x.N = 1;
            }
        }
        if(d == key.length())
        {
            x.val = val;
        }
        else
        {
            char c = key.charAt(d);
            x.N -= size(x.next[c]);
            x.next[c] = put(x.next[c], key, val, d + 1);
            x.N += size(x.next[c]);
        }

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
            q.enqueue(pre);
        for(char i =0 ; i < R; ++i)
        {
            if(x.next[i] != null)
                collect(x.next[i], pre + i, q);
        }
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
        if(pre.length() == pat.length() && x.val != null)
            q.enqueue(pre);
        if(pre.length() == pat.length())
            return;
        if(pat.charAt(pre.length()) == '.')
            for(char c = 0; c < R; ++c)
                collect(x.next[c], pre + c, pat, q);
        else
            collect(x.next[pat.charAt(pre.length())], pre + pat.charAt(pre.length()), pat, q);
    }

    public String longestPrefixOf(String s)
    {
        int length = longestPrefixOf(root, s, 0, 0);
        return s.substring(0, length);
    }
    private int longestPrefixOf(Node x, String s, int d, int length)
    {
        if(x == null)
            return length;
        if(x.val != null)
            length = d;
        if(d == s.length())
            return length;
        return longestPrefixOf(x.next[s.charAt(d)], s, d + 1, length);
    }
    public void delete(String key)
    {
        root = delete(root, key, 0);
    }

    private Node delete(Node x, String s, int d)
    {
        if(x == null)
            return null;
        if(d == s.length() && x.val != null)
        {
            x.val = null;
            x.N--;
        }
        else
        {
            char c = s.charAt(d);
            x.N -= size(x.next[c]);
            x.next[c] = delete(x.next[c], s, d + 1);
            x.N += size(x.next[c]);
        }
        if(x.val != null)
            return x;
        for(char c = 0; c < R; ++c)
            if(x.next[c] != null)
                return x;
        return null;
    }

    public String floor(String key)
    {
        return floor(root, key, 0, "");
    }
    private String floor(Node x, String key, int d, String pre)
    {
        if(x == null)
            return null;
        if(d == key.length() && x.val != null)
            return pre;
        if(d == key.length())
            return null;
        char c = key.charAt(d);
        String s = floor(x.next[c], key, d + 1, pre + c);
        while (s == null && c > 0)
        {
            c--;
            s = getMax(x.next[c],pre + c);
        }
        return s;
    }
    private String getMax(Node x, String pre)
    {
        if(x == null)
            return null;
        char c = (char)R;
        do
        {
            c--;
            String s = getMax(x.next[c], pre + c);
            if(s != null)
                return s;
        }while (c >0);
        if(x.val != null)
            return  pre;
        return null;
    }

    public String ceiling(String key)
    {
        return ceiling(root, key, 0, "");
    }
    private String ceiling(Node x, String key, int d, String pre)
    {
        if(x == null)
            return null;
        if(d == key.length() && x.val != null)
            return pre;
        if(d == key.length())
            return null;
        char c = key.charAt(d);
        String s = ceiling(x.next[c], key, d + 1, pre + c);
        while (s == null && c < R - 1)
        {
            c++;
            s = getMin(x.next[c], pre + c);
        }
        return s;
    }
    private String getMin(Node x, String pre)
    {
        if(x == null)
            return null;
        char c = (char)0;
        do
        {
            String s = getMin(x.next[c], pre + c);
            if(s != null)
                return s;
            c++;
        }while (c < R);
        if(x.val != null)
            return  pre;
        return null;
    }

    public int rank(String key)
    {
        return rank(root, key, 0);
    }
    private int rank(Node x, String key, int d)
    {
        if(x ==  null)
            return 0;
        if(key.length() == d && x.val != null)
            return 0;
        if(key.length() == d)
            return 0;

        int result = 0;
        char c = key.charAt(d);

        for(char i = 0; i < c; ++i)
            result += size(x.next[i]);
        if(x.val != null)
            result += 1;
        result += rank(x.next[c], key, d + 1);
        return result;
    }

    public String select(int k)
    {
        return select(root, k, "");
    }

    private String select(Node x, int k, String pre)
    {
        if(x == null)
            return null;
        if(k == 0 && x.val != null)
            return pre;
        if(k < 0)
            return null;
        if(k >= x.N)
            return null;
        if(x.val != null)
            k--;

        int before = 0;
        int oldBefore = 0;
        char c = 0;
        char oldC = 0;
        while(k >= before)
        {
            oldBefore = before;
            oldC = c;
            before += size(x.next[c]);
            c++;
        }
        return select(x.next[oldC], k - oldBefore, pre + oldC);
    }
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        for(String s: keys())
        {
            Node x = get(root, s, 0);
            sb.append(s + ":" + x.N + "   ");
        }
        return sb.toString();
    }

    public boolean containsPrefix(String pre)
    {
        Node x = get(root, pre, 0);
        return x != null;
    }
}
