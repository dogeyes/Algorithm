/**
 * Created with IntelliJ IDEA.
 * User: daixing
 * Date: 13-1-5
 * Time: 下午9:01
 * To change this template use File | Settings | File Templates.
 */
public class TestTrieST {
    public static void main(String[] args)
    {
        MytrieST<Integer> st = new MytrieST<Integer>();
        In in = new In("shellsST.txt");

        int count = 0;
        while (!in.isEmpty())
        {
            String s = in.readString();
            StdOut.print(s + " ");
            st.put(s, count++);
        }
        StdOut.println();
        StdOut.println(st.size());

        /*for(String s: st.keys())
        {
            StdOut.print(s + " ");
        }
        StdOut.println();
        for(String s: st.keysThatMatch(".he"))
        {
            StdOut.print(s + " ");
        }

        StdOut.println();
        StdOut.println(st.longestPrefixOf("shell"));
        StdOut.println();
        StdOut.println(st.keysWithPrefix("she"));
        */
        st.delete("she");
        StdOut.println(st.keys());
        StdOut.println(st.size());

        StdOut.println(st);
        for(String s: st.keys())
        {
            StdOut.println("floor " + s + " " + st.floor(s));
            StdOut.println("ceiling " + s + " " + st.ceiling(s));
            StdOut.println("rank " + s + " " + st.rank(s));
        }
        String s = "aa";

        StdOut.println("floor " + s + " " + st.floor(s));
        StdOut.println("ceiling " + s + " " + st.ceiling(s));
        StdOut.println("rank " + s + " " + st.rank(s));


        StdOut.println("Select: ");
        for(int i = 0; i < st.size(); ++i)
            StdOut.print(st.select(i) + " ");
        StdOut.println();
        s = "shec";
        StdOut.println("contains prefix " + s + " : " + st.containsPrefix(s));
    /*    MyTST<Integer> tst = new MyTST<Integer>();
        tst.put("object", 0);
        StdOut.println(tst.keys());
        tst.delete("object");
        StdOut.println(tst.keys());
        StdOut.println(tst.isEmpty());        */

    }
}
