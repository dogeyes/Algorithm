/**
 * Created with IntelliJ IDEA.
 * User: dexctor
 * Date: 12-12-16
 * Time: 下午6:29
 * To change this template use File | Settings | File Templates.
 */
public class TestBinarySearch {
    public static boolean testBinarySearch(int N)
    {
        MyBinarySearchST<Integer, Integer> st = new MyBinarySearchST<Integer, Integer>(N);
        for(int i = 0; i < N; ++i)
            st.put(i, i);
        assert st.min() == 0;
        assert st.max() == N - 1;
        StdOut.println("min= " + st.min());
        StdOut.println("max= " + st.max());

        st.deleteMax();
        st.deleteMin();
        assert st.min() == 1;
        assert st.max() == N - 2;
        StdOut.println("min= " + st.min());
        StdOut.println("max= " + st.max());

        for(int i = 0 ; i < N; i = i + 2)
            st.delete(i);
        StdOut.println("min= " + st.min());
        StdOut.println("max= " + st.max());

        for(int i = 0; i < N; ++i)
        {
            StdOut.println(st.floor(i));
        }

        for(int i = 0; i < N; ++i)
        {
            StdOut.println(st.ceiling(i));
        }

        StdOut.println(st.select(0));
        StdOut.println(st.rank(st.max()));

        for(Integer i : st.keys())
            StdOut.print(i + " ");
        return true;

    }
    public static void main(String[] args)
    {
        testBinarySearch(11);
    }
}
