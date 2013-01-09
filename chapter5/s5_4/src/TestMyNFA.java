import sun.misc.Regexp;

/**
 * Created with IntelliJ IDEA.
 * User: daixing
 * Date: 13-1-9
 * Time: 下午9:07
 * To change this template use File | Settings | File Templates.
 */
public class TestMyNFA {
    public static void main(String[] args)
    {
        In in = new In("tinyL.txt");
        String regexp = StdIn.readString();
        regexp = regexp;

        MyNFA19 nfa = new MyNFA19(regexp);
        while (!in.isEmpty())
        {
            String s = in.readLine();
            if(nfa.recognizes(s))
                StdOut.println(s);

        }

    }
}
