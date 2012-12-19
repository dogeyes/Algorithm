import java.awt.*;

/**
 * Created with IntelliJ IDEA.
 * User: daixing
 * Date: 12-12-19
 * Time: 下午8:35
 * To change this template use File | Settings | File Templates.
 */
public class TopDown23Tree<Key extends Comparable<Key>, Value> {
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
        put(root, key, val);
        root.color = BLACK;
    }
    /*private Node put(Node h, Key key, Value val)   //recursion implementation
    {
        if(h == null)
            return new Node(key, val, 1, RED, 0);

        if(isRed(h.left) && isRed(h.right))  //split 4 node
            flipColor(h);

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
            h = rotateRight(h);                       //adjust, let the median on the top of the node

        h.N = size(h.left) + size(h.right) + 1;
        h.height = Math.max(height(h.left), height(h.right)) + 1;
        return h;
    }*/

    private Node check4Node(Node x)
    {
        if(isRed(x.left) && isRed(x.left.left))
            return rotateRight(x);
        if(isRed(x.left) && isRed(x.left.right))
        {
            x.left = rotateLeft(x.left);
            return rotateRight(x);
        }
        return x;
    }

    private void put(Node h, Key key, Value val)
    {

        if(h == null)
            root = new Node(key, val, 1, RED, 0);
        root = check4Node(root);
        h = root;

        while (h != null)
        {
            Node tmp = h;
            int comp = key.compareTo(h.key);

            if(comp == 0)
            {
                h.val = val;
                return;
            }
            if(comp < 0)
            {
                if(h.left == null)
                {
                    h.left = new Node(key, val, 1, RED, 0);
                    return;
                }
                h.left = check4Node(h.left);

                if(!isRed(h.left) && isRed(h.left.right) && !isRed(h.left.left))
                {
                    h.left = rotateLeft(h.left);
                }

                if(isRed(h.left) && isRed(h.right))
                    flipColor(h);

                if(tmp == h)
                    h = h.left;
            }

            if(comp > 0)
            {
                if(h.right == null)
                {
                    h.right = new Node(key, val, 1, RED, 0);
                    return;
                }

                h.right = check4Node(h.right);

                if(!isRed(h.right) && isRed(h.right.right) && !isRed(h.right.left))
                {
                    h.right = rotateLeft(h.right);
                }


                if(isRed(h.left) && isRed(h.right))
                    flipColor(h);

                if(tmp == h)
                    h = h.right;
            }
        }
        return;
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
        int N = 80;
        TopDown23Tree<Integer, Integer> bst = new TopDown23Tree<Integer, Integer>();
        for(int i = 0; i < N; ++i)
        {
            int num = StdIn.readInt();
            bst.put(num, i);
            StdDraw.clear();
            bst.draw();
        }

        bst.draw();
    }
}

