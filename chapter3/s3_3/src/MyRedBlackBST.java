import java.awt.*;

/**
 * Created with IntelliJ IDEA.
 * User: daixing
 * Date: 12-12-18
 * Time: 下午10:30
 * To change this template use File | Settings | File Templates.
 */
public class MyRedBlackBST<Key extends Comparable<Key>, Value> {
    private Node root;
    private static final boolean BLACK = false;
    private static final boolean RED = true;
    private class Node
    {
        Key key;
        Value val;
        Node left;
        Node right;
        boolean color;
        int N;
        int height;
        public Node(Key key, Value val, int N, boolean color, int height)
        {
            this.key = key;
            this.val = val;
            this.N = N;
            this.color = color;
            this.height = height;
        }
    }
    private boolean isRed(Node x)
    {
        if(x == null)
            return false;
        return x.color == RED;
    }
    private int height(Node x)
    {
        if(x == null)
            return -1;
        else
            return x.height;
    }
    public boolean isEmpty()
    {
        return root == null;
    }
    public Value get(Key key)
    {
        Node res = get(root, key);
        if(res == null)
            return  null;
        else
            return res.val;
    }
    private Node get(Node x, Key key)
    {
        if(x == null)
            return null;
        int comp = key.compareTo(x.key);
        if(comp == 0)
            return x;
        else if(comp < 0)
            return get(x.left, key);
        else
            return get(x.right, key);
    }
    private Node rotateLeft(Node h)
    {
        Node x = h.right;
        h.right = x.left;
        x.left = h;
        x.color = h.color;
        h.color = RED;
        x.N = h.N;
        h.N = size(h.left) + size(h.right) + 1;
        h.height = Math.max(height(h.left), height(h.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;
        return x;
    }
    private Node rotateRight(Node h)
    {
        Node x = h.left;
        h.left = x.right;
        x.right = h;
        x.color = h.color;
        h.color = RED;
        x.N = h.N;
        h.N = size(h.left) + size(h.right) + 1;
        h.height = Math.max(height(h.left), height(h.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;
        return x;
    }
    public int size()
    {
        if(root == null)
            return 0;
        else
            return root.N;
    }
    private Node moveRedLeft(Node h)
    {
        flipColor(h);
        if(isRed(h.right.left))
        {
            h.right = rotateRight(h.right);
            h = rotateLeft(h);
            // 为什么这里不用flipColor,把它变得比较合乎情理
            flipColor(h);
            //貌似在balance的时候会balance回来的,但是这样一但省略,就搞不清楚什么状况了
            //加上程序还会错了吗?
            //我擦泪
            //突然想到,如果出现
            /*
                            黑
                         红     红
                       红
               情况,照balance,先是左转,这样就3连红了,因为有两个
               连红,所以再右转,相当于没转啊,给跪了,然后再flip颜色,

                有空要把详细情况写一下
             */
        }
        return h;
    }

    public void deleteMin()
    {
        if(!isRed(root.left) && !isRed(root.right))
            root.color = RED;
        root = deleteMin(root);
        if(!isEmpty()) root.color = BLACK;
    }
    private Node deleteMin(Node h)
    {
        if(h.left == null)
            return null;
        if(!isRed(h.left) && !isRed(h.left.left)) //left is a 2 node
            h = moveRedLeft(h);
        h.left = deleteMin(h.left);
        return balance(h);
    }
    public void deleteMax()
    {
        if(!isRed(root.left) && !isRed(root.right))
            root.color = RED;
        root = deleteMax(root);
        if(!isEmpty()) root.color = BLACK;
    }
    private Node deleteMax(Node h)
    {
        if(isRed(h.left))  //先变成right leaning 再进行考虑
            h = rotateRight(h);
        if(h.right == null)
            return null;
        if(!isRed(h.right) && !isRed(h.right.left))
            h = moveRedRight(h);
        h.right = deleteMax(h.right);
        return balance(h);
    }
    private Node moveRedRight(Node h)
    {
        flipColor(h);
        if(isRed(h.left.left))
        {
            h = rotateRight(h);
            flipColor(h);
        }
        return h;
    }
    public void delete(Key key)
    {
        if(!isRed(root.left) && !isRed(root.right))
            root.color = RED;
        root = delete(root, key);
        if(root != null)
            root.color = BLACK;
    }
    private Node delete(Node h, Key key)
    {
        int cmp = key.compareTo(h.key);
        if(h == null|| (cmp < 0 && h.left == null) ||
                (cmp > 0 && h.right == null))
            return h;
        if(key.compareTo(h.key) < 0)
        {
            if(!isRed(h.left) && !isRed(h.left.left)) //left is a 2 node
                h = moveRedLeft(h);
            h.left = delete(h.left, key);
        }
        else
        {
            if(isRed(h.left))
                h = rotateRight(h);
            if(key.compareTo(h.key) == 0 && (h.right == null))
                return null;
            if(!isRed(h.right) && !isRed(h.right.left))
                h = moveRedRight(h);
            if(key.compareTo(h.key) == 0)
            {
                h.val = get(h.right, min(h.right).key).val;
                h.key = min(h.right).key;
                h.right = deleteMin(h.right);
            }
            else
                h.right = delete(h.right, key);
        }
        return balance(h);
    }

    private Node balance(Node h)
    {
        if(isRed(h.right))
            h = rotateLeft(h);
        if(isRed(h.left) && isRed(h.left.left))
            h = rotateRight(h);
        if(isRed(h.left) && isRed(h.right))
            flipColor(h);
        h.N = size(h.left) + size(h.right) + 1;
        h.height = Math.max(height(h.left), height(h.right)) + 1;
        return h;
    }
    private int size(Node x)
    {
        if(x == null)
            return 0;
        else
            return x.N;
    }

    private void flipColor(Node h)
    {
        if(isRed(h))
        {
            h.color = BLACK;
            h.left.color = RED;
            h.right.color = RED;
        }
        else
        {
            h.color = RED;
            h.right.color = BLACK;
            h.left.color = BLACK;
        }
    }
    public void put(Key key, Value val)
    {
        root = put(root, key, val);
        root.color = BLACK;
    }
    private Node put(Node h, Key key, Value val)
    {
        if(h == null)
            return new Node(key, val, 1, RED, 0);
        int cmp = key.compareTo(h.key);
        if(cmp < 0)
            h.left = put(h.left, key,val);
        else if(cmp > 0)
            h.right = put(h.right, key, val);
        else
            h.val = val;

        if(isRed(h.right) && ! isRed(h.left))
            h = rotateLeft(h);
        if(isRed(h.left) && isRed(h.left.left))
            h = rotateRight(h);
        if(isRed(h.left) && isRed(h.right))
            flipColor(h);

        h.N = size(h.left) + size(h.right) + 1;
        h.height = Math.max(height(h.left), height(h.right)) + 1;
        return h;
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
        StdOut.println(x.key + ":" + x.val + ":" + x.height);
        print(x.right);
    }

    public Key min()
    {
        return min(root).key;
    }
    private Node min(Node x)
    {
        if(x.left == null)
            return x;
        else
            return min(x.left);
    }
    public Key max()
    {
        Node h = root;
        while (h.right != null)
            h = h.right;
        return h.key;
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

    public boolean is23()
    {
        return is23(root);
    }
    private boolean is23(Node x)
    {
        if(x == null)
            return true;
        if(isRed(x.left) && isRed(x.right))
            return false;
        else
            return is23(x.left) && is23(x.right);
    }

    public boolean isBalance()
    {
        int le =  blackBalance(root.left);
        int ri = blackBalance(root.right);
        if(le == ri && le != -2)
            return true;
        return false;
    }
    private int blackBalance(Node x)
    {
        if(x == null)
            return -1;
        int le =  blackBalance(root.left);
        int ri = blackBalance(root.right);
        if(le == ri && le != -2)
        {
            if(!isRed(x))
                return ri + 1;
        }
        return -2;
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
    public void draw(Node x)
    {
        StdDraw.clear();
        StdDraw.setPenColor(Color.BLACK);
        StdDraw.setPenRadius(0.005);
        StdDraw.setYscale(-1, x.height + 2);
        StdDraw.setXscale(-1, x.N  + 1);
        TreePosition rootTree = draw(x, 0, x.height);
        drawNode(rootTree, x);
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
        if(!isRed(x))
            StdDraw.setPenColor(Color.GREEN);
        else
            StdDraw.setPenColor(Color.RED);
        StdDraw.filledCircle(p.x, p.y, 0.3);
        StdDraw.setPenColor(Color.BLUE);
        StdDraw.text(p.x, p.y, x.key.toString());
        StdDraw.setPenColor(Color.BLACK);
    }
    public static void main(String[] args)
    {
        MyRedBlackBST<Integer, Integer> bst = new MyRedBlackBST<Integer, Integer>();
        int num = StdIn.readInt();
        while (num != 0)
        {
            bst.put(num, num);
            bst.draw();
            num = StdIn.readInt();
        }
        StdOut.println(bst.min());
        StdOut.println(bst.max());
        while (bst.size() != 0)
        {
            int s = StdIn.readInt();
            bst.delete(s);
            bst.draw();
            StdOut.println(bst.size());
        }
    }
}
