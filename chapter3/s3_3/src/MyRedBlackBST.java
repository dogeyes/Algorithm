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
    private int size(Node x)
    {
        if(x == null)
            return 0;
        else
            return x.N;
    }

    private void flipColor(Node h)
    {
        h.color = RED;
        h.right.color = BLACK;
        h.left.color = BLACK;

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
        int N = 50;
        MyRedBlackBST<Integer, Integer> bst = new MyRedBlackBST<Integer, Integer>();
        for(int i = 0; i < N; ++i)
        {
            bst.put(StdRandom.uniform(2 * N), i);
        }

        bst.draw();
    }

}
