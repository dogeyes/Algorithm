import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: daixing
 * Date: 12-12-22
 * Time: 下午3:07
 * To change this template use File | Settings | File Templates.
 */
public class DeDup {
    public static void main(String[] args)
    {
        In in = new In(args[0]);
        SET<String> words = new SET<String>();
        while (!in.isEmpty())
        {
            String s = in.readString();
            if(!words.contains(s))
            {
                StdOut.println(s);
                words.add(s);
            }
        }
    }
}
