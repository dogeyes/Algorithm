import java.awt.*;

/**
 * Created with IntelliJ IDEA.
 * User: dexctor
 * Date: 12-12-20
 * Time: 上午8:48
 * To change this template use File | Settings | File Templates.
 */
public class AVLTree<Key extends Comparable<Key>, Value> {
    private Node root;
    private class Node
    {
        Key key;
        Value val;
        Node left;
        Node right;
        int height;
        int N;
        public Node(Key key, Value val, int n, int height)
        {
            this.key = key;
            this.val = val;
            this.N = n;
            this.height = height;
        }
    }
    public int size()
    {
        if(root == null)
            return 0;
        return root.N;
    }
    private int size(Node x)
    {
        if(x == null)
            return 0;
        else
            return x.N;
    }
    private int height(Node x)
    {
        if(x == null)
            return -1;
        else
            return x.height;
    }
    private Node rotateRight(Node h)
    {
        Node x = h.left;
        h .left = x.right;
        x.right = h;
        x.N = h.N;
        h.N = size(h.left) + size(h.right) + 1;
        h.height =Math.max(height(h.left), height(h.right)) + 1;
        x.height =Math.max(height(x.left), height(x.right)) + 1;
        return x;
    }
    private Node rotateLeft(Node h)
    {
        Node x = h.right;
        h.right = x.left;
        x.left = h;
        x.N = h.N;
        h.N = size(h.left) + size(h.right) + 1;
        h.height =Math.max(height(h.left), height(h.right)) + 1;
        x.height =Math.max(height(x.left), height(x.right)) + 1;
        return x;
    }
    public Value get(Key key)
    {
        Node res = get(root, key);
        if(res == null)
            return null;
        else
            return res.val;
    }
    private Node get(Node x,Key key)
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
    public void put(Key key, Value val)
    {
        root = put(root, key, val);
    }
    private Node put(Node x, Key key, Value val)
    {
        if(x == null)
            return new Node(key, val, 1, 0);
        int comp = key.compareTo(x.key);
        if(comp == 0)
        {
            x.val = val;
            return x;
        }
        else if(comp < 0)
            x.left = put(x.left, key, val);
        else
            x.right = put(x.right, key, val);

        x.height = Math.max(height(x.left), height(x.right)) + 1;

        if(height(x.left) > height(x.right) + 1)
        {
            if(height(x.left.right) > height(x.left.left))
                x.left = rotateLeft(x.left);
            if(height(x.left.left) > height(x.left.right))
                x = rotateRight(x);
        }
        if(height(x.left) + 1 < height(x.right))
        {
            if(height(x.right.left) > height(x.right.right))
                x.right = rotateRight(x.right) ;
            if(height(x.right.right) > height(x.right.left))
                x = rotateLeft(x);
        }
        return x;
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
    public void deleteMin()
    {
        root = deleteMin(root);
    }
    private Node deleteMin(Node h)
    {
        if(h.left == null && h.right == null)
            return null;
        if(height(h.left) < height(h.right))
        {
            if(height(h.right.left) > height(h.right.right))
                h.right = rotateRight(h.right);
            h = rotateLeft(h);
        }
        h.left = deleteMin(h.left);
        h.height = Math.max(height(h.left), height(h.right)) + 1;
        h.N = size(h.left) + size(h.right) + 1;
        return h;
    }

    public void deleteMax()
    {
        root = deleteMax(root);
    }
    private Node deleteMax(Node h)
    {
        if(h.left == null && h.right == null)
            return null;
        if(height(h.left) > height(h.right))
        {
            if(height(h.left.right) > height(h.left.left))
                h.left = rotateLeft(h.left);
            h = rotateRight(h);
        }
        h.right = deleteMax(h.right);
        h.height = Math.max(height(h.left), height(h.right)) + 1;
        h.N = size(h.left) + size(h.right) + 1;
        return h;
    }

    public void delete(Key key)
    {
        root = delete(root, key);
    }
    private Node delete(Node h, Key key)
    {
        if(h == null)
            return null;
        int comp = key.compareTo(h.key);
        if(comp < 0)
        {
            if(height(h.left) < height(h.right))
            {
                if(height(h.right.left) > height(h.right.right))
                    h.right = rotateRight(h.right);
                h = rotateLeft(h);
            }
            h.left = delete(h.left, key);
        }
        else if(comp > 0)
        {
            if(height(h.left) > height(h.right))
            {
                if(height(h.left.right) > height(h.left.left))
                    h.left = rotateLeft(h.left);
                h = rotateRight(h);
            }
            h.right = delete(h.right, key);
        }
        else
        {
            if(h.left == null && h.right == null)
                return null;
            if(height(h.left) > height(h.right))
            {
                if(height(h.left.right) > height(h.left.left))
                    h.left = rotateLeft(h.left);
                h = rotateRight(h);
                h.right = delete(h.right, key);
            }
            else
            {
                Node succ = min(h.right);
                succ.right = deleteMin(h.right);
                succ.left = h.left;
                h = succ;
            }
        }
        h.height = Math.max(height(h.left), height(h.right)) + 1;
        h.N = size(h.left) + size(h.right) + 1;
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
    private int badHegiht(Node x)
    {
        if(x == null)
            return -1;
        return Math.max(badHegiht(x.left), badHegiht(x.right)) + 1;
    }
    private int badNodeNumber(Node x)
    {
        if(x == null)
            return 0;
        return badNodeNumber(x.left) + badNodeNumber(x.right) + 1;
    }
    public void draw()
    {
        if(root == null)
            return;
        StdDraw.setPenColor(Color.BLACK);
        StdDraw.setPenRadius(0.005);
        int height = badHegiht(root);
        int N = badNodeNumber(root);
        StdDraw.setYscale(-1, height + 2);
        StdDraw.setXscale(-1, N  + 1);
        TreePosition rootTree = draw(root, 0, height);
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
        StdDraw.setPenColor(Color.BLUE);
        StdDraw.text(p.x, p.y, x.key.toString());
        StdDraw.setPenColor(Color.BLACK);
    }
    public static void main(String[] args)
    {
        In in = new In("in.txt");
        int N = in.readInt();
        AVLTree<Integer, Integer> bst = new AVLTree<Integer, Integer>();
        for(int i = 0; i < N; ++i)
        {
            int num = in.readInt();
            bst.put(num, i);
            StdDraw.clear();
            bst.draw();
        }
        StdOut.println(bst.min());
        StdOut.println(bst.max());
        while (bst.size() != 0)
        {
            int s = StdIn.readInt();
            bst.delete(s);
            StdDraw.clear();
            bst.draw();
            StdOut.println(bst.size());
        }
    }
}
