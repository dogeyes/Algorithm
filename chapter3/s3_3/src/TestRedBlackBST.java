/**
 * Created with IntelliJ IDEA.
 * User: dexctor
 * Date: 12-12-20
 * Time: 下午2:55
 * To change this template use File | Settings | File Templates.
 */
public class TestRedBlackBST {
    public static void main(String[] args)
    {
        In in = new In("in.txt");
        int N = in.readInt();
        MyRedBlackBST<Integer, Integer> bst = new MyRedBlackBST<Integer, Integer>();
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
