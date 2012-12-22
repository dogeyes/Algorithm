import java.awt.*;
import java.util.Iterator;

/**
 * Created with IntelliJ IDEA.
 * User: dexctor
 * Date: 12-12-22
 * Time: 下午8:18
 * To change this template use File | Settings | File Templates.
 */
public class MultiBST<Key extends Comparable<Key>, Value> {
    private Node root;
    private class Node
    {
        Key key;
        Value value;
        Node right;
        Node left;
        int height;
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
    public Value get(Key key)
    {
        Node res = get(root, key);
        if(res == null)
            return null;
        else
        {
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
        root = put(root, key, val);
    }
    private Node put(Node x, Key key, Value val)
    {
        if(x == null)
        {
            return new Node(key, val, 1);
        }
        int comp = key.compareTo(x.key);
        if(comp <= 0) x.left = put(x.left, key, val);
        else if(comp > 0) x.right = put(x.right, key, val);

        x.N = size(x.right) + size(x.left) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;
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
    public void deleteAllMin()
    {
        Key min = min();
        delete(min);
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
            return x.right;
        }
        x.left = deleteMin(x.left);
        x.N = size(x.left) + size(x.right) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;
        return x;
    }
    public void deleteAllMax()
    {
        Key max = max();
        delete(max);
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
            return x.left;
        }
        x.right = deleteMax(x.right);
        x.N = size(x.left) + size(x.right) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;
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
                return delete(x.right, key);
            }
            if(x.right == null)
            {
                return delete(x.left, key);
            }
            Node t = max(x.left);
            t.left = deleteMax(x.left);
            t.right = x.right;
            t = delete(t,key);
            x= t;
        }
        x.N = size(x.left) + size(x.right) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;
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
        StdOut.println(x.key + ":" + x.value + ":" + x.height );
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

    private class TreePosition
    {
        double x;
        double y;
        double left;
        double right;
        public TreePosition(double x, double y, double l, double r)
        {
            this.x = x;
            this.y = y;
            left = l;
            right = r;
        }
    }
    public void draw()
    {
        StdDraw.setPenColor(Color.BLACK);
        StdDraw.setPenRadius(0.005);
        StdDraw.setYscale(-1, root.height + 2);
        StdDraw.setXscale(-1, root.N  + 1);
        StdDraw.clear();
        TreePosition rootTree = draw(root, 0, root.height);
        drawNode(rootTree, root);
    }
    private TreePosition draw(Node x, double leftBorder, double h)
    {
        if(x == null)
        {
            StdDraw.setPenRadius(0.02);
            StdDraw.point(leftBorder,h);
            StdDraw.setPenRadius(0.005);
            return new TreePosition(leftBorder,h,leftBorder, leftBorder + 1);
        }
        TreePosition leftTree = draw(x.left, leftBorder, h - 1);
        TreePosition rightTree = draw(x.right, leftTree.right, h - 1);
        TreePosition xTree = new TreePosition((leftTree.x + rightTree.x) / 2, h, leftTree.left, rightTree.right);
        StdDraw.line(leftTree.x, leftTree.y, xTree.x, xTree.y);
        StdDraw.line(rightTree.x, rightTree.y, xTree.x, xTree.y);

        if(x.left != null)
            drawNode(leftTree, x.left);
        if(x.right != null)
            drawNode(rightTree, x.right);
        return xTree;
    }
    private void drawNode(TreePosition p, Node x)
    {
        StdDraw.setPenColor(Color.GREEN);
        StdDraw.filledCircle(p.x, p.y, 0.3);
        StdDraw.setPenColor(Color.RED);
        StdDraw.text(p.x, p.y, x.key.toString());
        StdDraw.setPenColor(Color.BLACK);
    }

    public static void main(String[] args)
    {
        MultiBST<Integer, Integer> bst = new MultiBST<Integer, Integer>();

        int s = StdIn.readInt();
        int count = 0;
        while (s != 0)
        {
            bst.put(s, count);
            bst.draw();
            count ++;
            s = StdIn.readInt();
        }

        s = StdIn.readInt();
        while (s != 0)
        {
            bst.delete(s);
            bst.draw();
            s = StdIn.readInt();
        }

        bst.draw();

    }
}
