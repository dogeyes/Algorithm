/**
 * Created with IntelliJ IDEA.
 * User: dexctor
 * Date: 12-12-17
 * Time: 下午8:00
 * To change this template use File | Settings | File Templates.
 */
public class PerfectBalance {
    public static void build(Integer[] a, int lo, int hi, MyBST<Integer, Integer> bst)
    {
        if(hi < lo)
            return;
        int mid = (hi + lo) / 2;
        bst.put(a[mid], mid);
        build(a, lo, mid - 1, bst);
        build(a, mid + 1, hi,  bst);
    }
    public static void main(String[] args)
    {
        int N = StdIn.readInt();
        Integer[] a= new Integer[N];
        for(int i = 0 ; i < N; ++i)
        {
            a[i] = i;
        }
        MyBST<Integer, Integer> bst = new MyBST<Integer, Integer>();
        build(a, 0, a.length - 1, bst);
        bst.print();
    }
}
