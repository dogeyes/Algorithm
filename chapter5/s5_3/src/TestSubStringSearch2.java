/**
 * Created with IntelliJ IDEA.
 * User: dogeyes
 * Date: 13-1-7
 * Time: 下午6:18
 * To change this template use File | Settings | File Templates.
 */
public class TestSubStringSearch2 {
    public static void main(String[] args)
    {
        In txtIn = new In("txt.txt");
        In patIn = new In("pat.txt");
        String txt = txtIn.readString();
        String pat = patIn.readString();

        /*MyKMPSubStringSearch kmp = new MyKMPSubStringSearch(pat);
        StdOut.println();*/

        MyKMPSubStringSearch bm = new MyKMPSubStringSearch(pat);
        int k = bm.search(txt);
        StdOut.println(txt);
        for(int i = 0; i < k; ++i)
            StdOut.print(" ");
        StdOut.println(pat);

        for(int i: bm.searchAll(txt))
        {
            for(int j = 0; j < i; ++j)
                StdOut.print(" ");
            StdOut.println(pat);
        }
    }
}
