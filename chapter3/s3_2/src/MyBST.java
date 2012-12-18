import java.util.Iterator;

/**
 * Created with IntelliJ IDEA.
 * User: dexctor
 * Date: 12-12-17
 * Time: 上午8:34
 * To change this template use File | Settings | File Templates.
 */
public class MyBST<Key extends Comparable<Key>, Value> {
    private Node root;
    private Node lastest;
    private class Node
    {
        Key key;
        Value value;
        Node right;
        Node left;
        Node pred;
        Node succ;
        int height;
        int N;
        double avgCompares;
        public Node(Key k, Value v, int n)
        {
            key = k;
            value = v;
            N = n;
        }
        public Node(Key k, Value v, int n, int hei, double avg)
        {
            key = k;
            value = v;
            N = n;
            height = hei;
            avgCompares = avg;
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
    public int height()
    {
        return height(root);
    }
    private int height(Node x)
    {
        if(x == null)
            return 0;
        else
            return x.height;
    }
    public double avgCompares()
    {
        return avgCompares(root);
    }
    private double avgCompares(Node x)
    {
        if(x == null)
            return 0;
        else
            return x.avgCompares;
    }
    public Key next(Key key)
    {
        Node x = get(root, key);
        if(x == null || x.succ == null)
            return null;
        else
            return x.succ.key;
    }
    public Key prev(Key key)
    {
        Node x = get(root, key);
        if(x == null || x.pred == null)
            return null;
        else
            return x.pred.key;
    }
    public Value get(Key key)
    {
        if(lastest != null && lastest.key.compareTo(key) == 0)
            return lastest.value;
        Node res = get(root, key);
        if(res == null)
            return null;
        else
        {
            lastest = res;
            return res.value;
        }
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
    public void put(Key key, Value val)
    {
        if(lastest != null && lastest.key.compareTo(key) == 0)
        {
            lastest.value =  val;
            return;
        }
        root = put(root, key, val);
    }
    private Node put(Node x, Key key, Value val)
    {
        if(x == null)
        {
            Node pre = floor(root, key);
            Node nex = ceiling(root, key);
            lastest = new Node(key, val, 1, 1, 1);
            if(pre != null)
                pre.succ = lastest;
            if(nex !=null)
                nex.pred = lastest;
            lastest.succ = nex;
            lastest.pred = pre;
            return lastest;
        }
        int comp = key.compareTo(x.key);
        if(comp < 0) x.left = put(x.left, key, val);
        else if(comp > 0) x.right = put(x.right, key, val);
        else
        {
            lastest = x;
            x.value = val;
        }
        x.N = size(x.right) + size(x.left) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;
        x.avgCompares = (avgCompares(x.left) * size(x.left) + avgCompares(x.right) * size(x.right) + size(x)) / size(x);
        return x;
    }
    public Key min()
    {
        Node res = min(root);
        if(res == null)
            return null;
        else
            return res.key;
    }
    private Node min(Node x)
    {
        if(x.left == null)
            return x;
        else return min(x.left);
    }
    public Key max()
    {
        Node res = max(root);
        if(res == null)
            return null;
        else
            return res.key;
    }
    private Node max(Node x)
    {
        if(x.right == null)
            return x;
        else
            return max(x.right);
    }
    public Key floor(Key key)
    {
        Node res = floor(root, key);
        if(res == null)
            return null;
        else
            return res.key;
    }
    private Node floor(Node x, Key key)
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
    }
    public Key ceiling(Key key)
    {
        Node res = ceiling(root, key);
        if(res == null)
            return null;
        else
            return res.key;
    }
    private Node ceiling(Node x, Key key)
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
    }
    public Key select(int k)
    {
        Node res = select(root, k);
        if(res == null)
            return null;
        else
            return res.key;
    }
    private Node select(Node x, int k)
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
    }
    public int rank(Key key)
    {
        return rank(root, key);
    }
    private int rank(Node x, Key key)
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
        {
            if(x.pred != null)
                x.pred.succ = x.succ;
            if(x.succ != null)
                x.succ.pred = x.pred;
            return x.right;
        }
        x.left = deleteMin(x.left);
        x.N = size(x.left) + size(x.right) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;
        x.avgCompares = (avgCompares(x.left) * size(x.left) + avgCompares(x.right) * size(x.right) + size(x)) / size(x);
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
        {
            if(x.pred != null)
                x.pred.succ = x.succ;
            if(x.succ != null)
                x.succ.pred = x.pred;
            return x.left;
        }
        x.right = deleteMax(x.right);
        x.N = size(x.left) + size(x.right) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;
        x.avgCompares = (avgCompares(x.left) * size(x.left) + avgCompares(x.right) * size(x.right) + size(x)) / size(x);
        return x;
    }
    private Node deleteMaxWithOutDeleteThread(Node x)
    {
        if(x == null)
            return null;
        if(x.right == null)
        {
            return x.left;
        }
        x.right = deleteMax(x.right);
        x.N = size(x.left) + size(x.right) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;
        x.avgCompares = (avgCompares(x.left) * size(x.left) + avgCompares(x.right) * size(x.right) + size(x)) / size(x);
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
            {
                if(x.pred != null)
                    x.pred.succ = x.succ;
                if(x.succ != null)
                    x.succ.pred = x.pred;
                return x.right;
            }
            if(x.right == null)
            {
                if(x.pred != null)
                    x.pred.succ = x.succ;
                if(x.succ != null)
                    x.succ.pred = x.pred;
                return x.left;
            }
            Node t = max(x.left);
            t.left = deleteMaxWithOutDeleteThread(x.left);
            t.right = x.right;
            if(x.pred != null)
                x.pred.succ = x.succ;
            if(x.succ != null)
                x.succ.pred = x.pred;
            x= t;
        }
        x.N = size(x.left) + size(x.right) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;
        x.avgCompares = (avgCompares(x.left) * size(x.left) + avgCompares(x.right) * size(x.right) + size(x)) / size(x);
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
        StdOut.println(x.key + ":" + x.value + ":" + x.height + ":" + x.avgCompares);
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
    public Key randomKey()
    {
        int k = StdRandom.uniform(root.N);
        return select(k);
    }
    public boolean isBinaryTree()
    {
        return isBinaryTree(root);
    }
    private boolean isBinaryTree(Node x)
    {
        if(x == null)
            return true;
        if(x.left != null && x.key.compareTo(x.left.key) <= 0)
            return false;
        if(x.right != null && x.key.compareTo(x.right.key) >= 0)
            return false;
        if(size(x.left) + size(x.right) + 1 != size(x))
            return false;
        return isBinaryTree(x.left) && isBinaryTree(x.right);
    }
    public boolean isOrdered()
    {
        return isOrdered(root, min(), max());
    }
    private boolean isOrdered(Node x, Key min, Key max)
    {
        if(x == null)
            return true;
        if(x.key.compareTo(min) < 0 || x.key.compareTo(max) > 0)
            return false;
        return isOrdered(x.left, min, max) && isOrdered(x.right, min, max);
    }
    public boolean hasNoDuplicates()
    {
        return hasNoDuplicates(root);
    }
    private boolean hasNoDuplicates(Node x)
    {
        if(x == null)
            return false;
        if(x.left != null && x.key.compareTo(x.left.key) == 0)
            return true;
        if(x.right != null && x.key.compareTo(x.right.key) == 0)
            return true;
        return hasNoDuplicates(x.left) && hasNoDuplicates(x.right);
    }
    public boolean checkRankSelect()
    {
        for(int i = 0; i < root.N; ++i)
        {
            if(rank(select(i)) != i)
                return false;
        }
        return true;
    }
    public boolean checkSelectRank()
    {
        for(Key k : keys())
        {
            if(k.compareTo(select(rank(k))) != 0)
                return false;
        }
        return true;
    }
    public void levelOrderPrint()
    {
        Node x = root;
        Queue<Node> q = new Queue<Node>();
        q.enqueue(x);
        while (!q.isEmpty())
        {
            x = q.dequeue();
            StdOut.println(x.key + ":" + x.value);
            if(x.left != null)
                q.enqueue(x.left);
            if(x.right != null)
                q.enqueue(x.right);
        }
    }
    public Iterable<Key> keysNew()
    {
        return keysNew(min(), max());
    }
    public Iterable<Key> keysNew(Key mi, Key ma)
    {
        Node lo = ceiling(root, mi);
        Node hi = floor(root, ma);
        Node p = lo;
        Iter iter = new Iter(lo, hi);
        return iter;
    }
    public class Iter implements Iterable<Key>
    {
        Node start;
        Node end;
        public Iter(Node lo, Node hi)
        {
            start = lo;
            end = hi.succ;
        }
        public Iterator<Key> iterator()
        {
            return new Iterator<Key>() {
                @Override
                public boolean hasNext() {
                    return start != end;
                }

                @Override
                public Key next() {
                    Key k = start.key;
                    start = start.succ;
                    return k;
                }

                @Override
                public void remove() {
                    //To change body of implemented methods use File | Settings | File Templates.
                }
            };
        }
    }

    public Iterable<Key> keysNewReverse()
    {
        return keysNewReverse(min(), max());
    }
    public Iterable<Key> keysNewReverse(Key mi, Key ma)
    {
        Node lo = ceiling(root, mi);
        Node hi = floor(root, ma);
        Node p = lo;
        IterReverse iter = new IterReverse(lo, hi);
        return iter;
    }
    public class IterReverse implements Iterable<Key>
    {
        Node start;
        Node end;
        public IterReverse(Node lo, Node hi)
        {
            start = hi;
            end = lo.pred;
        }
        public Iterator<Key> iterator()
        {
            return new Iterator<Key>() {
                @Override
                public boolean hasNext() {
                    return start != end;
                }

                @Override
                public Key next() {
                    Key k = start.key;
                    start = start.pred;
                    return k;
                }

                @Override
                public void remove() {
                    //To change body of implemented methods use File | Settings | File Templates.
                }
            };
        }
    }

    public static void main(String[] args)
    {
        MyBST<String, Integer> bst = new MyBST<String, Integer>();
        In in = new In("binaryTree.txt");
        int N = in.readInt();
        for(int i = 0; i < N; ++i)
        {
            String s = in.readString();
            int v = in.readInt();
            bst.put(s, v);
        }
        bst.print();
/*        StdOut.println("max= " + bst.max() + ":" + bst.get(bst.max()));
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
        StdOut.println(bst.select(3)); */
        StdOut.println(bst.height());
        StdOut.println(bst.avgCompares());
        StdOut.println(bst.randomKey());
        StdOut.println(bst.get("d"));
        StdOut.println(bst.get("d"));
        bst.put("l", 11);
        StdOut.println(bst.get("l"));
        StdOut.println(bst.isBinaryTree());
        StdOut.println(bst.isOrdered());
        StdOut.println(bst.hasNoDuplicates());
        StdOut.println(bst.checkRankSelect());
        StdOut.println(bst.checkSelectRank());
        bst.levelOrderPrint();

        bst.deleteMax();
        bst.deleteMin();
        bst.delete("j");

        for(String s: bst.keysNew())
            StdOut.print(s + " ");
        StdOut.println();

        for(String s: bst.keysNewReverse())
            StdOut.print(s + " ");
        StdOut.println();

    }
}
