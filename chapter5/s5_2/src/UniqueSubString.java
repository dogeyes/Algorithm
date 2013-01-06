/**
 * Created with IntelliJ IDEA.
 * User: dogeyes
 * Date: 13-1-6
 * Time: 下午4:22
 * To change this template use File | Settings | File Templates.
 */
public class UniqueSubString {
    public static void main(String[] args)
    {
        String s = StdIn.readString();

        MyTST<Object> tst = new MyTST<Object>();
        Object mark = new Object();

        for(int l = 1; l <= s.length(); ++l)
            for(int i = 0; i <= s.length() - l; ++i)
            {
                tst.put(s.substring(i, i + l), mark);
            }
        StdOut.println(tst.keys());
    }
}
