/**
 * Created with IntelliJ IDEA.
 * User: dexctor
 * Date: 12-12-17
 * Time: 上午10:52
 * To change this template use File | Settings | File Templates.
 */
public class NonRecursiveBST<Key extends Comparable<Key>, Value> {
    private Node root;
    private class Node
    {
        Key key;
        Value value;
        Node right;
        Node left;
        int N;
        public Node(Key k, Value v, int n)
        {
            key = k;
            value = v;
            N = n;
        }
    }
    public int size()
    {
        return size(root);
    }
    private int size(Node x)
    {
        if(x == null)
            return 0;
        else
            return x.N;
    }
    public Value get(Key key)
    {
        Node res = get(root, key);
        if(res == null)
            return null;
        else
            return res.value;
    }
    /*   private Node get(Node x, Key key) //recursive implementation
       {
           if(x == null)
               return null;
           int com = key.compareTo(x.key);
           if(com < 0) return get(x.left, key);
           else if(com > 0) return get(x.right, key);
           else return x;
       }*/
    private Node get(Node x, Key key)
    {
        while (x != null)
        {
            int comp = key.compareTo(x.key);
            if(comp < 0) x = x.left;
            else if(comp > 0) x = x.right;
            else return x;
        }
        return null;
    }
    /*public void put(Key key, Value val)
    {
        put(root, key, val);
    } */
    /*private Node put(Node x, Key key, Value val) // //recursive implementation
    {
        if(x == null)
        {
            return new Node(key, val, 1);
        }
        int comp = key.compareTo(x.key);
        if(comp < 0) x.left = put(x.left, key, val);
        else if(comp > 0) x.right = put(x.right, key, val);
        else x.value = val;
        x.N = size(x.right) + size(x.left) + 1;
        return x;
    } */

    private void put(Key key, Value val)
    {
        if(root == null)
        {
            root = new Node(key, val, 1);
            return;
        }
        Node x = root;
        Node pre = x;
        while (x != null)
        {
            int comp = key.compareTo(x.key);
            if(comp == 0)
            {
                x.value = val;
                return;
            }
            pre = x;
            if(comp < 0)
                x = x.left;
            else if(comp > 0)
                x = x.right;
        }
        int comp = key.compareTo(pre.key);
        if(comp < 0)
        {
            pre.left = new Node(key, val, 0);
        }
        else
            pre.right = new Node(key, val, 0);
        x = root;
        while (x!= null)
        {
            x.N++;
            comp = key.compareTo(x.key);
            if(comp < 0)
                x = x.left;
            else
                x = x.right;
        }
    }

    public Key min()
    {
        Node res = min(root);
        if(res == null)
            return null;
        else
            return res.key;
    }
    /*private Node min(Node x)
    {
        if(x.left == null)
            return x;
        else return min(x.left);
    } */
    public Node min(Node x)
    {
        while(x.left != null)
            x = x.left;
        return x;
    }
    public Key max()
    {
        Node res = max(root);
        if(res == null)
            return null;
        else
            return res.key;
    }
    /*private Node max(Node x)
    {
        if(x.right == null)
            return x;
        else
            return max(x.right);
    } */
    private Node max(Node x)
    {
        while (x.right != null)
            x = x.right;
        return x;
    }
    public Key floor(Key key)
    {
        Node res = floor(root, key);
        if(res == null)
            return null;
        else
            return res.key;
    }
    /*private Node floor(Node x, Key key)
    {
        if(x == null)
            return null;
        int comp = key.compareTo(x.key);
        if(comp < 0)
            return floor(x.left, key);
        else if(comp > 0)
        {
            Node res = floor(x.right, key);
            if(res != null)
                return res;
            else
                return x;
        }
        else
            return x;
    } */
    private Node floor(Node x, Key key)
    {
        Node pre = null;
        while (x != null)
        {
            int comp = key.compareTo(x.key);
            if(comp == 0)
                return x;
            if(comp < 0)
                x = x.left;
            else
            {
                pre = x;
                x = x.right;
            }
        }
        return pre;
    }
    public Key ceiling(Key key)
    {
        Node res = ceiling(root, key);
        if(res == null)
            return null;
        else
            return res.key;
    }
    /*private Node ceiling(Node x, Key key)
    {
        if(x == null)
            return null;
        int comp = key.compareTo(x.key);
        if(comp > 0)
            return ceiling(x.right, key);
        else if(comp == 0)
            return x;
        else
        {
            Node res = ceiling(x.left, key);
            if(res == null)
                return x;
            else
                return res;
        }
    } */
    private Node ceiling(Node x, Key key)
    {
        Node pre = null;
        while (x != null)
        {
            int comp = key.compareTo(x.key);
            if(comp == 0)
                return x;
            if(comp > 0)
                x = x.right;
            if(comp < 0)
            {
                pre = x;
                x = x.left;
            }
        }
        return pre;
    }
    public Key select(int k)
    {
        Node res = select(root, k);
        if(res == null)
            return null;
        else
            return res.key;
    }
    /*private Node select(Node x, int k)
    {
        if(x == null)
            return null;
        int t = size(x.left);
        if(t == k)
            return x;
        else if(k < t)
            return select(x.left, k);
        else
            return select(x.right,k - t - 1);
    } */
    private Node select(Node x, int k)
    {
        while (x != null)
        {
            int t = size(x.left);
            if(t == k)
                return x;
            if(k < t)
                x = x.left;
            else
            {
                k = k - t - 1;
                x = x.right;
            }
        }
        return null;
    }
    public int rank(Key key)
    {
        return rank(root, key);
    }
    /*private int rank(Node x, Key key)
    {
        if(x == null)
            return 0;
        int comp = key.compareTo(x.key);
        if(comp == 0)
            return size(x.left);
        else if(comp < 0)
            return rank(x.left, key);
        else
            return size(x.left) + 1 + rank(x.right, key);
    } */
    private int rank(Node x, Key key)
    {
        int n = 0;
        while (x != null)
        {
            int comp = key.compareTo(x.key);
            if(comp == 0)
            {
                return size(x.left) + n;
            }
            if(comp < 0)
                x = x.left;
            else
            {
                n = n + size(x.left) + 1;
                x = x.right;
            }
        }
        return n;
    }
    public void deleteMin()
    {
        root = deleteMin(root);
    }
    private Node deleteMin(Node x)
    {
        if(x == null)
            return null;
        if(x.left == null)
            return x.right;
        x.left = deleteMin(x.left);
        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }
    public void deleteMax()
    {
        root = deleteMax(root);
    }
    private Node deleteMax(Node x)
    {
        if(x == null)
            return null;
        if(x.right == null)
            return x.left;
        x.right = deleteMax(x.right);
        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }
    public void delete(Key key)
    {
        root = delete(root, key);
    }
    private Node delete(Node x, Key key)
    {
        if(x == null)
            return null;
        int comp = key.compareTo(x.key);
        if(comp < 0) x.left = delete(x.left, key);
        else if(comp > 0) x.right = delete(x.right, key);
        else
        {
            if(x.left == null)
                return x.right;
            if(x.right == null)
                return x.left;
            Node t = max(x.left);
            t.left = deleteMax(x.left);
            t.right = x.right;
            x= t;
        }
        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }
    public void print()
    {
        print(root);
    }
    private void print(Node x)
    {
        if(x == null)
            return;
        print(x.left);
        StdOut.println(x.key + ":" + x.value);
        print(x.right);
    }
    public Iterable<Key> keys()
    {
        return keys(min(), max());
    }
    public Iterable<Key> keys(Key lo, Key hi)
    {
        Queue<Key> queue = new Queue<Key>();
        keys(root, queue, lo, hi);
        return queue;
    }
    private void keys(Node x, Queue<Key> queue, Key lo, Key hi)
    {
        if(x == null)
            return;
        int compLo = lo.compareTo(x.key);
        int compHi = hi.compareTo(x.key);
        if(compLo < 0)
            keys(x.left, queue, lo, hi);
        if(compLo <= 0 && compHi >= 0)
            queue.enqueue(x.key);
        if(compHi > 0)
            keys(x.right, queue,lo, hi);
    }
    public static void main(String[] args)
    {
        NonRecursiveBST<String, Integer> bst = new NonRecursiveBST<String, Integer>();
        In in = new In("binaryTree.txt");
        int N = in.readInt();
        for(int i = 0; i < N; ++i)
        {
            String s = in.readString();
            int v = in.readInt();
            bst.put(s, v);
        }
        bst.print();
        StdOut.println("max= " + bst.max() + ":" + bst.get(bst.max()));
        StdOut.println("min= " + bst.min() + ":" + bst.get(bst.min()));
        bst.deleteMax();
        bst.deleteMin();
        StdOut.println("max= " + bst.max() + ":" + bst.get(bst.max()));
        StdOut.println("min= " + bst.min() + ":" + bst.get(bst.min()));
        bst.delete("g");
        bst.print();
        for(String s : bst.keys("a", "f"))
            StdOut.print(s + " ");
        StdOut.println();
        StdOut.println(bst.rank("k"));
        StdOut.println(bst.select(3));
    }
}
